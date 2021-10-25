package com.yy.mvp.base;

public interface BaseIView<T> {
    /**
     * 规范View接口和Presenter接口的绑定的方法
     * @param presenter
     */
    void setPresenter(T presenter);
}
