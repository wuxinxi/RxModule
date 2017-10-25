package com.wxx.rxmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wxx.httpgo.core.BaseRxSubscriber;
import com.wxx.httpgo.core.RetrofitHelper;
import com.wxx.httpgo.core.RxJavaHelper;
import com.wxx.rxmodule.bean.WaresList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitHelper
                .createApi(APIService.class)
                .getClothes(2, 2, 10)
                .compose(RxJavaHelper.<WaresList>observeOnMainThread())
                .subscribe(new BaseRxSubscriber<WaresList>() {
                    @Override
                    public void onSuccess(WaresList waresList) {
                        Log.d("MainActivity",
                                "onSuccess(MainActivity.java:30)" + waresList.toString());
                    }

                    @Override
                    public void onFail(String var) {
                        Log.d("MainActivity",
                                "onFail(MainActivity.java:36)" + var);
                    }
                });

//
//        RetrofitHelper.createApi(APIService.class)
//                .getPublicKey(ParamsUtil.getkeyMap())
//                .compose(RxJavaHelper.<PublicKey>observeOnMainThread())
//                .subscribe(new MyRxSub<PublicKey>() {
//                    @Override
//                    public void success(PublicKey publicKey) {
//                        Log.d("MainActivity",
//                                "success(MainActivity.java:46)" + publicKey);
//                    }
//
//                    @Override
//                    public void fail(String var) {
//                        Log.d("MainActivity",
//                                "fail(MainActivity.java:52)" + var);
//                    }
//                });
//
//
//        RetrofitHelper.createApi(APIService.class)
//                .getMacKey(ParamsUtil.getkeyMap())
//                .compose(RxJavaHelper.<MacKey>observeOnMainThread())
//                .subscribe(new MyRxSub<MacKey>() {
//                    @Override
//                    public void success(MacKey macKey) {
//                        Log.d("MainActivity",
//                                "onSuccess(MainActivity.java:65)" + macKey);
//                    }
//
//                    @Override
//                    public void fail(String var) {
//                        Log.d("MainActivity",
//                                "onFail(MainActivity.java:71)" + var);
//                    }
//                });

    }


}
