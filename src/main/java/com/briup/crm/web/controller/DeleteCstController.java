package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;

@Controller
public class DeleteController {
	
	@Autowired 
	private ICustomerService iCustomerService;
	
	@RequestMapping("{id}/delete")
	public String delete(@PathVariable Long id){
		
		System.out.println("sdfhsfuy");

		try {
			
			iCustomerService.deleteCustomerById(id);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_info/list";
		
	}

}
