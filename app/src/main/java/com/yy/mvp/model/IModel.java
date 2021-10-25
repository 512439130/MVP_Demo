package com.yy.mvp.model;

public interface IModel {
    void login(String user, String pass, Callback callback);
    String checkInput(String user,String pass);
}
