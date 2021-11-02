package com.example.shop;

import com.example.shop.common.entity.ProductCategory;
import com.example.shop.domain.product.entity.Product;
import com.example.shop.domain.product.repository.ProductRepository;
import com.example.shop.presentation.vo.command.AddProductCommand;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static com.example.shop.common.exception.NotFoundException.notFoundException;
import static com.example.shop.common.exception.ShopExceptionCode.NOT_FOUND_PRODUCT;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductApplicationServiceIntegrationTest extends BaseIntegrationTest {
  @Autowired
  private ProductRepository productRepository;
  String productNo = "NO.12";
  Product product1 = Product.builder().name("apple").productNo(productNo)
      .category(ProductCategory.VEGETABLES).purchasePrice(BigDecimal.valueOf(13))
      .retailPrice(BigDecimal.valueOf(15)).stockNumber(100).build();

  @Before
  public void setup() {
    productRepository.deleteAllProducts();
    productRepository.saveProduct(product1);
  }

  @Test
  public void should_add_product_success_when_add_new_product() {
    AddProductCommand command = AddProductCommand.builder().name("apple").productNo("NO.11")
        .category(ProductCategory.VEGETABLES).purchasePrice(BigDecimal.valueOf(13))
        .retailPrice(BigDecimal.valueOf(15)).purchaseNumber(100).build();

    given().contentType("application/json").body(command).when().post("/products").then()
        .statusCode(201);
  }

  @Test
  public void should_add_stock_number_success_when_have_the_product() {
    AddProductCommand command = AddProductCommand.builder().name("apple").productNo(productNo)
        .category(ProductCategory.VEGETABLES).purchasePrice(BigDecimal.valueOf(13))
        .retailPrice(BigDecimal.valueOf(15)).purchaseNumber(20).build();

    given().contentType("application/json").body(command).when().post("/products").then()
        .statusCode(201);

    Product finalProduct = productRepository.findProductByProductNo(productNo)
        .orElseThrow(notFoundException(NOT_FOUND_PRODUCT));
    assertThat(finalProduct.getId()).isNotNull();
    assertThat(finalProduct.getProductNo()).isEqualTo(product1.getProductNo());
    assertThat(finalProduct.getCategory()).isEqualTo(product1.getCategory());
    assertThat(finalProduct.getStockNumber()).isEqualTo(120);
  }

  @Test
  public void should_get_products() {
    given().when().get("/products").then().statusCode(200).body("content.size()", equalTo(1))
        .body("content[0].productNo", is(product1.getProductNo()));
  }
}
