package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.entity.Price;
import com.example.demo.model.service.IPriceService;


@RestController
@RequestMapping(value="priceController")
public class PriceController {
    private static final Logger logger = LoggerFactory.getLogger(PriceController.class);

	@Autowired
	private IPriceService priceService;
	
	@GetMapping(value="getPrices")
	public List<Price> getPrices(){
		return priceService.getPrices();
	}
	
	@GetMapping(value = "getPricePattern/{startDate}/{productId}/{brandId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String getPricePattern(@PathVariable String startDate,
                                  @PathVariable int productId, @PathVariable int brandId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDate fechaParseada = LocalDate.parse(startDate, formatter);

        try {
            logger.info("Received request for startDate={}, productId={}, brandId={}", fechaParseada, productId, brandId);
            return priceService.getPricePattern(fechaParseada, productId, brandId);
        } catch (Exception e) {
            logger.error("Error processing request", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
	
}
