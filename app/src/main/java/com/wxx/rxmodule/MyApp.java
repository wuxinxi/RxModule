package com.wxx.rxmodule;

import com.wxx.httpgo.GoApplication;
import com.wxx.httpgo.core.HttpGoConfig;
import com.wxx.httpgo.core.RetrofitHelper;
import com.wxx.rxmodule.util.AppUtil;
import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class MyApp extends GoApplication {

    private volatile static MyApp instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppUtil.syncISDebug(this);
        //初始化基本数据
        NoHttp.initialize(InitializationConfig.newBuilder(this)
                .networkExecutor(new OkHttpNetworkExecutor())
                .build());
        Logger.setDebug(true);

//        String url = "http://211.159.183.26/bipbus/interaction/";
        String url = "http://112.124.22.238:8081/course_api/";
//        String url = "https://open-wlx.tenpay.com/cgi-bin/key/";
        RetrofitHelper.initialize(HttpGoConfig.newBuilder()
                .setBaseUrl(url)
                .setCachable(true)
                .build());
        com.wxx.httpgo.util.Logger.setDebug(true);
        com.wxx.httpgo.util.Logger.setTag("唐人");
    }


    public static MyApp getInstance() {
        if (instance == null) {
            synchronized (MyApp.class) {
                if (instance == null) {
                    instance = new MyApp();
                }
            }
        }
        return instance;
    }

}
