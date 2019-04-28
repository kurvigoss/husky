package com.husky.handler;

import com.alibaba.fastjson.JSONObject;
import com.husky.config.SentryProperties;
import io.sentry.Sentry;
import io.sentry.event.User;
import io.sentry.event.UserBuilder;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description sentry处理类
 */
public class SentryHandler implements InitializingBean {

    private final SentryProperties sentryProperties;
    private User user;

    public SentryHandler(SentryProperties sentryProperties){
        this.sentryProperties = sentryProperties;
    }

    /**
     * 捕获api Exception至sentry
     */
    public void captureApiException(String uri, JSONObject argsJSON, Exception e){
        Sentry.getContext().clear();
        Sentry.getContext().addTag("URI",uri);
        Sentry.getContext().addTag("ARGS",argsJSON.toJSONString());
        Sentry.getContext().setUser(user);
        Sentry.capture(e);
    }

    @Override
    public void afterPropertiesSet(){
        Sentry.init(sentryProperties.getDsn());
        user = new UserBuilder()
                .setUsername(sentryProperties.getUserName())
                .setEmail(sentryProperties.getEmail()).build();
    }
}
