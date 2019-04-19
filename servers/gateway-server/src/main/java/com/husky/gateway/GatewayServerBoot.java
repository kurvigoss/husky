package com.husky.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * Created by gexiaobing on 2019-04-18
 *
 * @description 启动类
 */
@SpringCloudApplication
public class GatewayServerBoot {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerBoot.class,args);
    }

}
