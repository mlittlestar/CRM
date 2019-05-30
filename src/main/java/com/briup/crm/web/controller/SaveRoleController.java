package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller
public class SaveRoleController {
	
	@Autowired
	private ISysUserService iSysUserService;
	
	@RequestMapping("/addR")
	public String Addrole(SysRole role){
		
//		System.out.println(role);
		
		try {
			iSysUserService.addRole(role);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "systemset/role_manage";
		
	}
	

}
