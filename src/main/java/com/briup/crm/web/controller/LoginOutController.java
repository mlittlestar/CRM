package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginOutController {

	@RequestMapping("/loginOut")
	public String showLoginOut(HttpSession session){
		
		session.invalidate();
		
		
		return "index";
		
	}
	
}
