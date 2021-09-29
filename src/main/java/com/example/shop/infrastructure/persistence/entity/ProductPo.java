package com.example.shop.infrastructure.persistence.entity;

import com.example.shop.common.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductPo {
  private String id;

  private String name;

  @Enumerated(EnumType.STRING)
  private ProductCategory category;

  private BigDecimal purchasePrice;

  private BigDecimal retailPrice;

  private Integer stockNumber;

  private LocalDateTime createDate;

  private LocalDateTime updateDate;
}
