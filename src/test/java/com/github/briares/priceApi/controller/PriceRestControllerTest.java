package com.github.briares.priceApi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PriceRestControllerTest {
  private static final String PRICE_API_URL = "/prices";
  private static final String PRODUCT_ID_35455 = "35455";
  private static final String BRAND_ID_1 = "1";

  @Autowired
  private MockMvc mockMvc;

  // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
  @Test
  public void requestOK_test1() throws Exception {
    final String applicationDate = "2020-06-14T10:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId", is(PRODUCT_ID_35455)))
        .andExpect(jsonPath("$.brandId", is(BRAND_ID_1)))
        .andExpect(jsonPath("$.priceList", is(1)))
        .andExpect(jsonPath("$.startDate", is("14/06/2020 00:00:00")))
        .andExpect(jsonPath("$.endDate", is("31/12/2020 23:59:59")))
        .andExpect(jsonPath("$.price", is(35.50)));
  }

  // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
  @Test
  public void requestOK_test2() throws Exception {
    final String applicationDate = "2020-06-14T16:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId", is(PRODUCT_ID_35455)))
        .andExpect(jsonPath("$.brandId", is(BRAND_ID_1)))
        .andExpect(jsonPath("$.priceList", is(2)))
        .andExpect(jsonPath("$.startDate", is("14/06/2020 15:00:00")))
        .andExpect(jsonPath("$.endDate", is("14/06/2020 18:30:00")))
        .andExpect(jsonPath("$.price", is(25.45)));
  }

  // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
  @Test
  public void requestOK_test3() throws Exception {
    final String applicationDate = "2020-06-14T21:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId", is(PRODUCT_ID_35455)))
        .andExpect(jsonPath("$.brandId", is(BRAND_ID_1)))
        .andExpect(jsonPath("$.priceList", is(1)))
        .andExpect(jsonPath("$.startDate", is("14/06/2020 00:00:00")))
        .andExpect(jsonPath("$.endDate", is("31/12/2020 23:59:59")))
        .andExpect(jsonPath("$.price", is(35.50)));
  }

  // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
  @Test
  public void requestOK_test4() throws Exception {
    final String applicationDate = "2020-06-15T10:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId", is(PRODUCT_ID_35455)))
        .andExpect(jsonPath("$.brandId", is(BRAND_ID_1)))
        .andExpect(jsonPath("$.priceList", is(3)))
        .andExpect(jsonPath("$.startDate", is("15/06/2020 00:00:00")))
        .andExpect(jsonPath("$.endDate", is("15/06/2020 11:00:00")))
        .andExpect(jsonPath("$.price", is(30.50)));
  }

  // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
  @Test
  public void requestOK_test5() throws Exception {
    final String applicationDate = "2020-06-16T21:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId", is(PRODUCT_ID_35455)))
        .andExpect(jsonPath("$.brandId", is(BRAND_ID_1)))
        .andExpect(jsonPath("$.priceList", is(4)))
        .andExpect(jsonPath("$.startDate", is("15/06/2020 16:00:00")))
        .andExpect(jsonPath("$.endDate", is("31/12/2020 23:59:59")))
        .andExpect(jsonPath("$.price", is(38.95)));
  }

  // Additional test for testing http response codes

  @Test
  public void requestNotFound_priceNotFoundForRequestParameters() throws Exception {
    final String applicationDate = "2019-06-16T21:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$").doesNotExist());
  }

  @Test
  public void badRequest_InvalidDAteFormat() throws Exception {
    final String applicationDate = "2019-31-01T21:00:00Z";

    mockMvc.perform(get(PRICE_API_URL)
        .queryParams(getQueryParams (applicationDate, BRAND_ID_1, PRODUCT_ID_35455))
        .contentType("application/json"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  private MultiValueMap<String, String> getQueryParams(final String dateTimeOfApplication,
      String brandId, String productId) {
    LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    requestParams.add("dateOfApplication", dateTimeOfApplication);
    requestParams.add("brandId", brandId);
    requestParams.add("productId", productId);

    return requestParams;
  }
}
