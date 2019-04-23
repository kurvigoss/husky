package com.husky.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by gexiaobing on 2019-04-23
 *
 * @description swagger配置属性
 */
@ConfigurationProperties(prefix = "husky.swagger")
public class SwaggerProperties {

    private String basePackage;

    private String title;

    private String description;

    private String owner;

    private String email;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
