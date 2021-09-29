package com.example.shop.common.exception;

import java.util.function.Supplier;

public class ShopException extends RuntimeException implements Supplier<String> {
  private final IExceptionCode code;

  private ILangMessage customizeLangMessage;

  private final String message;

  public ShopException(IExceptionCode code, String message) {
    this.code = code;
    this.message = message;
  }

  public ShopException(IExceptionCode code, ILangMessage customizeLangMessage, String message) {
    this.code = code;
    this.customizeLangMessage = customizeLangMessage;
    this.message = message;
  }

  @Override
  public String get() {
    return null;
  }
}
