package com.example.shop.presentation.facade;

import com.example.shop.application.service.ProductApplicationService;
import com.example.shop.presentation.vo.command.AddProductCommand;
import com.example.shop.presentation.vo.command.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shop.presentation.assembler.ProductVoMapper.Mapper;

@RestController
@Validated
@RequestMapping("/products")
public class ProductController {
  private final ProductApplicationService productApplicationService;

  public ProductController(ProductApplicationService productApplicationService) {
    this.productApplicationService = productApplicationService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addProduct(@RequestBody AddProductCommand command) {
    productApplicationService.addProduct(Mapper.toDto(command));
  }

  @GetMapping
  public Page<ProductResponse> getProducts(
      @SortDefault(sort = "createTime", direction = Sort.Direction.DESC) Pageable pageable) {
    return productApplicationService.getProducts(pageable).map(Mapper::toProductResponse);
  }
}
