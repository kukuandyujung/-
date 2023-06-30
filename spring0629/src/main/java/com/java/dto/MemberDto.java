package com.java.dto;

import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor; 

@Data //getter setter
@NoArgsConstructor  //기본 생성자 
@AllArgsConstructor  //전체 생성자 
public class MemberDto {

	private String id, pw, name, phone, gender;
	private String[] hobbys; //용량에 무리가 갈 거 같을 때 어레이가 아니라 배열로
	private String hobby;
}
