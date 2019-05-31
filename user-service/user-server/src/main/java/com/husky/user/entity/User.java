package com.husky.user.entity;

import java.io.Serializable;

/**
 * Created by gexiaobing on 2019-05-31
 *
 * @description TODO
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private Boolean sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
