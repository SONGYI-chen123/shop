package com.example.shop.application.service;

import com.example.shop.application.dto.ProductDto;
import com.example.shop.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import static com.example.shop.application.assembler.ProductDtoMapper.MAPPER;

@Service
public class ProductApplicationService {
  private final ProductRepository productRepository;

  public ProductApplicationService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(ProductDto productDto) {
    productRepository.saveProduct(MAPPER.toDo(productDto));
  }
}
