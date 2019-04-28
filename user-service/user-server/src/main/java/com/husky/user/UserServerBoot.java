package com.husky.user;

import com.husky.annotation.HuskyApplication;
import com.husky.user.dto.UserDTO;
import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.SentryClientFactory;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 启动类
 */
@HuskyApplication
public class UserServerBoot{

    public static void main(String[] args){
        SpringApplication.run(UserServerBoot.class,args);
    }

}
