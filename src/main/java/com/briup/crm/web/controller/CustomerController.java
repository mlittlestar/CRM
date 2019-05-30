package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageInfo;

@Controller

public class CustomerController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	
	//客户信息管理主页，默认查询第一页
	@RequestMapping("/{curpage}/infolist")
	public String showinfoList(@PathVariable Integer curpage,HttpSession session){
		//执行查询语句
		try {
			//不带分页
//			List<CstCustomer> list = iCustomerService.findAllCustomer();
//			session.setAttribute("clist", list);
//			System.out.println(list);
			PageInfo<CstCustomer> pageInfo=iCustomerService.findAllCstCustomer(curpage,3);
			session.setAttribute("cpageInfo", pageInfo);
			session.setAttribute("currId", pageInfo.getTotal()+1);
			System.out.println(pageInfo);
			
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_info/list";
		
	}
	
	@RequestMapping("{cstId}/linkman")
	public String showinfoLinkman(@PathVariable Long cstId,HttpSession session){
		
		try {
			List<CstLinkman> linkManByCstId = iCustomerService.findAllLinkManByCstId(cstId);
			session.setAttribute("linkManByCstId", linkManByCstId);
			
			
			System.out.println(linkManByCstId);
			
			
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_info/linkman";
		
	}
	
	@RequestMapping("/infocustomer")
	public String showinfoCustomer(){
		
		return "cust_info/add_customer";
		
	}
	@RequestMapping("{cstId}/customer_edit")
	public String showinfoEdit(@PathVariable Long cstId,HttpSession session ){
		
		
		try {
			 CstCustomer findCustomerById = iCustomerService.findCustomerById(cstId);
			 session.setAttribute("findCustomerById", findCustomerById);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "cust_info/customer_edit";
		
	}
	
	@RequestMapping("{cstNo}/activities")
	public String showinfoActivities(@PathVariable String cstNo,HttpSession session){
		
		try {
			System.out.println(cstNo);
			List<CstActivity> byCstNo = iCustomerService.findAllCstActivityByCstNo(cstNo);
			session.setAttribute("byCstNo", byCstNo);
			System.out.println(byCstNo);

		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_info/activities";
		
	}
	@RequestMapping("/linkman_add")
	public String showinfoAddlinkman(){
		
		return "cust_info/linkman_add";
		
	}
	@RequestMapping("/linkman_edit")
	public String showinfoEditlink(){
		
		return "cust_info/linkman_edit";
		
	}
	@RequestMapping("/activities_edit")
	public String showinfoEditactivities(){
		
		return "cust_info/activities_edit";
		
	}
	@RequestMapping("/activities_add")
	public String showinfoAddactivities(){
		
		return "cust_info/activities_add";
		
	}
	
}