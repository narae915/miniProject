package com.hair.salon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hair.salon.dao.OrderDAO;

@Service
public class OrderService {

	@Autowired
	private OrderDAO dao;
	
} // class OrderService
