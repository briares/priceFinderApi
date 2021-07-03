package com.github.briares.priceApi.service;

import com.github.briares.priceApi.dto.ProductPriceDto;
import com.github.briares.priceApi.dto.ProductPriceRequestDto;

public interface ProductPriceFinderService {
  ProductPriceDto getPriceForProduct(final ProductPriceRequestDto productPriceRequestDto);
}
