package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller


public class SysUserController{
	
	@Autowired
	private ISysUserService iSysUserService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showMain(@RequestParam String username,@RequestParam String password,HttpSession session){
		
		System.out.println(username);
		System.out.println(password);
		
		 
		try {
			SysUser	sysuser = iSysUserService.login(username, password);
			SysRole sysRole=new SysRole();
			
			if(sysuser.getUsrFlag()==1){
				
				//将登陆后的用户信息保存在session里
//				session.setAttribute("username", username);
				session.setAttribute("user", sysuser);
				
				
				return "main";
				
				
				
		} 
	    }catch (CrmCommonException e) {
			session.setAttribute("msg", "失败");
			return "index";
			
		}
		System.out.println("登录失败");
		return "index";
		
		
	}
	
	
	
		
}
	
	
	
	
	
	
	
	

	

		
		
		
	
	
	

