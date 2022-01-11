package com.hair.salon.dao;

import com.hair.salon.vo.UserVO;

public interface UserMapper {
	
	// 회원가입
	int userInsert(UserVO user);
    // id체크유효성 검사
	String idChk(String idChk);
	// 로그인
	String selectVO(UserVO user);

}
