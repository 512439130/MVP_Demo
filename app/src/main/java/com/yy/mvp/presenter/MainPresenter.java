package com.yy.mvp.presenter;

import com.yy.mvp.model.Callback;
import com.yy.mvp.model.IModel;
import com.yy.mvp.model.MainModel;
import com.yy.mvp.bean.User;
import com.yy.mvp.view.IView;

/**
 * Presenter实现类
 */
public class MainPresenter implements IPresenter, Callback{
    private IModel mainModel;
    private IView mainView;

    public MainPresenter(IView view){
        mainModel = new MainModel();
        this.mainView = view;
    }

    @Override
    public void login(String user, String pass) {
        String message = mainModel.checkInput(user,pass);
        if(message != null){
            mainView.showMessage(message);
            return;
        }
        mainView.showProgressDialog();
        mainModel.login(user, pass, this);
    }

    @Override
    public void onSuccess(User user) {
        mainView.hideProgressDialog();
        mainView.loginOnSuccess(user);
    }

    @Override
    public void onFailure(String msg) {
        mainView.hideProgressDialog();
        mainView.loginOnFailure(msg);
    }
}
