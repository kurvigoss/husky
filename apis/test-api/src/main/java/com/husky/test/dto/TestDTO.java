package com.husky.test.dto;

import java.io.Serializable;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description TODO
 */
public class TestDTO implements Serializable {

    private String testName;

    private String userJsonData;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getUserJsonData() {
        return userJsonData;
    }

    public void setUserJsonData(String userJsonData) {
        this.userJsonData = userJsonData;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "testName='" + testName + '\'' +
                ", userJsonData='" + userJsonData + '\'' +
                '}';
    }
}
