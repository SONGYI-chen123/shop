package com.example.shop.domain.product.repository;

import com.example.shop.domain.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  void saveProduct(Product product);

  List<Product> findAllProducts();

  void deleteAllProducts();

  Optional<Product> findProductByProductNo(String productNo);
}
