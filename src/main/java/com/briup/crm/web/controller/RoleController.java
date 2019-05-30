package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ILogService;
import com.briup.crm.service.interfaces.ISysUserService;
import com.github.pagehelper.PageInfo;

@Controller
public class RoleController {
	
	@Autowired
	private ISysUserService iSysUserService;
	@Autowired
	private ILogService iLogService;
	
	@RequestMapping("{curpage}/log_review")
	public String showReview(@PathVariable Integer curpage,HttpSession session){
		
		try {
			PageInfo<CstLog> allLog = iLogService.findAllLog(curpage, 2);
			session.setAttribute("allLog", allLog);
			System.out.println(allLog);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/log_review";
		
	}
	@RequestMapping("{curpage}/user_manage")
	public String showuserManage(@PathVariable Integer curpage,HttpSession session){
		
		
		System.out.println("-------------");
		
		try {
			
			PageInfo<SysUser> allSysUser = iSysUserService.findAllSysUser(curpage, 2);
			session.setAttribute("allSysUser", allSysUser);
			session.setAttribute("userId", allSysUser.getTotal()+1);
			System.out.println(allSysUser);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/user_manage";
		
	}
	@RequestMapping("/role_manage")
	public String showRolemanage(HttpSession session){
		
		
		try {
			
			List<SysRole> role = iSysUserService.findAllRole();
			session.setAttribute("role", role);
			System.out.println(role);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/role_manage";
		
	}
	
	@RequestMapping("/addrole")
	public String showAddRole(){
		
		return "systemset/addRole";
		
	}
	@RequestMapping("/role_update")
	public String showUpdate(){
		
		return "systemset/role_update";
		
	}
	@RequestMapping("/sysadd")
	public String showSysAdd(){
		
		return "systemset/add";
		
	}
	@RequestMapping("/user_update")
	public String showSysUupdate(){
		
		return "systemset/user_update";
		
	}
	
	

}
