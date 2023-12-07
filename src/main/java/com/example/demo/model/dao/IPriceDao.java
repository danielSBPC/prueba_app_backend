package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.Price;


public interface IPriceDao extends CrudRepository<Price, Integer> {

	
}