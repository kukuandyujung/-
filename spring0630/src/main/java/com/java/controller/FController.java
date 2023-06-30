package com.java.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.java.dto.BoardDto;
@Controller
public class FController {
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/form1")
	public String form1() {
		return "form1";
	}
	@RequestMapping("/doform1")
	public String doform1(BoardDto boardDto, @RequestPart MultipartFile files, Model model ) throws Exception {
		
		String fileName="";
		if(!files.isEmpty()) {
			String ori_fileName = files.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+fileName);
			files.transferTo(f); //파일저장
		}
		
		
		
		model.addAttribute("fileName",fileName);
		model.addAttribute("btitle",boardDto.getBtitle());
		
		System.out.println(fileName);
		System.out.println(boardDto.getBtitle());
		return "fileCheck";
	}
	
	@RequestMapping("/form2")
	public String form2() {
		return "form2";
	}
	@RequestMapping("/doform2")
	public String doform2(BoardDto boardDto,List<MultipartFile> files, Model model ) throws Exception {
		
		String fNames="";
		String fileName="";	
		int i = 0;
		for(MultipartFile file : files ) {
			//System.out.println(file.getOriginalFilename());
			
			
			
			String ori_fileName = file.getOriginalFilename();
			
			
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f); //파일저장
			
	
			if(i==0) fNames += fileName;
			else fNames += ","+ fileName;
			
			
			i++;
		}
		
		System.out.println(fileName);
		
		String[] splitNames = fNames.split(",");
		
		boardDto.setBfile(fNames);
		boardDto.setBfiles(splitNames);
		model.addAttribute("bdto",boardDto);
		
		
		System.out.println(fNames);
		System.out.println(boardDto.getBtitle());
		
		
		return "fileCheck2";
	}
	
	@RequestMapping("/form3")
	public String form3() {
		return "form3";
	}
}