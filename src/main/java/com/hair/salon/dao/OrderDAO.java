package com.hair.salon.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hair.salon.vo.OrderVO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSession session;

	/* 예약 리스트 페이지 이동(조회) */
	public ArrayList<OrderVO> getOrderList(String userNm) {
		ArrayList<OrderVO> result = null;
		OrderMapper mapper = null;
		
		try {
			mapper = session.getMapper(OrderMapper.class);
			result = mapper.getOrderList(userNm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 예약 */
	public int insertReserve(OrderVO newOrder) 
	{
		int result = 0;
		OrderMapper mapper = null;
		
		try
		{
			mapper = session.getMapper(OrderMapper.class);
			result = mapper.insertReserve(newOrder);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
} // class OrderDAO
