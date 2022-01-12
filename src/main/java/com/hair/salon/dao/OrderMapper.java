package com.hair.salon.dao;

import java.util.ArrayList;

import com.hair.salon.vo.OrderVO;

public interface OrderMapper {
	
	/* 예약 리스트 페이지 이동(조회) */
	ArrayList<OrderVO> getOrderList(String userNm);

	/* 예약 */
	int insertReserve(OrderVO newOrder);

}
