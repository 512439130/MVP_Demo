package com.yy.mvp.bean;

/**
 * 用户类
 */
public class User {
    String username;
    String sex;
    String age;

    public User(String username, String sex, String age) {
        this.username = username;
        this.sex = sex;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "username='" + username + '\n' +
                "sex='" + sex + '\n' +
                "age='" + age + '\n';
    }
}
