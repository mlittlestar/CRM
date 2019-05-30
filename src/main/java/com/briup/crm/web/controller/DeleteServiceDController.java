package com.briup.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.CstServiceMapper;
import com.briup.crm.service.interfaces.ICstService;

@Controller
public class DeleteServiceDController {
	
	@Autowired
	private ICstService iCstService;
	
	@RequestMapping("{svrId}/deleteSD")
	public String deleteServiceD(@PathVariable Long svrId){
		
		System.out.println(svrId);
		/*try {
			iCstService.delete(svrId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return "cust_service/dispatch";
		
	}

}
