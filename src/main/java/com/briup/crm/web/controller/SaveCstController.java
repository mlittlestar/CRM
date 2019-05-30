package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;

@Controller
public class SaveCstController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@RequestMapping("/addCst")
	public String SaveCst(CstCustomer cst){
		
		System.out.println(cst);
		
		try {
			
			System.out.println(cst);
			
			iCustomerService.saveCustomer(cst);
			
			
			
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/list";
	}
	
	
	
	

}
