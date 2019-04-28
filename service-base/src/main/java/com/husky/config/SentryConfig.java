package com.husky.config;

import com.husky.handler.SentryHandler;
import io.sentry.Sentry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description TODO
 */
@Configuration
@ConditionalOnProperty(prefix = "husky.sentry",name = "enabled",havingValue = "true")
@EnableConfigurationProperties(SentryProperties.class)
@ConditionalOnClass(Sentry.class)
public class SentryConfig {

    @Autowired
    SentryProperties sentryProperties;

    @Bean
    public SentryHandler sentryHandler(){
        return new SentryHandler(sentryProperties);
    }
}
