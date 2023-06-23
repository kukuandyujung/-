package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.Dto.MemberDto;

@Controller
public interface MemberService {

	//회원 전체 가져오기 
	ArrayList<MemberDto> memberselectAll();

	//회원 한 명 가져오기
	MemberDto memberselectOne(String id);
	}


	

