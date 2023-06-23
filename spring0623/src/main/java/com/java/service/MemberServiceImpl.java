package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.Dto.MemberDto;
import com.java.mapper.BoardMapper;


@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	BoardMapper boardMapper;
	
	@Override //회원 전체 가져오기 
	public ArrayList<MemberDto> memberselectAll(){
		ArrayList<MemberDto> list= boardMapper.memberselectAll();
		return list;
	}
	@Override //회원 한명 가져오기
	public MemberDto memberselectOne(String id){
		MemberDto member= boardMapper.memberselectOne(id);
		return member;
	}
}
