package com.hair.salon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
<<<<<<< HEAD
@RequestMapping(value="/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	//예약 리스트 페이지 이동 메소드
	@RequestMapping(value ="/resList", method=RequestMethod.GET)
=======
@RequestMapping(value = "/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	/* 예약 리스트 페이지 이동 */
	@RequestMapping(value ="/resList", method =RequestMethod.GET)
>>>>>>> origin/chanho
	public String resList () {
		logger.info("resList 매서드 실행.(GET)");
		
		return "resList";
	}

	/* 예약 페이지 이동 */
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve()
	{
		logger.info("reserve 메서드 실행(GET).");
		
		return "reserve";
	}
	
	/* 예약 수정 페이지 이동 */
	@RequestMapping (value = "/updateRes", method = RequestMethod.GET)
	public String updateRes() 
	{
		logger.info("updateRes 메서드 실행(GET).");
		
		return "updateRes";
	}
	
} // class OrderController

