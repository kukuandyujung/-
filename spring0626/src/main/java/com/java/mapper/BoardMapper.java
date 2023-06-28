package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll(int startRow, int endRow, String category, String s_word);

	
	//게시글 1개 가져오기 
	BoardDto selectOne(int bno);
	//게시글 이전 글 
	BoardDto selectPreOne(int bno);
	//게시글 다음 글 
	BoardDto selectNextOne(int bno);
	//게시글 조회수 1 증가 
	void updateBhitUp(int bno);
	
	//게시글 1개 저장
	void insertOne(BoardDto bdto);

	//게시글 1개 삭제 
	void deleteOne(int bno);

	//게시글 1개 수정
	void updateOne(BoardDto bdto);

	//게시물 bstep 1 증가 
	void updateBstepCount(BoardDto bdto);
	
	//게시글 답변 달기 
	void insertReplyOne(BoardDto bdto);

	//게시글 전체 개수 
	int selectListCount(String category, String s_word);



	

	
 }
