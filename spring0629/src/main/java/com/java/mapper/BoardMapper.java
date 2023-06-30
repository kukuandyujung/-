package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;


@Mapper
public interface BoardMapper {

	//게시글 전체 가져오기 
	ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기 
	BoardDto selectOne(int bno);

	//하단 댓글 전체 가져오기 
	ArrayList<CommentDto> selectComAll(int bno);

	//하단 댓글 저장하기 
	void commentInsert(CommentDto comDto); //리턴 타입이 없어야 한다. insert이기 때문에 

	//하단 댓글 1개 가져오기 
	CommentDto selectComOne(CommentDto comDto);

	
}
