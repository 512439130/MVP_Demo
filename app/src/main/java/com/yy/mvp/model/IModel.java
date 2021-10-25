package com.yy.mvp.model;

/**
 * IModel接口：定义业务逻辑
 */
public interface IModel {
    void login(String user, String pass, Callback callback);
    String checkInput(String user,String pass);
}
