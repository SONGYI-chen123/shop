package com.example.shop.application.dto;

import com.example.shop.common.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
  private String id;

  private String name;

  private String productNo;

  private ProductCategory category;

  private BigDecimal purchasePrice;

  private BigDecimal retailPrice;

  private Integer purchaseNumber;
}
