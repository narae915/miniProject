package com.hair.salon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	//예약 리스트 페이지 이동 메소드
	@RequestMapping(value ="/resList", method=RequestMethod.GET)
	public String resList () {
		logger.info("resList 매서드 실행.(GET)");
		
		return "resList";
	}
	
	
}
