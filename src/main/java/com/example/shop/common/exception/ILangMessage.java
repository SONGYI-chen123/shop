package com.example.shop.common.exception;

public interface ILangMessage {

  String getZhMsg();

  String getEnMsg();

  default Object[] getParams() {
    return new Object[0];
  }

  default void setParams(Object... params) {

  }

  default String getLangMessage() {
    return MultiLanguageMessage.builder().zhMsg(String.format(getZhMsg(), getParams()))
        .enMsg(String.format(getEnMsg(), getParams())).build().getMessage();
  }

}
