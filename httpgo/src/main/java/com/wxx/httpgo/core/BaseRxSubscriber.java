
package com.wxx.httpgo.core;

import android.text.TextUtils;

import java.io.IOException;

import retrofit2.HttpException;
import rx.Subscriber;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.http
 * 邮箱：996489865@qq.com
 * TODO:可继承实现更多功能
 */

public abstract class BaseRxSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        String errorMsg;
        if (e instanceof IOException) {
            //没有网络
            errorMsg = "Please check your network status";
        } else if (e instanceof HttpException) {
            ///网络异常，http 请求失败，即 http 状态码不在 [200, 300) 之间, such as: "server internal error".
            errorMsg = ((HttpException) e).response().message();
        } else {
            // 其他未知错误
            errorMsg = !TextUtils.isEmpty(e.getMessage()) ? e.getMessage() : "unknown error";
        }
        onFail(errorMsg);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    /**
     * success
     *
     * @param t .
     */
    public abstract void onSuccess(T t);

    /**
     * fail
     *
     * @param var .
     */
    public abstract void onFail(String var);

}
