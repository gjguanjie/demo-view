package com.cloud.utils;

public class ResponseVO<T> {

    private String code = "success";

    private String msg;

    private T data;

    private long total;

    public ResponseVO(String code, String msg, T data, long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {
        private String code = "success";

        private String msg;

        private T data;

        private long total;

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder withData(T data) {
            this.data = data;
            return this;
        }

        public Builder withTotal(long total) {
            this.total = total;
            return this;
        }

        public ResponseVO<T> build(){
            return new ResponseVO<>(this.code,this.msg,this.data,this.total);
        }
    }
}
