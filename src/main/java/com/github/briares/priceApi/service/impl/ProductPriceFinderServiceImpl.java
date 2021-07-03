package com.github.briares.priceApi.service.impl;

import com.github.briares.priceApi.dto.ProductPriceDto;
import com.github.briares.priceApi.dto.ProductPriceRequestDto;
import com.github.briares.priceApi.mapper.ProductPriceMapper;
import com.github.briares.priceApi.model.ProductPrice;
import com.github.briares.priceApi.repository.ProductPriceRepository;
import com.github.briares.priceApi.service.ProductPriceFinderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPriceFinderServiceImpl implements ProductPriceFinderService {
  // lombok magic autowiring
  private final ProductPriceRepository productPriceRepository;
  private final ProductPriceMapper productPriceMapper;

  @Override
  public ProductPriceDto getPriceForProduct(ProductPriceRequestDto productPriceRequestDto) {
    return getProductPrices(productPriceRequestDto).stream()
        .findFirst()
        .map(productPriceMapper::toProductPriceDto)
        .orElse(null);
  }

  private List<ProductPrice> getProductPrices(ProductPriceRequestDto productPriceRequestDto) {
    return productPriceRepository.findAllProductPricesByDate(productPriceRequestDto.getBrandId(),
            productPriceRequestDto.getProductId(),
            productPriceRequestDto.getDateOfApplication());
  }
}
