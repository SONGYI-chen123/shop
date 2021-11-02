package com.example.shop.domain.product.service;

import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.entity.ProductStockRecord;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.domain.product.repository.ProductStockRecordRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductStockRecordRepository productStockRecordRepository;

  public ProductService(ProductRepository productRepository,
      ProductStockRecordRepository productStockRecordRepository) {
    this.productRepository = productRepository;
    this.productStockRecordRepository = productStockRecordRepository;
  }

  public void addProduct(Product product) {
    Product originalProduct =
        productRepository.findProductByProductNo(product.getProductNo()).orElse(null);
    Product newProduct = product.buildNewProduct(originalProduct);
    ProductStockRecord productStockRecord = ProductStockRecord.buildAddProductRecord(newProduct);

    productRepository.saveProduct(newProduct);
    productStockRecordRepository.saveProductStockRecord(productStockRecord);
  }
}
