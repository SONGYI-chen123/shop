package com.example.shop.domain.product.service;

import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.entity.ProductStockRecord;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.domain.product.repository.ProductStockRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductStockRecordRepository productStockRecordRepository;

  public void addProduct(Product product) {
    Product originalProduct =
        productRepository.findProductByProductNo(product.getProductNo()).orElse(null);
    Product newProduct = product.buildNewProduct(originalProduct);
    ProductStockRecord productStockRecord = ProductStockRecord.buildAddProductRecord(newProduct);

    productRepository.saveProduct(newProduct);
    productStockRecordRepository.saveProductStockRecord(productStockRecord);
  }

  public Page<Product> getProducts(Pageable pageable) {
    return productRepository.findAllProducts(pageable);
  }
}
