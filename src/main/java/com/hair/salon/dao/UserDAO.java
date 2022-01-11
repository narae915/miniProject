package com.hair.salon.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hair.salon.vo.UserVO;


@Repository
public class UserDAO {

	@Autowired
	private SqlSession session;
	
	public int userInsert(UserVO user) {
		int cnt=0;
		UserMapper mapper = null;
		try {
			mapper =session.getMapper(UserMapper.class);
			cnt = mapper.userInsert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public String idChk(String idChk) {
		String result = null; 
		UserMapper mapper = null; 
		try {
			mapper = session.getMapper(UserMapper.class);
			result = mapper.idChk(idChk);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String selectVO(UserVO user) {
		String result = null ;
		UserMapper mapper = null;
		try {
			mapper =session.getMapper(UserMapper.class);
			result = mapper.selectVO(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
