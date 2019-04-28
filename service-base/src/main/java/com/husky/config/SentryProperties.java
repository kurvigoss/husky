package com.husky.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by gexiaobing on 2019-04-28
 *
 * @description TODO
 */
@ConfigurationProperties(prefix = "husky.sentry")
public class SentryProperties {

    private String dsn;

    private String email;

    private String userName;

    public String getDsn() {
        return dsn;
    }

    public void setDsn(String dsn) {
        this.dsn = dsn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
