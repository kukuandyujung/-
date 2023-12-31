package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	
//	@RequestMapping("/board/searchList")
//	public String searchList( Model model) {
//		return "board/boardList";
//	}
	

	@RequestMapping("/board/boardList")
	public String boardList(@RequestParam(defaultValue = "1") int page, 
			String category , String s_word,Model model) {
		
		System.out.println("BoardController boardList category : " + category);
		//게시글 전체 가져오기 	
		HashMap<String,Object> map = boardService.selectAll(page, category,s_word);
		
		model.addAttribute("list" ,map.get("list"));
		model.addAttribute("page" ,map.get("page"));
		model.addAttribute("listCount" ,map.get("listCount"));
		model.addAttribute("startPage" ,map.get("startPage"));
		model.addAttribute("endPage" ,map.get("endPage"));
		model.addAttribute("maxPage" ,map.get("maxPage"));
		model.addAttribute("category" ,map.get("category"));
		model.addAttribute("s_word" ,map.get("s_word"));
		return "board/boardList";
	}//boardList
	
	@PostMapping("/board/boardReply") 
	public String doBoardReply(BoardDto bdto, @RequestPart MultipartFile file
			, Model model) throws Exception {
		
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
		System.out.println("doBoardReply bfile: "+ fileName);
		bdto.setBfile(fileName);
		System.out.println("doBoardReply bgroup : " + bdto.getBgroup());
		boardService.insertReplyOne(bdto);
		
		return "redirect:boardList";
		
		
	}//답변달기 저장 
	
	
	@GetMapping("/board/boardReply")
	public String boardReply(int bno, Model model) {
		System.out.println("boardReply bno : "+bno);
		
		HashMap<String, Object> map= boardService.selectOne(bno);
		model.addAttribute("bdto", map.get("bdto"));		
		return "board/boardReply";
	}//답변달기 view

	@GetMapping("/board/boardUpdate") //boardUpdate에 있는 뷰 페이지가 열림
	public String boardUpdate(int bno, 
			int page, String category, String s_word, Model model) {
		System.out.println("boardUpdate bno"+ bno );
		
		HashMap<String, Object> map= boardService.selectOne(bno);
		model.addAttribute("bdto", map.get("bdto"));
		
		model.addAttribute("category", category);
		model.addAttribute("s_word", s_word);
		model.addAttribute("page", page);
		return "board/boardUpdate";
	}//boardUpdate
	
	@RequestMapping("/board/boardDelete")
	public String boardDelete(int bno) {
		System.out.println("boardDelete" + bno);
		boardService.deleteOne(bno);
		return "redirect:boardList";
	}//boardDelete
	
	
	@PostMapping("/board/boardUpdate") //boardUpdate에 저장하기 
	public String doBoardUpdate(BoardDto bdto,@RequestPart MultipartFile file,
		   int page, String category, String s_word,Model model)throws Exception {
			//게시글 1개 수정
			System.out.println("doBoardUpdate bdto" + bdto.getBno());
		
			String fileName ="";
			//파일이 있을 경우에 파일 저장 
			if(!file.isEmpty()) {	 
				String ori_fileName = file.getOriginalFilename();//실제 파일 이름
				UUID uuid = UUID.randomUUID(); //랜덤 숫자가 생성 
				fileName = uuid+"_"+ori_fileName; //변경 파일 이름 - 중복 방지
				String uploadUrl = "c:/upload/";//파일 업로드 위치 
				File f = new File(uploadUrl+fileName); 
				file.transferTo(f); //파일 저장 	
				bdto.setBfile(fileName);
				
			}
			boardService.updateOne(bdto);
			s_word = URLEncoder.encode(s_word, "utf-8"); //수정 후 목록으로 돌아오지 않은 이유는 한글이 지원되지 않았었기 때문
			
//			return "redirect:boardList";
			return "redirect:boardList?page="+page+"&category="+category+"&s_word="+s_word;
	}//doboardUpdate
	
	
	
	

	@RequestMapping("/board/boardView")
	public String boardView(@RequestParam(defaultValue = "1") int bno, 
		   int page, String category, String s_word, Model model) {
		System.out.println("boardView bno: "+ bno);
		//게시글 1개 가져오기 
		HashMap<String, Object> map= boardService.selectOne(bno);
		model.addAttribute("bdto", map.get("bdto"));
		model.addAttribute("prevDto", map.get("prevDto"));
		model.addAttribute("nextDto", map.get("nextDto"));
		model.addAttribute("category", category);
		model.addAttribute("s_word", s_word);
		model.addAttribute("page", page);
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
