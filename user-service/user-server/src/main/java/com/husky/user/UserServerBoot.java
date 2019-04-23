package com.husky.user;

import com.husky.HuskyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 启动类
 */
@HuskyApplication
public class UserServerBoot{

    public static void main(String[] args) {
        SpringApplication.run(UserServerBoot.class,args);
    }

}
