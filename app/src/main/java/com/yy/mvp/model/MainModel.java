package com.yy.mvp.model;

import android.os.Handler;
import android.os.Looper;

import com.yy.mvp.bean.User;

/**
 * IModel实现类：业务逻辑实现和编写
 * Model层无View层和Presenter的引用，解耦
 */

public class MainModel implements IModel{
    @Override
    public void login(String user, String pass, Callback callback) {
        //模拟网络请求
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user.equals("yy") && pass.equals("123")){
                    callback.onSuccess(new User("SoMustYY","男","27"));
                } else {
                    callback.onFailure("登录失败: 账号密码有误");
                }
            }
        },1500);
    }

    @Override
    public String checkInput(String user, String pass) {
        if(user.isEmpty() || pass.isEmpty()){
            return "账号和密码不能为空";
        }
        return null;
    }
}
