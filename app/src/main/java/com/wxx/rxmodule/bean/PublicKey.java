package com.wxx.rxmodule.bean;

/**
 * 作者: Tangren on 2017-10-25
 * 包名：com.wxx.rxmodule.bean
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class PublicKey {


    /**
     * sign : QbevnJQ7Vh0uBZ7sBY+viCYkIV0qCHgZn8ItAEScadh5FALz8U7SMw/y8k7f924OtNx3Xwg1klKqC50RJ2DA9gwPHLiJaJwcYp0KPimZLf5Rxxtdd9912qINSitu7Q8dKgbCbf7vX2bMklVV3/s6L0FDHgmXEt/Jcas4pshbv0U=
     * retcode : 0
     * num : 2
     * cache : 10
     * retmsg : ok
     * pubkey_list : [{"key_id":1,"pubkey":"049C11FE1533BD248FD846F27B98019C4A39A1B737CC248F449EA5299EAB8F22358E16B03E57927185BFFF76D74200F3F203BB856F6C92EB92"},{"key_id":2,"pubkey":"04ACFC873BF4C0467232C87B8D019FA7C48C4E2ACCFD89C85F167DC5FAA931E21917DEF56B14CFB8EBE8DDD166A7AA37531DC5C416765DFFC0"}]
     */

    private String sign;
    private String retcode;
    private String num;
    private String cache;
    private String retmsg;
    private String pubkey_list;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getPubkey_list() {
        return pubkey_list;
    }

    public void setPubkey_list(String pubkey_list) {
        this.pubkey_list = pubkey_list;
    }

    @Override
    public String toString() {
        return "PublicKey{" +
                "sign='" + sign + '\'' +
                ", retcode='" + retcode + '\'' +
                ", num='" + num + '\'' +
                ", cache='" + cache + '\'' +
                ", retmsg='" + retmsg + '\'' +
                ", pubkey_list='" + pubkey_list + '\'' +
                '}';
    }
}
