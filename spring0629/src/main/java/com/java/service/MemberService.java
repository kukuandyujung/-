package com.java.service;



import com.java.dto.MemberDto;


//ioc에 넣으려고 
public interface MemberService {

	//로그인 확인
	MemberDto selectLogin(MemberDto memberDto);

}
