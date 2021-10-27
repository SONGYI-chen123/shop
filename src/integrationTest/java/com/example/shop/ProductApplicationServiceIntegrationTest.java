package com.example.shop;

import com.example.shop.common.entity.ProductCategory;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.presentation.vo.command.AddProductCommand;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

public class ProductApplicationServiceIntegrationTest extends BaseIntegrationTest {
  @Autowired
  private ProductRepository productRepository;

  @Before
  public void setup() {
    productRepository.deleteAllProducts();
  }

  @Test
  public void should_add_product_success() {
    AddProductCommand command = AddProductCommand.builder().name("apple").productNo("NO.11")
        .category(ProductCategory.VEGETABLES).purchasePrice(BigDecimal.valueOf(13))
        .retailPrice(BigDecimal.valueOf(15)).purchaseNumber(100).build();

    given().contentType("application/json").body(command).when().post("/products").then()
        .statusCode(201);
  }
}
