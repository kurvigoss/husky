package com.husky.config;

import com.husky.handler.HuskyRequestMappingHandlerAdapter;
import com.husky.handler.HuskyRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by gexiaobing on 2019-04-25
 *
 * @description 自定义webMvc组件注册
 */
@Component
public class HuskyWebMvcRegistrations implements WebMvcRegistrations {

    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new HuskyRequestMappingHandlerMapping();
    }

    @Override
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        return new HuskyRequestMappingHandlerAdapter();
    }
}
