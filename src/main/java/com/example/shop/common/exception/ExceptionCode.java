package com.example.shop.common.exception;

public enum ExceptionCode implements IExceptionCode {
    NOT_FOUND("资源未找到", "not found");

    String zhMsg;

    String enMsg;

    ExceptionCode() {

    }

    ExceptionCode(String zhMsg, String enMsg) {
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    @Override
    public String getValue() {
        return this.name();
    }

    @Override
    public String getZhMsg() {
        return zhMsg;
    }

    @Override
    public String getEnMsg() {
        return enMsg;
    }

}
