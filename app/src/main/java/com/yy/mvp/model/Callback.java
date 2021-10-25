package com.yy.mvp.model;

import com.yy.mvp.bean.User;

public interface Callback {
    void onSuccess(User user);
    void onFailure(String msg);
}
