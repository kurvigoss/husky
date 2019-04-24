package com.husky.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by gexiaobing on 2019-04-23
 *
 * @description TODO
 */
@Component
public class SwaggerProvider implements SwaggerResourcesProvider{

    public static final String API_URI = "/v2/api-docs";

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    DiscoveryLocatorProperties discoveryLocatorProperties;

    private final SimpleEvaluationContext evalCtxt;

    public SwaggerProvider() {
        this.evalCtxt =  SimpleEvaluationContext.forReadOnlyDataBinding()
                .withInstanceMethods()
                .build();
    }

    @Override
    public List<SwaggerResource> get() {
        /**
         * 参照DiscoveryClientRouteDefinitionLocator写法,
         * 通过spring.cloud.gateway.discovery.locator.include-expression可以配置需要包含的微服务
         */
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression includeExpr = parser.parseExpression(discoveryLocatorProperties.getIncludeExpression());
        Predicate<ServiceInstance> includePredicate;
        if (discoveryLocatorProperties.getIncludeExpression() == null || "true".equalsIgnoreCase(discoveryLocatorProperties.getIncludeExpression())) {
            includePredicate = instance -> true;
        } else {
            includePredicate = instance -> {
                Boolean include = includeExpr.getValue(evalCtxt, instance, Boolean.class);
                if (include == null) {
                    return false;
                }
                return include;
            };
        }
        return discoveryClient.getServices().stream()
                .map(discoveryClient::getInstances)
                .filter(instances -> !instances.isEmpty())
                .map(instances -> instances.get(0))
                .filter(includePredicate)
                .map(instance->{
                    String serviceId = instance.getServiceId();
                    return swaggerResource(serviceId, "/" + serviceId + API_URI);
                 })
                .collect(Collectors.toList());
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
