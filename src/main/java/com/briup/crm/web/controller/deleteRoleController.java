package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller
public class deleteRoleController {
	
	@Autowired
	private ISysUserService iSysUserService;
	
	@RequestMapping("{roleId}/deleteR")
	public String deleteRole(@PathVariable Long roleId){
		
		try {
			iSysUserService.deleteRole(roleId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/role_manage";
		
	}

}
