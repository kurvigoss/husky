package com.husky;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * Created by gexiaobing on 2019-04-23
 *
 * @description TODO
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
@ComponentScan("com.husky")
public @interface HuskyApplication {
}
