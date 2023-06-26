package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService; 
	
	@RequestMapping("/board/boardList")
	public String boardList(Model model) {
		//게시글 전체 가져오기 
		ArrayList<BoardDto> list = boardService.selectAll();
		model.addAttribute("list" , list);
		return "board/boardList";
	}//boardList

	@RequestMapping("/board/boardView")
	public String boardView(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("boardView bno: "+ bno);
		//게시글 1개 가져오기 
		BoardDto btdo = boardService.selectOne(bno);
		model.addAttribute("bdto", btdo);
		return "board/boardView";
	}//boardView
	
	@GetMapping("/board/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}//boardView
	
	@PostMapping("/board/boardWrite")
	public String doboardWrite(BoardDto bdto, @RequestPart MultipartFile file,
			Model model) throws Exception {
		
		//게시글 1개 저장
		String fileName ="";
		
		//파일이 있을 경우에 파일 저장 
		if(!file.isEmpty()) {
			
			//실제 파일 이름 
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID(); //랜덤 숫자가 생성 
			fileName = uuid+"_"+ori_fileName; //변경 파일 이름 - 중복 방지
			String uploadUrl = "c:/upload/";//파일 업로드 위치 
			File f = new File(uploadUrl+fileName); 
			file.transferTo(f); //파일 저장 
			
			
		}
		System.out.println("doboardWrite bfile: "+ fileName);
		bdto.setBfile(fileName);
		
		boardService.insertOne(bdto);
		
		return "redirect:boardList";
	}//boardWrite
	
	
	
}
