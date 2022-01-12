package com.hair.salon.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hair.salon.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	/* 회원가입 페이지 이동 */
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.info("join 메소드 실행(GET)");
		
		return "user/join";
	}
	
	/* 회원 가입 DB저장 메소드 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String userInsert(String userId, String userPw, String userNm, String userTel) {
		logger.info("userInsert 메소드 실행(POST)");
		logger.info("userId:{}", userId);
		logger.info("userPw:{}",userPw);
		logger.info("userNm:{}",userNm);
		logger.info("userTel:{}",userTel);

		boolean result = service.userInsert(userId,userPw,userNm,userTel);
		String returnUrl = null;

		if(result) {
			logger.info("회원가입 성공");
			returnUrl = "user/login";
		} else {
			logger.info("회원가입 실패");
			returnUrl = "user/join";
		}
		
		return returnUrl;
	}
	
	/* ID 유효성 검사 */
    @ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.GET)
	public String idChk(String idChk) {
		logger.info("idChk 메소드 실행(GET)");
		
		logger.info("idChk: {}",idChk);
		
		String userId = service.idChk(idChk);
		logger.info("userId: {}",userId);
		
		if (userId == null) { 
			logger.info("회원 가입 가능.");
			return "available";
		} else {
			logger.info("회원 가입 불가.");
			return null;
		}
		
		
	}

    /* 로그인 페이지 이동 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login메소드 실행(GET)");
		return "/user/login";
	}
	
	/* 로그인 시도 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String userId, String userPw, Model model) {
		logger.info("login메소드 실행(POST)");
		logger.info("userId:{} ",userId);
		logger.info("userPw:{} ",userPw);
		
		String userNm = service.selectUserNm(userId,userPw);
		String returnUrl= null;
		logger.info("userNm:{} ",userNm);
		
		String errorMessage ="ID와 PW가 일치 하지 않습니다.";
		
		if(userNm == null) {
			logger.info("로그인 실패");
			
			model.addAttribute("errorMessage",errorMessage);
			returnUrl = "/user/login";
		}else {
			logger.info("로그인 성공");
			session.setAttribute("loginId", userId);
			session.setAttribute("loginName", userNm);
			returnUrl = "redirect:/";
		}		
		return returnUrl;
	}
	
	/* 로그아웃 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout 메소드 실행(GET)");
		
		session.removeAttribute("loginName");
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
}