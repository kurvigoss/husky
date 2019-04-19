package com.husky.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gexiaobing on 2019-04-18
 *
 * @description TODO
 */
@Configuration
public class DiscoveryConfig {

    @Autowired
    DiscoveryClient discoveryClient;

    @Bean
    @ConditionalOnMissingBean(DiscoveryClientRouteDefinitionLocator.class)
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
            DiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }
}
