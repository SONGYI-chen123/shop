package com.example.shop.infrastructure.persistence.repository;

import com.example.shop.common.base.JpaAndQueryDslExecutor;
import com.example.shop.domain.product.entity.ProductStockRecord;
import com.example.shop.domain.product.repository.ProductStockRecordRepository;
import com.example.shop.infrastructure.persistence.entity.ProductStockRecordPo;


import static com.example.shop.infrastructure.persistence.assembler.ProductStockRecordDataMapper.mapper;

public interface JpaProductStockRecordRepository
    extends ProductStockRecordRepository, JpaAndQueryDslExecutor<ProductStockRecordPo, String> {
  @Override
  default void saveProductStockRecord(ProductStockRecord productStockRecord) {
    this.save(mapper.toPo(productStockRecord));
  }
}
