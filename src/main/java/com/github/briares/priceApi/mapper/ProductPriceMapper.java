package com.github.briares.priceApi.mapper;

import com.github.briares.priceApi.dto.ProductPriceDto;
import com.github.briares.priceApi.model.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {
  @Mapping(source = "id", target = "priceList")
  ProductPriceDto toProductPriceDto(ProductPrice source);
}
