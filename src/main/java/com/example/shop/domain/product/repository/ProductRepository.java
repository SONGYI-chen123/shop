package com.example.shop.domain.product.repository;

import com.example.shop.domain.product.entity.Product;

public interface ProductRepository {
  void saveProduct(Product product);
}
