package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/todolist")
	public String todolist(){
		return "todolist";
	}
}
