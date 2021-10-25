package com.yy.mvp.presenter;

import com.yy.mvp.base.BasePresenter;

/**
 * IPresenter接口：作为连接Model和View的中间桥梁
 */
public interface IPresenter extends BasePresenter {
    void login(String user, String pass);
}
