package com.yy.mvp.presenter;

/**
 * 中间桥梁（Presenter接口作为连接Model和View的中间桥梁）
 */
public interface IPresenter {
    void login(String user, String pass);
}
