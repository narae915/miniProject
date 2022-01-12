package com.hair.salon.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hair.salon.service.OrderService;
import com.hair.salon.vo.OrderVO;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService service;
	
	/* 예약 리스트 페이지 이동(조회) */
	@RequestMapping(value = "/resList", method = RequestMethod.GET)
	public String resList (HttpSession session, Model model) {

		logger.info("resList 메서드 실행(GET)");
		
		String userNm = (String)session.getAttribute("loginName");
		logger.info("loginName : {}", userNm);
		
		ArrayList<OrderVO> orderList = new ArrayList<>();
		orderList = service.getOrderList(userNm);
		logger.info("orderList: {}" , orderList);
		
		if(orderList != null) {
			logger.info("예약 리스트 조회 성공");
			model.addAttribute("orderList", orderList);
		} 
		
		return "order/resList";
	}

	/* 예약 페이지 이동 */
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve()
	{
		logger.info("reserve 메서드 실행(GET)");
		
		return "order/reserve";
	}
	
	/* 예약 */
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public String reserve(String resIndate, String desNumS, String resIntime, 
							String hairType, String priceS, HttpSession session, Model model)
	{
		logger.info("reserve 메서드 실행(POST)");
		
		// 예약번호, 사용자 이름, 디자이너 사원번호, 시술 종류, 가격
		String loginName = (String) session.getAttribute("loginName"); // 사용자 이름
		// 가져온 값 확인하기
		logger.info("resIndate: {}", resIndate); // 예약 날짜
		logger.info("resIntime: {}", resIntime); // 예약 시간
		// 디자이너 사원번호 인트형으로 변환
		int desNum = Integer.parseInt(desNumS);
		logger.info("desNum: {}", desNum); // 디자이너 사원번호
		logger.info("hairType: {}", hairType); // 시술 종류
		// 가격 인트형으로 변환
		int price = Integer.parseInt(priceS);
		logger.info("price: {}", price); // 가격
		// 날짜와 시간 병합
		resIndate += resIntime ;
		logger.info("resIndate: {}", resIndate); // 예약 날짜 최종
		
		String loginId = (String) session.getAttribute("loginId"); // 사용자 ID
		logger.info(loginId);
		
		boolean result = service.insertReserve(loginName, desNum, resIndate, hairType, price);
		
		String returnUrl = "order/reserve?userId=" + loginId;
		
		// 예약 성공 여부
		if ( result )
		{
			logger.info("예약 성공 !");
			
			returnUrl = "redirect:order/resList?userId=" + loginId;
		}
		else
		{
			logger.info("예약 실패");
			
			returnUrl = "order/reserve?userId=" + loginId;
		}
		
		return returnUrl;
	}
	
	/* 예약 수정 페이지 이동 */
	@RequestMapping (value = "/updateRes", method = RequestMethod.GET)
	public String updateRes() 
	{
		logger.info("updateRes 메서드 실행(GET)");
		
		return "order/updateRes";
	}
	
} // class OrderController

