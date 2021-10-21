package com.example.shop;

import com.example.shop.common.entity.ProductCategory;
import com.example.shop.infrastructure.persistence.repository.JpaProductRepository;
import com.example.shop.presentation.vo.command.AddProductCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductApplicationServiceIntegrationTest {
  @Autowired
  MockMvc mockMvc;

  @Autowired
  private JpaProductRepository jpaProductRepository;

  @Test
  public void should_add_product_success() throws Exception {
    AddProductCommand command = AddProductCommand.builder().name("apple")
        .category(ProductCategory.VEGETABLES).purchasePrice(BigDecimal.valueOf(13))
        .retailPrice(BigDecimal.valueOf(15)).stockNumber(100).build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(command);

    mockMvc.perform(post("/products").content(jsonString).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }
}
