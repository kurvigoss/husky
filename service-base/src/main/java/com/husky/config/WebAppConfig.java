package com.husky.config;

import com.husky.interceptor.PathPatternInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description WebMvcConfigurer配置实现
 */
@Component
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired(required = false)
    List<PathPatternInterceptor> interceptorList;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(!CollectionUtils.isEmpty(interceptorList)){
            interceptorList.forEach(interceptor -> {
                registry.addInterceptor(interceptor).addPathPatterns(interceptor.getPathPattern());
            });
        }
    }
}
