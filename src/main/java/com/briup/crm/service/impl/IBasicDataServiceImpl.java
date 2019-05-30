package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.bean.ProductExample;
import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.bean.StorageExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.ProductMapper;
import com.briup.crm.dao.mapperInterface.StorageMapper;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class IBasicDataServiceImpl implements IBasicDataService{
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private StorageMapper storageMapper;

	@Override
	public PageInfo<Product> findProduct(Product product, int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Product> findProductAll(int curPage, int row) throws CrmCommonException {
		PageHelper.startPage(curPage,row);
		
		ProductExample example=new ProductExample();
		List<Product> list = productMapper.selectByExample(example);
		
		PageInfo<Product> pageInfo=new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public PageInfo<Storage> findStorageAll(int curpage, int row) throws CrmCommonException {
		
		StorageExample example=new StorageExample();
		List<Storage> list = storageMapper.selectByExample(example);
		PageInfo<Storage> pageInfo=new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public PageInfo<Storage> findStorage(Storage storage, int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
