package com.husky.test;

import com.husky.user.constant.UserAPIConsts;
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
        UserAPIConsts.API_PACKAGE
})
public class TestServerBoot {

    public static void main(String[] args) {
        SpringApplication.run(TestServerBoot.class,args);
    }
}
