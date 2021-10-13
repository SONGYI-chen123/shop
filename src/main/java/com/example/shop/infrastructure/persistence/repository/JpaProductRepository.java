package com.example.shop.infrastructure.persistence.repository;

import com.example.shop.common.base.JpaAndQueryDslExecutor;
import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.infrastructure.persistence.entity.ProductPo;

import static com.example.shop.infrastructure.persistence.assembler.ProductDataMapper.mapper;

public interface JpaProductRepository
    extends ProductRepository, JpaAndQueryDslExecutor<ProductPo, String> {
  default void saveProduct(Product product) {
    this.save(mapper.toPo(product));
  }

}
