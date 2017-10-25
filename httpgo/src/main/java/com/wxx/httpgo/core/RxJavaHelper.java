package com.wxx.httpgo.core;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.http
 * 邮箱：996489865@qq.com
 * TODO:Rxjava切换线程
 */

public class RxJavaHelper {
    /**
     * 切换线程操作
     *
     * @return Observable转换器
     */
    public static <T> Observable.Transformer<T, T> observeOnMainThread() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        // 在io线程中请求
                        .subscribeOn(Schedulers.io())
                        // 请求完成后返回主线程处理
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
