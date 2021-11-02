package com.example.shop.domain.product.repository;

import com.example.shop.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepository {
  void saveProduct(Product product);

  Page<Product> findAllProducts(Pageable pageable);

  void deleteAllProducts();

  Optional<Product> findProductByProductNo(String productNo);
}
