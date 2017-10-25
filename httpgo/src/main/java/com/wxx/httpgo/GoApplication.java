package com.wxx.httpgo;

import android.app.Application;

/**
 * 作者: Tangren on 2017-10-24
 * 包名：com.wxx.httpgo
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class GoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private volatile static GoApplication instance = null;

    public static GoApplication getInstance() {
        if (instance == null) {
            synchronized (GoApplication.class) {
                if (instance == null) {
                    instance = new GoApplication();
                }
            }
        }
        return instance;
    }

}
