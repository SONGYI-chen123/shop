package com.example.shop.domain.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockRecord {
  private String id;

  private String productNo;

  private Integer reduceNumber;

  private Integer increaseNumber;

  private Integer totalNumber;

  public static ProductStockRecord buildAddProductRecord(Product product) {
    return ProductStockRecord.builder().productNo(product.getProductNo())
        .increaseNumber(product.getPurchaseNumber()).totalNumber(product.getStockNumber()).build();
  }
}
