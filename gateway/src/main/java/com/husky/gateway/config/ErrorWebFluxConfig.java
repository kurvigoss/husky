package com.husky.gateway.config;

import com.husky.gateway.handler.HuskyWebFluxErrorHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gexiaobing on 2019-04-22
 *
 * @description TODO
 */
@Configuration
public class ErrorWebFluxConfig {

    private final ServerProperties serverProperties;

    private final ApplicationContext applicationContext;

    private final ResourceProperties resourceProperties;

    private final List<ViewResolver> viewResolvers;

    private final ServerCodecConfigurer serverCodecConfigurer;

    public ErrorWebFluxConfig(ServerProperties serverProperties,
                         ResourceProperties resourceProperties,
                         ObjectProvider<ViewResolver> viewResolversProvider,
                         ServerCodecConfigurer serverCodecConfigurer,
                         ApplicationContext applicationContext) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resourceProperties;
        this.viewResolvers = viewResolversProvider.orderedStream()
                .collect(Collectors.toList());
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order(-1)
    public ErrorWebExceptionHandler errorWebExceptionHandler(
            ErrorAttributes errorAttributes) {
        HuskyWebFluxErrorHandler exceptionHandler = new HuskyWebFluxErrorHandler(
                errorAttributes, this.resourceProperties,
                this.serverProperties.getError(), this.applicationContext);
        exceptionHandler.setViewResolvers(this.viewResolvers);
        exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }
}
