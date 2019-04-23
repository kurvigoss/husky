package com.husky.annotation;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * Created by gexiaobing on 2019-04-23
 *
 * @description Husky应用注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
@ComponentScan("com.husky")
public @interface HuskyApplication {
}
