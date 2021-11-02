package com.example.shop.application.service;

import com.example.shop.application.dto.ProductDto;
import com.example.shop.domain.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static com.example.shop.application.assembler.ProductDtoMapper.MAPPER;

@Service
public class ProductApplicationService {
  private final ProductService productService;

  public ProductApplicationService(ProductService productService) {
    this.productService = productService;
  }


  public void addProduct(ProductDto productDto) {
    productService.addProduct(MAPPER.toDo(productDto));
  }

  public Page<ProductDto> getProducts(Pageable pageable) {
    return productService.getProducts(pageable).map(MAPPER::toDto);
  }
}
