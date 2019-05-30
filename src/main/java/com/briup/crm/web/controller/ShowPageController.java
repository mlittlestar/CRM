package com.briup.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowPageController {
	
	@RequestMapping("/index")
	public String showIndex(){
		
		
		return "index";
		
	}
	//左面框图
	@RequestMapping("/left")
	public String showLeft(){
		
		return "left";
		
	}
	
	//头部框图
	@RequestMapping("/top")
	public String showTop(){
		
		return "top";
		
	}
	
	//选择视图
	@RequestMapping("/switch")
	public String showSwitch(){
		
		return "switch";
		
	}
	//帮助界面
	@RequestMapping("/help")
	public String showHelp(){
		
		return "help";
		
	}
	
}
