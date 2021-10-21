package com.example.shop.presentation.assembler;

import com.example.shop.application.dto.ProductDto;
import com.example.shop.presentation.vo.command.AddProductCommand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductVoMapper {
  ProductVoMapper Mapper = Mappers.getMapper(ProductVoMapper.class);

  ProductDto toDto(AddProductCommand command);
}
