package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageInfo;

@Controller
public class SelectController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@RequestMapping("/select")
	public String SelectCst(CstCustomer cstCustomer,HttpSession session){
		
		System.out.println(cstCustomer);
		
		try {
			
			PageInfo<CstCustomer> pageInfo=iCustomerService.findCustomerPageByCon(1, 2, cstCustomer);
			session.setAttribute("cpageInfo", pageInfo);
			System.out.println(pageInfo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_info/list";
		
	}

}
