package com.yy.mvp.presenter;

/**
 * IPresenter接口：作为连接Model和View的中间桥梁
 */
public interface IPresenter {
    void login(String user, String pass);
}
