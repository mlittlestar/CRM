package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageInfo;

@Controller
public class BasicController {
	
	@Autowired
	private IBasicDataService iBasicDataService;
	
	@RequestMapping("{curPage}/product")
	public String showProduct(@PathVariable Integer curPage,HttpSession session){
		
		try {
			
			PageInfo<Product> productAll = iBasicDataService.findProductAll(curPage, 2);
			session.setAttribute("productAll", productAll);
			System.out.println(productAll);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "basic/product";
		
	}
	@RequestMapping("{curpage}/storage")
	public String showStorage(@PathVariable Integer curpage,HttpSession session){
		
		try {
			PageInfo<Storage> storageAll = iBasicDataService.findStorageAll(curpage, 3);
			session.setAttribute("storageAll", storageAll);
			System.out.println(storageAll);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "basic/storage";
		
	}

}
