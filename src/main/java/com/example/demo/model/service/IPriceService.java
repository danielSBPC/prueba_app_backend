package com.example.demo.model.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.entity.Price;

public interface IPriceService {

	public List<Price> getPrices();
	
	public String getPricePattern(LocalDate startDate, int productId, int brandId); 
	
}
