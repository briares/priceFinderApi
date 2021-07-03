package com.github.briares.priceApi.controller;

import com.github.briares.priceApi.dto.ProductPriceDto;
import com.github.briares.priceApi.dto.ProductPriceRequestDto;
import com.github.briares.priceApi.service.ProductPriceFinderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Objects;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value=PriceRestController.PRICE_ENDPOINT, produces="application/json; charset=UTF-8")
@RequiredArgsConstructor
@Slf4j
public class PriceRestController {
  public static final String PRICE_ENDPOINT = "/prices";

  private final ProductPriceFinderService productPriceFinder;

  @Operation(summary = "Get a product price by application date")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Product price found",
          content = { @Content(mediaType = "application/json",
              schema = @Schema(implementation = ProductPriceDto.class)) }),
      @ApiResponse(responseCode = "400", description = "Request parameters not valid",
          content = @Content),
      @ApiResponse(responseCode = "404", description = "Product price not found",
          content = @Content) })
  @GetMapping
  public ResponseEntity<ProductPriceDto> getAllPricesByDate(@Valid ProductPriceRequestDto priceRequest) {
    log.info("price request for product {}", priceRequest);
    ProductPriceDto productPriceDto = productPriceFinder.getPriceForProduct(priceRequest);
    log.info("request for product price ended with result {}", productPriceDto);
    if (Objects.nonNull(productPriceDto)) {
      return new ResponseEntity<ProductPriceDto>(productPriceDto, HttpStatus.OK);
    }
    else {
      return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
  }
}
