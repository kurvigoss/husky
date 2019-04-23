package com.husky.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 启动类
 */
@SpringCloudApplication
@EnableSwagger2
public class UserServerBoot {

    public static void main(String[] args) {
        SpringApplication.run(UserServerBoot.class,args);
    }

}
