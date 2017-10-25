package com.wxx.rxmodule.bean;

/**
 * 作者: Tangren on 2017-10-25
 * 包名：com.wxx.rxmodule.bean
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class MacKey {

    /**
     * sign : Xef/LnHo8kUaV4ZfqGFfy0mwX8XygYY2536ENElwKDlUXBv4c7EFYUlcpYFzY1dlMTNPJcIjWRa8ehjYCZBcDVTh+aeLlBe/yV1eNvD/bBctGDH8zE0mUVFSKWXcsj43Kc2wQops/JvdeQHPRvaGdyUAyNOUqbz2t0LvolnDLQI=
     * retcode : 0
     * num : 8
     * mac_key_list : [{"key_id":"1","mac_key":"aa150Xm2sbPb+w0t3OXcFW2fshiElju2xL2uYc6RBv4tjAA1dKFnxanATtcBcmgrHlKWSEPOKsRAofHHbBs/ZKShq60f+j43KrXS8FBA5jXCvq+Ym72OHH/akQBy/s5BziolWgtbJIGZQAqr4wuJ5ZepD722h8L2uUb2yytoXjY="},{"key_id":"2","mac_key":"ZvXt2vyRkHjmGbR0K0uDPKU0CtuNwOHlJRBEvnOot3fyn6huilbR3p5arkGJo+BI3Dn/eQrOQSuh19DyoKhVo3TLNoIlMJ3WsloKtS9MJ+oc8vA88UoDs572V9HCDCl+6bBcfPp04WSHZYZL3JVGheSPYeJvZK2PGG37SOoDEgg="},{"key_id":"3","mac_key":"v7KJB9Le6fNISPuG2gVzXwTuu/0FlklimQnvY/v0MUZTToKJXWFxXnTHtE6fMuCYt6fnZ43zbfa8U5HQYYXLFLDYcRptVRmlX9Ir00eaz7+t5p3tCj/UvGSF+euryp9Y6fMBkfo3/fRBq250Rz5G2HVNdFgLaAOex7WFm2Nv7+A="},{"key_id":"4","mac_key":"GEzO5G/U9EFGPqE+Ym6W9TSTlMpqLg5ZokTOOHgDqPZ35DjNkAwyTxWXTSkNpikh+hNAFgUh60wjw8iAErty3mgDtv4Vt3sIt9lSUCcoJN0TcQ6gVxyiC6d9Bfg7MW3oSO0uQ3hAJrR65bQm9zx9QB8to2FZidrnh5kbzwujOws="},{"key_id":"5","mac_key":"qbrX94bm+U1vicY7MBVp6u1VHsrOBlYo0q8/H+DeJxBSx5fa/jfnvwqJVMuJyNx5rtvJ1MOS3FmQQ9hsjaKNdjrUl79C2KO3JmVw5PlzGz5HhTC0JexzpvfhbY0/rT3RFnYlJimnwMTS8Z8cevReAN+Jz7xbn1trZAdUSV1x8Bc="},{"key_id":"6","mac_key":"TwAGt0khwYkMxawI++4fiU27LBnM5KEw7c6eOe6mGq+WbjDxmy/cKyLQpd3kYdL3a6ALz25EpE3RYGXh5fIpmvKPNqAAiqGKrbamtbnKv1XjkfoyyxUlmFQLsEi8dNNz6l5iPnh70+LJOcL2ASkCVkjGTDLipSaCcENpARv8IYo="},{"key_id":"7","mac_key":"blx8h/Mmrgw2AGvmAA2A44D8xIWPxm2FjojZRGnR7b5BWoc2uHWyHMuD6DzssX6OmJBqJgIN+RV0bVN+Xx5F8+pr6uKTkynxEgXQHU8LJfR0Ypdxd+b0CH9+f7HC+Bajj9tRD/8BKYkGfUDeB4jyks/T7DIqN4SeaeeJYdgfY1Q="},{"key_id":"8","mac_key":"FzEuphRoOnftVZDeX6iRb6MK2lh+FIim4t+GzKwbaziY7qIIyYFzshrADvpAYVn/lyO82j1h9d7BEY6WJAYodJ4+ljje+XkJCZthqISNzPUEUhdgCgCJTym/fprb4yxvYHdtkrPEQ81X9tEozr43EWq6MilrXBk8DDEj1eH+zeA="}]
     * retmsg : ok
     */

    private String sign;
    private String retcode;
    private String num;
    private String mac_key_list;
    private String retmsg;

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

    public String getMac_key_list() {
        return mac_key_list;
    }

    public void setMac_key_list(String mac_key_list) {
        this.mac_key_list = mac_key_list;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    @Override
    public String toString() {
        return "MacKey{" +
                "sign='" + sign + '\'' +
                ", retcode='" + retcode + '\'' +
                ", num='" + num + '\'' +
                ", mac_key_list='" + mac_key_list + '\'' +
                ", retmsg='" + retmsg + '\'' +
                '}';
    }
}
