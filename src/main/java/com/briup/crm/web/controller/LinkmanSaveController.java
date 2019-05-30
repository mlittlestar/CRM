package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;

@Controller
public class LinkmanSaveController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@RequestMapping("/Addlink")
	public String SaveLink(CstLinkman cstLinkman,HttpSession session){
		
		System.out.println(cstLinkman);
		
		/*try {
			cstLinkman.setLkmCustId((Long) session.getAttribute("linkManByCstId"));
			
			
			cstLinkman.setLkmId();
			iCustomerService.saveLinkMan(cstLinkman);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		return "cust_info/linkman";
		
	}

}
