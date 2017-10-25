package com.wxx.rxmodule.sign;

import com.wxx.rxmodule.util.AppUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者: Tangren on 2017/7/20
 *         包名：com.szxb.buspay.util
 *         邮箱：996489865@qq.com
 *         TODO:参数工具类
 */

public class ParamsUtil {
    /**
     * @param app_id    商户id
     * @param timestamp 请求时间
     * @return 通用map
     */
    public static Map<String, Object> commonMap(String app_id, String timestamp) {
        Map<String, Object> map = new HashMap<>();
        map.put("app_id", app_id);
        map.put("charset", "UTF-8");
        map.put("format", "json");
        map.put("timestamp", timestamp);
        map.put("version", "1.0");
        map.put("sign_type", "sha1withrsa");
        return map;
    }



    public static Map<String, Object> getkeyMap() {
        String timestamp = AppUtil.getCurrentDate();
        String app_id = "10000009";
        Map<String, Object> map = commonMap(app_id, timestamp);
        map.put("sign", ParamSingUtil.getSign(app_id, timestamp, null, Config.private_key));
        return map;
    }

}
