package com.github.briares.priceApi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "PRODUCT_PRICE")
@ToString
public class ProductPrice {
  @Id
  @Column(name = "PRICE_LIST")
  private Integer id;
  @Column(name = "BRAND_ID")
  private int brandId;
  @Column(name = "PRODUCT_ID")
  private int productId;
  @Column(name = "START_DATE")
  private LocalDateTime startDate;
  @Column(name = "END_DATE")
  private LocalDateTime endDate;
  @Column(name = "PRIORITY")
  private int priority;
  @Column(name = "PRICE")
  private BigDecimal price;
  @Column(name = "CURR", length = 3)
  private String currencyCode;
}
