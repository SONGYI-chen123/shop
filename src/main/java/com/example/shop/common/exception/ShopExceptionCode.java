package com.example.shop.common.exception;

import lombok.Getter;

@Getter
public enum ShopExceptionCode implements IExceptionCode {
  NOT_FOUND_PRODUCT("Not found product.");


  ShopExceptionCode(String enMsg) {
    this.enMsg = enMsg;
  }

  String enMsg;

  @Override
  public String getValue() {
    return this.name();
  }

  @Override
  public String getLangMessage() {
    return IExceptionCode.super.getLangMessage();
  }
}
