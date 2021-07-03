package com.github.briares.priceApi.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@ToString
@NoArgsConstructor
public class ProductPriceRequestDto {
  @NotNull(message = "Brand id cannot be null")
  private int brandId;
  @NotNull(message = "Product id cannot be null")
  private int productId;
  @NotNull(message = "Not valid ISO Date. Use  ISO-8601, for example: 2020-12-31T13:00:00Z")
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime dateOfApplication;
}
