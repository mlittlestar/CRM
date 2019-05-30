package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;

@Controller
public class UpdeteCstController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@RequestMapping("/update")
	public String update(CstCustomer cstCustomer){
		
		
//       System.out.println(cstCustomer);
		
		try {
			System.out.println(cstCustomer);
			
			iCustomerService.updateCustomer(cstCustomer);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_info/list";
		
	}

}
