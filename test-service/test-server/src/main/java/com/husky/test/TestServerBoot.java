package com.husky.test;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 启动类
 */
@SpringCloudApplication
@EnableFeignClients({
        "com.husky.user.api"
})
public class TestServerBoot {

    public static void main(String[] args) {
        SpringApplication.run(TestServerBoot.class,args);
    }
}
