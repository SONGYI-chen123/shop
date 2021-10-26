package com.example.shop.domain.product.repository;

import com.example.shop.domain.product.entity.Product;

import java.util.List;

public interface ProductRepository {
  void saveProduct(Product product);

  List<Product> findAllProducts();

  void deleteAllProducts();
}
