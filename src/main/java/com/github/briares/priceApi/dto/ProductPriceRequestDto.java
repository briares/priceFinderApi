package com.github.briares.priceApi.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
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
  @NotBlank(message = "Brand id cannot be null")
  private String brandId;
  @NotBlank(message = "Product id cannot be null")
  private String productId;
  @NotNull(message = "Date of application cannot be null")
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime dateOfApplication;
}
