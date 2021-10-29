package com.example.shop.domain.product.repository;

import com.example.shop.domain.product.entity.ProductStockRecord;


public interface ProductStockRecordRepository {
  void saveProductStockRecord(ProductStockRecord productStockRecord);
}
