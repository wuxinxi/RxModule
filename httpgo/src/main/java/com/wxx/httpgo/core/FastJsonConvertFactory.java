package com.wxx.httpgo.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.http
 * 邮箱：996489865@qq.com
 * TODO:fastJson
 */

class FastJsonConvertFactory extends Converter.Factory {

    static FastJsonConvertFactory create() {
        return new FastJsonConvertFactory();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FastJsonRequestConverter<>();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FastJsonResponseConverter<>(type);
    }

}
