package com.hair.salon.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	// 컨트롤러의 메소드 실행 전에 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("LoginInterceptor 실행"); 
		
		// 세션의 로그인 정보 관련 정보 가져오기
		HttpSession session = request.getSession(); 
		String memberNm = (String) session.getAttribute("memberNm"); 
		
		// 로그인되지 않은 경우 로그인 페이지로 이동 
		if (memberNm == null) {
			response.sendRedirect(request.getContextPath() + "/member/login"); 
			return false;
		}
		// 로그인 된 경우 요청한 경로로 진행
		return super.preHandle(request, response, handler); 
	}

}
