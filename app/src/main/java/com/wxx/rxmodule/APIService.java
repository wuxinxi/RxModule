package com.wxx.rxmodule;

import com.wxx.rxmodule.bean.MacKey;
import com.wxx.rxmodule.bean.PublicKey;
import com.wxx.rxmodule.bean.WaresList;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.http
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public interface APIService {

    @GET("wares/list")
    Observable<WaresList> getClothes(@Query("categoryId") int categoryId, @Query("curPage") int curPage, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("pub_key_query.cgi")
    Observable<PublicKey> getPublicKey(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("mac_key_query.cgi")
    Observable<MacKey> getMacKey(@FieldMap Map<String, Object> map);

}
