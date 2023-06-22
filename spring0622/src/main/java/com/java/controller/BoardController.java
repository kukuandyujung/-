package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	BoardDto bdto;
	BoardDto boardDto = new BoardDto();
	
	@RequestMapping("/board/board1")
	public String board1() {
		return "board/board1";
	}
	
	
	
	
}
