package com.hair.salon.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String userInsert() {
		logger.info("userInsert메소드 실행GET");
		return "/user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String userInsert(String userId, String userPw, String userNm, String userTel) {
		
		logger.info("userInsert 메소드 실행POST");
		logger.info("userId:{}", userId);
		logger.info("userPw:{}",userPw);
		logger.info("userNm:{}",userNm);
		logger.info("userTel:{}",userTel);
		boolean result = service.userInsert(userId,userPw,userNm,userTel);
		String returnUrl;
		if(result) {
			System.out.println("회원가입 성공");
			returnUrl = "redirect:/user/login";
		}else {
			System.out.println("회원가입 실패");
			returnUrl = "redirect:/user/join";
		}
		
		return returnUrl;
	}
	
	//id유효성 검사
    @ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.GET)
	public String idChk(String idChk) {
		logger.info("idChk 메소드 실행(GET).");
		
		//JSP에서 전달받은, 사용자가 입력한 ID 값을 확인
		logger.info("idChk: {}",idChk);
		
		// 사용자가 입력한ID가 이미 데이터베이스의 테이블에 존재하는지 확인
		String memberId = service.idChk(idChk);
		logger.info("memberId: {}",memberId);
		
		if (memberId == null) { // 아직 중복된 ID가 없는 경우 = 회원 가입이 가능한 경우
			logger.info("회원 가입 가능.");
			
			return "available";
		} else {// 이미 중복된 ID가 있는 경우 = 회원 가입이 불가능한 경우
			logger.info("회원 가입 불가.");
			
			return null;
		}
		
		
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		logger.info("login메소드 실행GET");
		return "/user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,String userId, String userPw) {
		logger.info("login메소드 실행POST");
		logger.info("userId:{} ",userId);
		logger.info("userPw:{} ",userPw);
		
		String name = service.selectVO(userId,userPw);
		String returnUrl;
		logger.info("name:{} ",name);
		
		if(name == null) {
			logger.info("로그인 실패");
			returnUrl = "/user/login";
		}else {
			logger.info("로그인 성공");
			session.setAttribute("loginId", userId);
			session.setAttribute("loginName", name);
			returnUrl = "redirect:/";
			
		}		
		return returnUrl;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout 메소드 실행(GET)");
		
		session.removeAttribute("loginName");
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	@RequestMapping(value="/reserve", method=RequestMethod.GET)
	public String reserve() {
		logger.info("reserve메소드 실행GET");
		return "/order/reserve";
	}
	
}