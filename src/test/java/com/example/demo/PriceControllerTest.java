package com.example.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.PriceController;
import com.example.demo.model.service.PriceService;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PriceService priceService;
	
	private static final int PRODUCT_ID = 35455;
	private static final int BRAND_ID = 1;
	
    @Test
    public void testGetPricePattern_uno() throws Exception {
        Mockito.when(priceService.getPricePattern(Mockito.any(LocalDate.class), Mockito.eq(PRODUCT_ID), Mockito.eq(BRAND_ID)))
                .thenReturn("MockedResponse");
        // Solicitud GET al endpoint con fecha y hora específicas
        mockMvc.perform(MockMvcRequestBuilders.get("/priceController/getPricePattern/{startDate}/{productId}/{brandId}"
        		,"2020-06-14T10:00:00", PRODUCT_ID, BRAND_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("MockedResponse"));
    }
    
    @Test
    public void testGetPricePattern_dos() throws Exception {
        Mockito.when(priceService.getPricePattern(Mockito.any(LocalDate.class), Mockito.eq(PRODUCT_ID), Mockito.eq(BRAND_ID)))
                .thenReturn("MockedResponse");
        // Solicitud GET al endpoint con fecha y hora específicas
        mockMvc.perform(MockMvcRequestBuilders.get("/priceController/getPricePattern/{startDate}/{productId}/{brandId}"
        		,"2020-06-14T16:00:00", PRODUCT_ID, BRAND_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("MockedResponse"));
    }
    
    @Test
    public void testGetPricePattern_tres() throws Exception {
        Mockito.when(priceService.getPricePattern(Mockito.any(LocalDate.class), Mockito.eq(PRODUCT_ID), Mockito.eq(BRAND_ID)))
                .thenReturn("MockedResponse");
        // Solicitud GET al endpoint con fecha y hora específicas
        mockMvc.perform(MockMvcRequestBuilders.get("/priceController/getPricePattern/{startDate}/{productId}/{brandId}"
        		,"2020-06-14T21:00:00", PRODUCT_ID, BRAND_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("MockedResponse"));
    }
    
    @Test
    public void testGetPricePattern_cuatro() throws Exception {
        Mockito.when(priceService.getPricePattern(Mockito.any(LocalDate.class), Mockito.eq(PRODUCT_ID), Mockito.eq(BRAND_ID)))
                .thenReturn("MockedResponse");
        // Solicitud GET al endpoint con fecha y hora específicas
        mockMvc.perform(MockMvcRequestBuilders.get("/priceController/getPricePattern/{startDate}/{productId}/{brandId}"
        		,"2020-06-15T10:00:00", PRODUCT_ID, BRAND_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("MockedResponse"));
    }
    
    @Test
    public void testGetPricePattern_cinco() throws Exception {
        Mockito.when(priceService.getPricePattern(Mockito.any(LocalDate.class), Mockito.eq(PRODUCT_ID), Mockito.eq(BRAND_ID)))
                .thenReturn("MockedResponse");
        // Solicitud GET al endpoint con fecha y hora específicas
        mockMvc.perform(MockMvcRequestBuilders.get("/priceController/getPricePattern/{startDate}/{productId}/{brandId}"
        		,"2020-06-21T16:00:00", PRODUCT_ID, BRAND_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("MockedResponse"));
    }
}