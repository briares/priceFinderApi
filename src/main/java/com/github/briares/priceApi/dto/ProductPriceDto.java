package com.github.briares.priceApi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductPriceDto {
  private String productId;
  private String brandId;
  private Integer priceList;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime startDate;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime endDate;
  private BigDecimal price;
}
