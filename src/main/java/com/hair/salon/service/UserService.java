package com.hair.salon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hair.salon.dao.UserDAO;

import com.hair.salon.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	// 회원가입
	public boolean userInsert(String userId, String userPw, String userNm, String userTel) {
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserNm(userNm);
		user.setUserTel(userTel);
		
		int cnt = dao.userInsert(user);
		if(cnt > 0) return true;
		else	return false;
	}

	public String idChk(String idChk) {
		return dao.idChk(idChk);
	}

	public String selectVO(String userId, String userPw) {
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		return dao.selectVO(user);
	}
	
	

}
