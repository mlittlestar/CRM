package com.briup.crm.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstCustomerExample;
import com.briup.crm.common.bean.Orders;
import com.briup.crm.common.bean.OrdersExample;
import com.briup.crm.common.bean.OrdersLine;
import com.briup.crm.common.bean.OrdersLineExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.CstCustomerMapper;
import com.briup.crm.dao.mapperInterface.OrdersLineMapper;
import com.briup.crm.dao.mapperInterface.OrdersMapper;
import com.briup.crm.service.interfaces.ICustomerService;
import com.briup.crm.service.interfaces.IReportFormsService;

@Service
public class IReportFormServiceImpl implements IReportFormsService{
	
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private CstCustomerMapper cstCutomerMappler;
	
	@Autowired
	private OrdersMapper ordersMapper; 
	
	@Autowired
	private OrdersLineMapper lineMapper;
	//客户贡献分析
	public CategoryDataset findCstcontribute(String cust_name) throws Exception {
		
		//查出所有的客户，我们要根据的客户的id来判断是否下了订单
		//再根据订单的编号，去查询他的订单列表，获得总金额
		if(StringUtils.isBlank(cust_name)){
		//如果查询框中为空，则查询全部。
		//查询所有客户
		CstCustomerExample example =new CstCustomerExample();
		List<CstCustomer> list=(cstCutomerMappler.selectByExample(example));
		
		//这个数据集应用在柱状图当中
		DefaultCategoryDataset dataset= new DefaultCategoryDataset();
		for (CstCustomer cstCustomer : list) {
			dataset.addValue(orderMoney(cstCustomer.getCustName()), "客户贡献分析", cstCustomer.getCustName());			
		}
			return dataset;
		}else {
			//如果查询条件不为空，显示需要查询的客户的柱子
			DefaultCategoryDataset dataset= new DefaultCategoryDataset();
			dataset.addValue(orderMoney(cust_name), "客户贡献分析", cust_name);			
			return dataset;
		}
		
		
		
		/*if(StringUtils.isBlank(cust_name)){
		//查出所有的客户
		List<CstCustomer> customers = customerService.findAllCustomer();
		//新建一个DefaultCategoryDataset对象
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//遍历集合
		for (CstCustomer cstCustomer : customers) {
			//取出每个客户的名字
			String name = cstCustomer.getCustName();
			//向数据集合中注入数据
			dataset.addValue(OrderTotal(name), "客户贡献分析", name);
		}
		return dataset;
		}else {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.setValue(OrderTotal(cust_name), "客户贡献分析", cust_name);
			return dataset;
		}*/
	}
	
	/*//内部方法调用，返回一个doubule值
	public double OrderTotal(String custName) throws CrmCommonException {
		CstCustomer customer = customerService.findCustomerByCstName(custName);
		OrdersExample example = new OrdersExample();
		example.createCriteria().andOdrCustIdEqualTo(customer.getCustId());
		List<Orders> list = ordersMapper.selectByExample(example);
		double sum = 0;
		
		OrdersLineExample lineExample = new OrdersLineExample();
		for (Orders orders : list) {
			lineExample.createCriteria().andProdIdEqualTo(orders.getOdrId());
			List<OrdersLine> ordersLines = lineMapper.selectByExample(lineExample);
			lineExample.clear();
			for (OrdersLine ordersLine : ordersLines) {
				sum += ordersLine.getOddPrice();
			}
		}
		return sum;
	}*/
	
	
	
	
	//客户构成分析
	public CategoryDataset findCstMakeup(int condit) throws CrmCommonException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//总人数
		int count = customerService.findAllCustomer().size();
		//按等级构成
		if (condit == 0) {
			//查找出所有的等级
			Set<String> sets = customerService.findAllCustomerLevelLable();
			for (String string : sets) {
				int num = customerService.findCstCustomerByLevelLable(string).size();
				//百分比
				double per = (double)num / count;
				dataset.addValue(per, "客户等级百分比", string);
			}
		} else if (condit == 1) {
			//查找出所有的信誉度
			Set<Integer> credits = customerService.findAllCustomerCredit();
			System.out.println("信誉度+++++++"+credits);
			for (Integer integer : credits) {
				int num = customerService.findCstCustomerByCredit(integer).size();
				//百分比
				double per2 = (double)num / count;
				System.out.println(per2);
				dataset.addValue(per2, "客户信用度百分比", integer);
			}
		} else if (condit == 2) {
			//查找出所有的满意度
			Set<Integer> credits = customerService.findAllCustomerSatisfy();
			for (Integer integer : credits) {
				int num = customerService.findCstCustomerBySatisfy(integer).size();
				//百分比
				double per3 = (double)num / count;
				System.out.println(per3);
				dataset.addValue(per3, "客户满意度百分比", integer);
			}
		}
		return dataset;
	}
	
	
	//这个方法是查询订单的总金额
	public double orderMoney(String custname){
		//依据客户名字来查询相关订单
		CstCustomerExample cstexample =new CstCustomerExample();
		cstexample.createCriteria().andCustNameEqualTo(custname);
		CstCustomer cst=(cstCutomerMappler.selectByExample(cstexample)).get(0);
		//根据客户ID去找订单ID，一个客户可以有多个订单
		OrdersExample ordexample = new OrdersExample();
		ordexample.createCriteria().andOdrCustIdEqualTo(cst.getCustId());
		List<Orders> orders =ordersMapper.selectByExample(ordexample);
		//根据订单ID去找订单列表，拿到总的金额
		double sum=0;
		OrdersLineExample lineExample = new OrdersLineExample();
		for (Orders order : orders) {
			//循环遍历得到订单项的金额总和
			lineExample.createCriteria().andOddOrderIdEqualTo(new BigDecimal(order.getOdrId()));
			List<OrdersLine> line = lineMapper.selectByExample(lineExample);
			for (OrdersLine ordersLine : line) {
				sum+=ordersLine.getOddPrice();   //每一个订单项的金额
			}
			
		}
		
		return sum;	
	}
}