package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.Dto.MemberDto;

@Mapper
public interface BoardMapper {

	//회원 전체 가져오기
	ArrayList<MemberDto> memberselectAll();

	//회원 한명 가져오기
	MemberDto memberselectOne(String id);

}
