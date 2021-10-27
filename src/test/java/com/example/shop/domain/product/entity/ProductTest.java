package com.example.shop.domain.product.entity;

import org.junit.Test;

import java.math.BigDecimal;

import static com.example.shop.common.entity.ProductCategory.VEGETABLES;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
  @Test
  public void should_return_product_when_have_not_original_product() {
    // given
    Product addProduct =
        Product.builder().id("1").name("name").productNo("productNo").category(VEGETABLES)
            .retailPrice(BigDecimal.valueOf(20)).stockNumber(0).purchaseNumber(10).build();

    // when
    Product newProduct = addProduct.buildNewProduct(null);

    // then
    assertThat(newProduct.getId()).isEqualTo(addProduct.getId());
    assertThat(newProduct.getProductNo()).isEqualTo(addProduct.getProductNo());
    assertThat(newProduct.getName()).isEqualTo(addProduct.getName());
    assertThat(newProduct.getCategory()).isEqualTo(addProduct.getCategory());
    assertThat(newProduct.getPurchasePrice()).isEqualTo(addProduct.getPurchasePrice());
    assertThat(newProduct.getRetailPrice()).isEqualTo(addProduct.getRetailPrice());
    assertThat(newProduct.getStockNumber()).isEqualTo(addProduct.getPurchaseNumber());
  }

  @Test
  public void should_return_product_when_have_original_product() {
    // given
    Product addProduct =
        Product.builder().id("1").name("name").productNo("productNo").category(VEGETABLES)
            .retailPrice(BigDecimal.valueOf(20)).stockNumber(0).purchaseNumber(10).build();
    Product originalProduct =
        Product.builder().id("2").name("originalName").productNo("originalProductNo")
            .category(VEGETABLES).retailPrice(BigDecimal.valueOf(20)).stockNumber(99).build();

    // when
    Product newProduct = addProduct.buildNewProduct(originalProduct);

    // then
    assertThat(newProduct.getId()).isEqualTo(originalProduct.getId());
    assertThat(newProduct.getProductNo()).isEqualTo(originalProduct.getProductNo());
    assertThat(newProduct.getName()).isEqualTo(originalProduct.getName());
    assertThat(newProduct.getCategory()).isEqualTo(originalProduct.getCategory());
    assertThat(newProduct.getPurchasePrice()).isEqualTo(originalProduct.getPurchasePrice());
    assertThat(newProduct.getRetailPrice()).isEqualTo(originalProduct.getRetailPrice());
    assertThat(newProduct.getStockNumber()).isEqualTo(109);
  }
}
