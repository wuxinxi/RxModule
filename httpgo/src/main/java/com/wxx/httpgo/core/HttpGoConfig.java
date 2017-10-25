package com.wxx.httpgo.core;

/**
 * 作者: Tangren on 2017-10-24
 * 包名：com.wxx.httpgo.core
 * 邮箱：996489865@qq.com
 * TODO:一句话描述
 */

public class HttpGoConfig {

    public static Builder newBuilder() {
        return new Builder();
    }

    private boolean cacheable;
    private String baseUrl;
    private int mConnectTimeout;
    private int mReadTimeout;
    private int mWriteTimeout;
    private boolean retry;


    public boolean isCacheable() {
        return cacheable;
    }

    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public int getmConnectTimeout() {
        return mConnectTimeout;
    }

    public void setmConnectTimeout(int mConnectTimeout) {
        this.mConnectTimeout = mConnectTimeout;
    }

    public int getmReadTimeout() {
        return mReadTimeout;
    }

    public void setmReadTimeout(int mReadTimeout) {
        this.mReadTimeout = mReadTimeout;
    }

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    public int getmWriteTimeout() {
        return mWriteTimeout;
    }

    public void setmWriteTimeout(int mWriteTimeout) {
        this.mWriteTimeout = mWriteTimeout;
    }

    private HttpGoConfig(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.cacheable = builder.cacheable;
        this.mConnectTimeout = builder.mConnectTimeout;
        this.mReadTimeout = builder.mReadTimeout;
        this.mWriteTimeout = builder.mWriteTimeout;
        this.retry = builder.retry;

    }

    public static class Builder {

        private boolean cacheable = false;
        private String baseUrl;
        private int mConnectTimeout = 10;
        private int mReadTimeout = 10;
        private int mWriteTimeout = 15;
        private boolean retry = true;

        /**
         * @param baseUrl 基URL,必须以/结尾
         */
        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * 是否开启缓存
         *
         * @param cacheable
         */
        public Builder setCachable(Boolean cacheable) {
            this.cacheable = cacheable;
            return this;
        }


        public Builder setRetry(boolean retry) {
            this.retry = retry;
            return this;
        }

        /**
         * Connection timed out.默认10S
         *
         * @param seconds 秒
         */
        public Builder connectionTimeout(int seconds) {
            this.mConnectTimeout = seconds;
            return this;
        }

        /**
         * Read the server's data seconds.默认10S
         *
         * @param seconds 秒
         */
        public Builder readTimeout(int seconds) {
            this.mReadTimeout = seconds;
            return this;
        }

        /**
         * Read the server's data seconds.默认10S
         *
         * @param seconds 秒
         */
        public Builder writeTimeout(int seconds) {
            this.mWriteTimeout = seconds;
            return this;
        }

        public HttpGoConfig build() {
            return new HttpGoConfig(this);
        }

    }
}
