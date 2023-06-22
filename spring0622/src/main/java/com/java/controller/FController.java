package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;

@Controller
public class FController {

	@Autowired
	BoardDto bdto;
	
//	BService bService =new BServiceImpl();
	@Autowired
	BService bService;
	
	
	
//	BoardDto boardDto = new BoardDto();
	
	@GetMapping("/index")
	public String index() {
//		bdto.setBno(1);
		
		System.out.println("bon: " + bdto.getBno());
		System.out.println("s(15): " + bService.add());
		return "index";
	}
	
	
	
	
}
