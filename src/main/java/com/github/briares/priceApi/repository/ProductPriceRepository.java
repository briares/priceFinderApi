package com.github.briares.priceApi.repository;

import com.github.briares.priceApi.model.ProductPrice;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
  @Query("select t from #{#entityName} t where brandId=:brandId and productId=:productId " +
         "and :dateOfApplication BETWEEN startDate AND endDate order by priority desc")
  List<ProductPrice> findAllProductPricesByDate(
      @Param("brandId") int brandId,
      @Param("productId") int productId,
      @Param("dateOfApplication") LocalDateTime dateOfApplication);
}
