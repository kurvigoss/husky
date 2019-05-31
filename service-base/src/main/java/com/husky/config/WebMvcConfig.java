package com.husky.config;

import com.husky.handler.HuskyInvocableHandleMethod;
import com.husky.interceptor.PathPatternInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.util.List;

/**
 * Created by gexiaobing on 2019-04-25
 *
 * @description 自定义webMvc组件注册、webMvc配置
 */
@Configuration
public class WebMvcConfig implements WebMvcRegistrations, WebMvcConfigurer {

    @Autowired(required = false)
    List<PathPatternInterceptor> interceptorList;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(!CollectionUtils.isEmpty(interceptorList)){
            interceptorList.forEach(interceptor -> {
                registry.addInterceptor(interceptor).addPathPatterns(interceptor.getPathPattern());
            });
        }
    }

    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new HuskyRequestMappingHandlerMapping();
    }

    @Override
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        return new HuskyRequestMappingHandlerAdapter();
    }

    /**
     * @description
     *  1. 重写RequestMappingHandlerMapping：只将有Controller注解的bean判定为handler,解决了FeignClient和它的Hystrix fallback注册到mappingRegistry的问题
     */
    class HuskyRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

        @Override
        protected boolean isHandler(Class<?> beanType) {
            return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
        }
    }

    /**
     * @description
     * 1. 重写RequestMappingHandlerAdapter中createInvocableHandlerMethod方法，替换为HuskyInvocableHandleMethod
     */
    class HuskyRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

        @Override
        protected ServletInvocableHandlerMethod createInvocableHandlerMethod(HandlerMethod handlerMethod) {
            return new HuskyInvocableHandleMethod(handlerMethod);
        }
    }

}
