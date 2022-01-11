package com.hair.salon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hair.salon.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
} // class UserService
