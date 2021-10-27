package com.example.shop.infrastructure.persistence.repository;

import com.example.shop.common.base.JpaAndQueryDslExecutor;
import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.infrastructure.persistence.entity.ProductPo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.shop.infrastructure.persistence.assembler.ProductDataMapper.mapper;

public interface JpaProductRepository
    extends ProductRepository, JpaAndQueryDslExecutor<ProductPo, String> {
  default void saveProduct(Product product) {
    this.save(mapper.toPo(product));
  }

  @Override
  default List<Product> findAllProducts() {
    return this.findAll().stream().map(mapper::toDo).collect(Collectors.toList());
  }

  default void deleteAllProducts() {
    this.deleteAll();
  }

  default Optional<Product> findProductByProductNo(String productNo) {
    return this.findByProductNo(productNo).map(mapper::toDo);
  }

  List<ProductPo> findAll();

  void deleteAll();

  Optional<ProductPo> findByProductNo(String productNo);
}
