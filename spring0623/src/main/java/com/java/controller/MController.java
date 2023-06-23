package com.java.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.Dto.MemberDto;
import com.java.service.MemberService;
@Controller
public class MController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member/memberView")
	public String memberView(String id, Model model) {
		System.out.println("MControllerid" + id);
		
		//회원 1명 가져오기 
		MemberDto member = memberService.memberselectOne(id);
		model.addAttribute("member" , member);
		return "member/memberView";
	}
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model) {
		//회원 전체 가져오기 
		ArrayList<MemberDto> list = memberService.memberselectAll();
		model.addAttribute("list",list);
		System.out.println("MCtroller list"+list);
		return "member/memberList";
	}
	
}