package com.example.shop.domain.product.entity;

import com.example.shop.common.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
  private String id;

  private String name;

  private String productNo;

  private ProductCategory category;

  private BigDecimal purchasePrice;

  private BigDecimal retailPrice;

  private Integer stockNumber;

  private Integer purchaseNumber;

  public Product buildNewProduct(Product originalProduct) {
    if (Objects.isNull(originalProduct)) {
      return Product.builder().id(id).name(name).productNo(productNo).category(category)
          .purchasePrice(purchasePrice).retailPrice(retailPrice).stockNumber(purchaseNumber)
          .build();
    } else {
      return Product.builder().id(originalProduct.id).name(originalProduct.name)
          .productNo(originalProduct.productNo).category(originalProduct.category)
          .purchasePrice(originalProduct.purchasePrice).retailPrice(originalProduct.retailPrice)
          .stockNumber(purchaseNumber + originalProduct.getStockNumber()).build();
    }
  }
}
