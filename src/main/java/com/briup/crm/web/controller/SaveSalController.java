package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISalChanceService;

@Controller
public class SaveSalController {
	
	@Autowired
	private ISalChanceService iSalChanceService;
	
	@RequestMapping("/addsal")
	public String SaveSal(SalChance sc){
		
//		System.out.println(sc);
		
		try {
			System.out.println(sc);
			iSalChanceService.saveChance(sc);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/list";
		
	}

}
