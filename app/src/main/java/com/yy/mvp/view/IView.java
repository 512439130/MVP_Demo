package com.yy.mvp.view;

import com.yy.mvp.base.BaseIView;
import com.yy.mvp.bean.User;

/**
 * IView接口：定义视图逻辑
 */
public interface IView<T> extends BaseIView<T> {

    /**
     * 显示dialog
     */
    void showProgressDialog();

    /**
     * 隐藏dialog
     */
    void hideProgressDialog();

    /**
     * 登录成功(登录结果进行UI更新)
     */
    void loginOnSuccess(User user);

    /**
     * 登录失败(登录结果进行UI更新)
     */
    void loginOnFailure(String msg);

    /**
     * toast提示信息
     */
    void showMessage(String msg);
}
