package com.example.shop.infrastructure.persistence.assembler;

import com.example.shop.domain.product.entity.ProductStockRecord;
import com.example.shop.infrastructure.persistence.entity.ProductStockRecordPo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductStockRecordDataMapper {
  ProductStockRecordDataMapper mapper = getMapper(ProductStockRecordDataMapper.class);

  ProductStockRecordPo toPo(ProductStockRecord productStockRecord);

  ProductStockRecord toDo(ProductStockRecordPo productStockRecordPo);
}
