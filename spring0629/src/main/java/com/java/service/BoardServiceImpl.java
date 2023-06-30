package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.dto.CommentDto;
import com.java.mapper.BoardMapper;

@Service 
//객체선언을 위해 서비스를 해줌 
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper; 
	
	@Override //게시글 전체 가져오기 
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = new ArrayList<>();
		//게시글 전체 가져오기 
		list = boardMapper.selectAll();
		
		return list;
	}

	@Override //게시글 1개 가져오기
	public BoardDto selectOne(int bno) {
		// 게시글 1개 가져오기 
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

	@Override //하단 댓글 전체 가져오기 
	public ArrayList<CommentDto> selectComAll(int bno) {
		ArrayList<CommentDto> comList = boardMapper.selectComAll(bno);
		return comList;
	}

	@Override//하단 댓글 저장
	public CommentDto commentInsert(CommentDto comDto) {
		
		//하단 댓글 저장 후
		boardMapper.commentInsert(comDto);
		System.out.println( "BoardServiceImpl comDto cno : " + comDto.getCno());
		System.out.println( "BoardServiceImpl comDto cdate : " + comDto.getCdate());
		//바로 하단 댓글 1개 가져오기를 동시에 한다. 
		CommentDto cdto = boardMapper.selectComOne(comDto);
		return cdto;
	}



}
