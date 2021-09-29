package com.example.shop.common.entity;

public enum ProductCategory {
  VEGETABLES("Vegetables"), MEAT("Meat"), SNACKS("Snacks"), DAILY_NECESSITIES("Daily necessities");

  String value;

  ProductCategory(String value) {
    this.value = value;
  }
}
