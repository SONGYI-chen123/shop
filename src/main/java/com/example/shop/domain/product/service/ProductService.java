package com.example.shop.domain.product.service;

import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(Product product) {
    Product originalProduct =
        productRepository.findProductByProductNo(product.getProductNo()).orElse(null);
    Product newProduct = product.buildNewProduct(originalProduct);
    productRepository.saveProduct(newProduct);
  }
}
