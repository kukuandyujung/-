package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService; 
	
	@RequestMapping("/board/notice")
	public String notice(Model model) {
		ArrayList<BoardDto> list = new ArrayList<>(); 
		//게시글 전체 가져오기 
		list = boardService.selectAll();
		model.addAttribute("list", list);
		return "board/notice";
	}
	
	@RequestMapping("/board/noticeView")
	public String noticeView(int bno, Model model) {
		//게시글 1개 가져오기 
		BoardDto bdto = boardService.selectOne(bno);
		//하단 댓글 모두 가져오기	
		ArrayList<CommentDto> comList = boardService.selectComAll(bno);
		
		model.addAttribute("bdto", bdto);
		model.addAttribute("comList", comList);
		return "board/noticeView";
	}
	
	
	@RequestMapping("board/commentInsert")
	@ResponseBody 
	//@ResponseBody 그냥 데이터로 던져 줘! 그리고 저장!
	public CommentDto commentInsert(CommentDto comDto) {
		System.out.println("ajax 넘어온 데이터 1: " + comDto.getCcontent());
		//여기는 데이터를 돌려줘야 하는 것이다.
		//하단 댓글 저장
		CommentDto cdto = boardService.commentInsert(comDto);
		
		return cdto;
	}
	
	
	
}
