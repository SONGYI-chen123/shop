package com.example.shop;

import io.restassured.config.EncoderConfig;
import io.restassured.config.LogConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class BaseIntegrationTest {
  @Autowired
  protected WebApplicationContext context;

  @BeforeEach
  public void init() {
    RestAssuredMockMvc.webAppContextSetup(context);
  }


  @AfterEach
  public void reset() {
    RestAssuredMockMvc.reset();
  }


  protected MockMvcRequestSpecification given() {
    return RestAssuredMockMvc.given()
        .config(RestAssuredMockMvcConfig.config().encoderConfig(
            new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
        .config(RestAssuredMockMvcConfig.config()
            .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()));
  }
}
