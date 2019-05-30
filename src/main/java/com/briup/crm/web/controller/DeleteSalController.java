package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISalChanceService;

@Controller
public class DeleteSalController {
	
	@Autowired
	private ISalChanceService iSalChanceService;
	
	@RequestMapping("{chcId}/deleteSal")
	public String DeleteSal(@PathVariable Long chcId){
		
		try {
			iSalChanceService.deleteSalChance(chcId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/list";
		
	}

}
