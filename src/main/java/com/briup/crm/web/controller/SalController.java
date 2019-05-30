package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageInfo;

@Controller
public class SalController {
	
	@Autowired
	private ISalChanceService iSalChanceService;
	
	@RequestMapping("/{curpage}/salchance")
	public String showSalchance(@PathVariable Integer curpage,HttpSession session){
		
		
		try {
			PageInfo<SalChance> salChanceBypage = iSalChanceService.findSalChanceByPage(curpage, 3);
			session.setAttribute("salChanceByPage", salChanceBypage);
			
			session.setAttribute("salId", salChanceBypage.getTotal()+1);
			
			System.out.println(salChanceBypage);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "sale/list";
		
	}
	
	@RequestMapping("/salplan")
	public String showSalPlan(HttpSession session){
		
		try {
			List<SalPlan> salPlan = iSalChanceService.findAllSalPlan();
			session.setAttribute("salPlan",salPlan);
			System.out.println(salPlan);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/dev";
		
	}
	
	@RequestMapping("/add_salchance")
	public String showSalchance(){
		
		return "sale/add_salchance";
		
	}
	@RequestMapping("/dispatch")
	public String showDispatch(){
		
		return "sale/dispatch";
		
	}
	@RequestMapping("{chcId}/edit")
	public String showEdit(@PathVariable Long chcId,HttpSession session){
		
//		System.out.println(chcId);
		
		try {
			
			SalChance chanceID = iSalChanceService.findOneSalChance(chcId);
			session.setAttribute("chanceID", chanceID);
			System.out.println(chanceID);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/edit";
		
	}
	@RequestMapping("/dev_plan")
	public String showPlan(){
		
		return "sale/dev_plan";
		
	}
	@RequestMapping("/dev_detail")
	public String showDetail(){
		
		return "sale/dev_detail";
		
	}
	@RequestMapping("/dev_execute")
	public String showExecute(){
		
		return "sale/dev_execute";
		
	}
	

}
