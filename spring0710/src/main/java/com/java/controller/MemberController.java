package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/member/step02")//회원가입 동의
	public String step02() {
		return "member/step02";
	}
	@GetMapping("/member/step03")//회원가입 페이지 오픈
	public String step03() {
		return "member/step03";
	}
	
	@PostMapping("/member/step03") //회원가입 저장 시
	public String step03(Model model) {
		return "member/step04";
	}
}
