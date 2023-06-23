package com.java.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}//index
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}//login
	
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		//섹션 전체 삭제
		session.invalidate();
		model.addAttribute("logout", 1);
		return "logoutCheck";
	}//logout
	
	
	@RequestMapping("/doLogin")
	public String doLogin(String id, String pw, Model model
			) {
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		//db검색
		if(id.equals("admin")&& pw.equals("1111")) {
			
			//session 설정하는 부분
			//HttpServletRequest request; 
			//HttpSession session = request.getSession();
			
			//@Autowired 객체로 받았기 때문에 위 주석처리 되어있는 걸 안 해도 된다. 
			session.setAttribute("sessionId", id);
			model.addAttribute("loginCheck", 1);
		}else {
			
			model.addAttribute("loginCheck", 0);
		}
		
		
		
		return "loginCheck";
	}//doLogin
	
	
	
}

