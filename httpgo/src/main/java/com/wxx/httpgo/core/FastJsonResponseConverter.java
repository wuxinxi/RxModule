package com.wxx.httpgo.core;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * 作者: Tangren on 2017-10-23
 * 包名：com.wxx.rxmodule.http
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class FastJsonResponseConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    FastJsonResponseConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource buffer = Okio.buffer(value.source());
        String s = buffer.readUtf8();
        buffer.close();
        return JSON.parseObject(s, type);
    }
}
