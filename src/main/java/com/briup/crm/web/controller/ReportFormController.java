package com.briup.crm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.jfree.data.category.CategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.util.JFreeChartUtil;
import com.briup.crm.service.interfaces.IReportFormsService;

@Controller
public class ReportFormController {
	
	@Autowired
	private IReportFormsService ireportservice;
	
	//点击客户贡献分析
	@RequestMapping("/contr")
	public String showCustContributionAnalysis(String cstname, HttpServletRequest request){
		
			try {
			//接受一个数据集合对象
			CategoryDataset dataset = ireportservice.findCstcontribute(cstname);
			//保存图片，返回图片文件名
			String imgName = JFreeChartUtil.createBarChart("客户贡献分析表", "客户", "金额", dataset, request);
			// 获取图片路径（内存中） 需要在web.xml中配置一下
			String chartURL = request.getContextPath() + "/chart?filename=" + imgName;
			request.getSession().setAttribute("chartURL", chartURL);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jfreechart/contr";
	}
	//点击客户构成分析
	@RequestMapping("/cons")
	public String showCustConstituteAnalysis(Integer condit, HttpServletRequest request){
		try {
			//获取一个CategoryDataSet对象
			CategoryDataset dataset =ireportservice.findCstMakeup(condit);
			String title="";
			if(condit==0){
				title = "客户级别百分比分析表";
			}else if(condit==1){
				title = "客户信誉度分析表";
			}else if (condit==2) {
				title = "客户满意度分析表";
			}
		// 保存图片 返回图片文件名
		String fileName = JFreeChartUtil.createBarChart(title,"客户类型", "百分比",dataset, request);
		// 获取图片路径（内存中） 需要在web.xml中配置一下
		String chartURL = request.getContextPath() + "/chart?filename=" + fileName;
		request.getSession().setAttribute("charturl", chartURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "jfreechart/cons";
	}
}
