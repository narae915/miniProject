package com.hair.salon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hair.salon.dao.OrderDAO;
import com.hair.salon.vo.OrderVO;

@Service
public class OrderService {

	@Autowired
	private OrderDAO dao;

	/* 예약 리스트 페이지 이동(조회) */
	public ArrayList<OrderVO> getOrderList(String userNm) {
		return dao.getOrderList(userNm);
	}

	/* 예약 */
	public boolean insertReserve(String loginName, int desNum, String resIndate, String hairType, int price) 
	{
		OrderVO newOrder = new OrderVO();
		newOrder.setUserNm(loginName);
		newOrder.setDesNum(desNum);
		newOrder.setResIndate(resIndate);
		newOrder.setHairType(hairType);
		newOrder.setPrice(price);
		
		return dao.insertReserve(newOrder) > 0;
	}
	
} // class OrderService
