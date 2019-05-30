package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstService;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICstService;
import com.github.pagehelper.PageInfo;

@Controller
public class ServiceController {
	
	@Autowired
	private ICstService iCstService;
	
	
	@RequestMapping("/serviceadd")
	public String showserviceAdd(){
		
		return "cust_service/add";
		
	}
	@RequestMapping("{curPage}/servicedeal")
	public String showserviceDeal(@PathVariable Integer curPage,HttpSession session){
		
		
		try {
			PageInfo<CstService> lService = iCstService.findAllService(curPage, 3);
			session.setAttribute("Services", lService);
			System.out.println(lService);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_service/deal";
		
	}
	@RequestMapping("{curPage}/servicedispatch")
	public String showserviceDispatch(@PathVariable Integer curPage,HttpSession session){
		
		try {
			PageInfo<CstService> AllService = iCstService.findAllService(curPage, 2);
			session.setAttribute("AllService", AllService);
			System.out.println(AllService);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_service/dispatch";
		
	}
	@RequestMapping("/serviceFeekback")
	public String showserviceFeekback(){
		
		return "cust_service/feedback";
		
	}
	@RequestMapping("/feedback_detail")
	public String showDetal(){
		
		return "cust_service/feedback_detail";
		
	}
	@RequestMapping("/deal_detail")
	public String showDDetal(){
		
		return "cust_service/deal_detail";
		
	}	

}

