package com.husky.user;

import com.husky.annotation.HuskyApplication;
import org.springframework.boot.SpringApplication;

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
