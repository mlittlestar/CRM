package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstService;
import com.briup.crm.common.bean.CstServiceExample;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.CstServiceMapper;
import com.briup.crm.service.interfaces.ICstService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo; 

@Service
public class ICstServiceImpl implements ICstService{
	
	@Autowired
	private CstServiceMapper cstServiceMapper;

	@Override
	public void save(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SysUser> findAllManagerName() throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CstService> findCstServiceByCondition(CstService con, int curPage, int row)
			throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CstService> findServiceOnDealed(CstService con, int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CstService> findAllService(int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage,row);
		
		CstServiceExample example=new CstServiceExample();
		List<CstService> list = cstServiceMapper.selectByExample(example);
		PageInfo<CstService> pageInfo=new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public PageInfo<CstService> findByfp(int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CstService> findBycl(int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long svrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstServiceMapper.deleteByPrimaryKey(svrId);
	}

	@Override
	public void updateCstService(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public CstService queryOneByid(long svrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateinfo(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Dealresult(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}
	
	

}
