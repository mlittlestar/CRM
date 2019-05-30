package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.common.bean.CstLogExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.CstLogMapper;
import com.briup.crm.service.interfaces.ILogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ILogServiceImpl implements ILogService{
	
	@Autowired
	private CstLogMapper cstLogMapper;

	@Override
	public void saveLog(CstLog log) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageInfo<CstLog> findAllLog(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		CstLogExample example=new CstLogExample();
		List<CstLog> list = cstLogMapper.selectByExample(example);
		PageInfo<CstLog> pageInfo=new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public List<CstLog> findAllLog() throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
