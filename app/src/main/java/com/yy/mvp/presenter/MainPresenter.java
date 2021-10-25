package com.yy.mvp.presenter;

import com.yy.mvp.model.Callback;
import com.yy.mvp.model.IModel;
import com.yy.mvp.model.MainModel;
import com.yy.mvp.bean.User;
import com.yy.mvp.view.IView;

/**
 * Presenter实现类 
 * 1.（视图逻辑层）的事件向（业务逻辑层）传递
 * 2.（业务逻辑层）执行过程中，P层调用控制视图层视图逻辑
 * Presenter只引用Model层和View层的接口，解耦
 */
public class MainPresenter<T> implements IPresenter, Callback {
    private final IModel mainModel;
    private final IView<IPresenter> mainView;

    public MainPresenter(IView<IPresenter> view) {
        this.mainModel = new MainModel();
        this.mainView = view;
        this.mainView.setPresenter(this);
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
