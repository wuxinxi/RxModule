package com.wxx.httpgo.core;

import android.support.annotation.NonNull;

import com.wxx.httpgo.GoApplication;
import com.wxx.httpgo.util.AppUtil;
import com.wxx.httpgo.util.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.http
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class RetrofitHelper {

    private volatile static Retrofit retrofitInstance = null;
    private static HttpGoConfig sgoConfig;
    private static final String METHOD = "POST";

    /**
     * 创建Retrofit请求Api
     *
     * @param clazz Retrofit Api接口
     * @return api实例
     */
    public static <T> T createApi(Class<T> clazz) {
        return getInstance().create(clazz);
    }

    public static void initialize(HttpGoConfig goConfig) {
        sgoConfig = goConfig;
    }

    private static Retrofit getInstance() {
        if (retrofitInstance == null) {
            synchronized (RetrofitHelper.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(sgoConfig.getBaseUrl())
                            .client(buildOKHttpClient())
                            .addConverterFactory(FastJsonConvertFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofitInstance;
    }

    /**
     * 构建OkHttpClient
     *
     * @return OkHttpClient
     */
    private static OkHttpClient buildOKHttpClient() {
        // 添加日志拦截器，非debug模式不打印任何日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(AppUtil.isDebug() ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder()
                // 添加日志拦截器
                .addInterceptor(loggingInterceptor)
                // 添加拦截器
                .addInterceptor(getInterceptor())
                // 添加网络缓存拦截器
                .addNetworkInterceptor(buildCacheInterceptor())
                // 设置缓存文件
                .cache(getCache())
                // 自动重连
                .retryOnConnectionFailure(sgoConfig.isRetry())
                // 10秒连接超时
                .connectTimeout(sgoConfig.getmConnectTimeout(), TimeUnit.SECONDS)
                // 10秒读取超时
                .readTimeout(sgoConfig.getmReadTimeout(), TimeUnit.SECONDS)
                // 15秒写入超时
                .writeTimeout(sgoConfig.getmWriteTimeout(), TimeUnit.SECONDS)
                .build();
    }

    /**
     * 获取缓存对象
     *
     * @return Cache
     */
    private static Cache getCache() {
        // 获取缓存目标,SD卡
        File cacheFile = new File(GoApplication.getInstance().getCacheDir(), "rxCacheData");
        // 创建缓存对象,最大缓存50m
        return new Cache(cacheFile, 1024 * 1024 * 20);
    }

    /**
     * 构建缓存拦截器
     *
     * @return Interceptor
     */
    private static Interceptor buildCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();
                long t1 = System.nanoTime();
                Logger.d("---------------------------------------start------------------------------------------------");
                // 响应内容处理
                // 在线时缓存5分钟
                // 离线时缓存4周
                String method = request.method();
                log(method, request);
                Response response = chain.proceed(request);
                long t2 = System.nanoTime();

                Logger.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers()));

                if (AppUtil.isNetworkConnected()) {
                    int maxAge = 300;
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    Logger.d("无网络,响应缓存");
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                Logger.d("------------------------------end 总共耗时:" + (t2 - t1) / 1e6d + "毫秒------------------------------");
                return response;
            }
        };
    }

    /**
     * 设置返回数据的
     *
     * @return Interceptor  判断网络   没网读取缓存
     */
    private static Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!AppUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                return chain.proceed(request);
            }
        };
    }


    private static void log(String method, Request request) {
        if (METHOD.equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                assert body != null;
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i)).append("=").append(body.encodedValue(i)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                Logger.d("RequestParams:{" + sb.toString() + "}");
            }
        }
    }


}
