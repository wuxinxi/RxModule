package com.wxx.rxmodule;

import com.wxx.httpgo.core.BaseRxSubscriber;
import com.wxx.rxmodule.bean.MacKey;
import com.wxx.rxmodule.bean.PublicKey;


/**
 * 作者: Tangren on 2017-10-25
 * 包名：com.wxx.rxmodule
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

abstract class MyRxSub<T> extends BaseRxSubscriber<T> {

    private static final String RETCODE = "0";
    private String code = "-1";
    private String msg = "UnKnow Error";

    @Override
    public void onSuccess(T t) {
        if (t instanceof PublicKey) {
            PublicKey publicKey = (PublicKey) t;
            this.code = publicKey.getRetcode();
            this.msg = publicKey.getRetmsg();
        } else if (t instanceof MacKey) {
            MacKey macKey = (MacKey) t;
            this.code = macKey.getRetcode();
            this.msg = macKey.getRetmsg();
        }
        if (RETCODE.equals(code)) {
            success(t);
        } else {
            fail(msg);
        }
    }

    @Override
    public void onFail(String var) {
        fail(var);
    }

    /**
     * 自定义成功回调
     *
     * @param t .
     */
    public abstract void success(T t);

    /**
     * 自定义失败回调
     *
     * @param var .
     */
    public abstract void fail(String var);
}
