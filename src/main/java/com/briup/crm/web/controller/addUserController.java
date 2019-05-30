package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller
public class addUserController {

	@Autowired
	private ISysUserService iSysUserService;
	
	@RequestMapping("/addU")
	public String AddUser(SysUser user){
		
//		System.out.println(user);
		
		try {
			iSysUserService.addUser(user);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/user_manage";
		
	}
}
