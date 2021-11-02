package com.example.shop.infrastructure.persistence.repository;

import com.example.shop.common.base.JpaAndQueryDslExecutor;
import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.infrastructure.persistence.entity.ProductPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.example.shop.infrastructure.persistence.assembler.ProductDataMapper.mapper;

public interface JpaProductRepository
    extends ProductRepository, JpaAndQueryDslExecutor<ProductPo, String> {
  @Override
  default void saveProduct(Product product) {
    this.save(mapper.toPo(product));
  }

  @Override
  default Page<Product> findAllProducts(Pageable pageable) {
    return this.findAll(pageable).map(mapper::toDo);
  }

  @Override
  default void deleteAllProducts() {
    this.deleteAll();
  }

  @Override
  default Optional<Product> findProductByProductNo(String productNo) {
    return this.findByProductNo(productNo).map(mapper::toDo);
  }

  List<ProductPo> findAll();

  void deleteAll();

  Optional<ProductPo> findByProductNo(String productNo);
}
