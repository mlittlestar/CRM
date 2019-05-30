package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalChanceExample;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.bean.SalPlanExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.SalChanceMapper;
import com.briup.crm.dao.mapperInterface.SalPlanMapper;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ISalChanceServiceImpl implements ISalChanceService{
	
	@Autowired
	private SalChanceMapper salChanceMapper;
	
	@Autowired 
	private SalPlanMapper salPlanMapper;

	@Override
	public void saveChance(SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalChanceExample example=new SalChanceExample();
		example.createCriteria().andChcAddrIsNotNull();
		int insert = salChanceMapper.insert(sc);
		
	}

	@Override
	public PageInfo<SalChance> findSalChanceByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage,row);
		
		SalChanceExample example = new SalChanceExample();
		List<SalChance>  list= salChanceMapper.selectByExample(example);
		
		PageInfo<SalChance> pageInfo=new PageInfo<>(list);
		
		
		return pageInfo;
	}

	@Override
	public List<SalPlan> findAllSalPlan() throws CrmCommonException {
		// TODO Auto-generated method stub
		
		SalPlanExample example=new SalPlanExample();
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		
		System.out.println(list);
		
		return list;
	}

	@Override
	public List<SalPlan> findSalPlans(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalPlanExample example=new SalPlanExample();
		example.createCriteria().andPlaChcIdEqualTo(chcId);
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		System.out.println(list);
		return list;
	}

	@Override
	public PageInfo<SalPlan> findSalPlanByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateChance(SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		int primaryKey = salChanceMapper.updateByPrimaryKey(sc);
	}

	@Override
	public SalChance findOneSalChance(long chcId) throws CrmCommonException {
		
		SalChanceExample example=new SalChanceExample();
		example.createCriteria().andChcIdEqualTo(chcId);
		List<SalChance> list = salChanceMapper.selectByExample(example);
		
		return list.get(0);
	}

	@Override
	public SalPlan findSalPlan(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSalChance(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalChanceExample example=new SalChanceExample();
		example.createCriteria().andChcIdEqualTo(chcId);
		salChanceMapper.deleteByPrimaryKey(chcId);
		
	}

	@Override
	public void savePlan(SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSalPlan(long plaId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalPlan(SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageInfo<SalChance> findSalPageByCon(int curpage, int row, SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
