package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	public String id;
	public String pw;
	public String name;
	public String phone;
	public String gender;
	public String hobby;
}
