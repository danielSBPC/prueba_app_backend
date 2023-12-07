package com.example.demo.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IPriceDao;
import com.example.demo.model.entity.Price;

@Service
public class PriceService implements IPriceService {

	@Autowired
	private IPriceDao priceDao;
	
	
	@Override
	public List<Price> getPrices() {
		return (List<Price>) priceDao.findAll();
	}

	@Override
	public String getPricePattern(LocalDate startDate, int productId, int brandId) {
		List<Price> listaPrecios = (List<Price>) priceDao.findAll();
		Price registroPrecio = null;
		for (int i = 0; i < listaPrecios.size(); i++) {
			if (startDate.isEqual(listaPrecios.get(i).getStartDate()) &&
					productId == listaPrecios.get(i).getProductId() &&
					brandId == listaPrecios.get(i).getBrandId()) {
				registroPrecio = listaPrecios.get(i);
			}
		}
		return registroPrecio.toString();
	}

}
