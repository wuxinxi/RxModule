package com.wxx.httpgo.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.wxx.httpgo.GoApplication;

/**
 * 作者: Tangren on 2017/8/7
 * 包名：com.szxb.utils
 * 邮箱：996489865@qq.com
 * TODO:判断是否是DEBUG模式
 */

public class AppUtil {

    private static Boolean isDebug = null;

    public static boolean isDebug() {
        return isDebug == null ? false : isDebug;
    }

    public static void syncISDebug(Context context) {
        if (isDebug == null) {
            isDebug = context.getApplicationInfo() != null && (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
    }

    //获取版本号
    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    /**
     * 是否有网络
     *
     * @return boolean
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) GoApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        return current != null && current.isAvailable();
    }

}
