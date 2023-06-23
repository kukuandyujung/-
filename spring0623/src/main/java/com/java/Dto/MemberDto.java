package com.java.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String job;
	private String hobby;
	private String phone;
}
