package com.example.shop.infrastructure.persistence.assembler;

import com.example.shop.domain.product.Product;
import com.example.shop.infrastructure.persistence.entity.ProductPo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDataMapper {
  ProductDataMapper mapper = getMapper(ProductDataMapper.class);

  ProductPo toPo(Product product);

  Product toDo(ProductPo productPo);
}
