package com.briup.crm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstActivityExample;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstCustomerExample;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.bean.CstLinkmanExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.CstActivityMapper;
import com.briup.crm.dao.mapperInterface.CstCustomerMapper;
import com.briup.crm.dao.mapperInterface.CstLinkmanMapper;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CstCustomerMapper cstCustomerMapper;//客户映射
	@Autowired
	private CstLinkmanMapper cstLinkmanMapper;
	@Autowired
	private CstActivityMapper cstActivityMapper;

	@Override
	public List<CstCustomer> findAllCustomer() throws CrmCommonException {
		// TODO Auto-generated method stub
		//新建一个Example对象
		CstCustomerExample example=new CstCustomerExample();
		
		//限定条件
		
		
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public CstCustomer findCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		//return cstCustomerMapper.selectByPrimaryKey(id);
		
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustIdEqualTo(id);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		System.out.println(list);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public CstCustomer findCustomerByCstName(String cstName) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustNameEqualTo(cstName);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public Set<String> findAllCustomerLevelLable() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustLevelIsNotNull();
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		Set<String> set=new HashSet<>();
		for(CstCustomer cstCustomer:list){
			set.add(cstCustomer.getCustLevelLabel());
		}
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return set;
		
	}

	@Override
	public List<CstCustomer> findCstCustomerByLevelLable(String levelLable) throws CrmCommonException {
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustLevelLabelEqualTo(levelLable);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public Set<Integer> findAllCustomerCredit() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustCreditIsNotNull();
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		Set<Integer> set=new HashSet<>();
		for(CstCustomer cstCustomer:list){
			set.add((cstCustomer.getCustCredit()).intValue());
		}
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByCredit(int credit) throws CrmCommonException {
		// TODO Auto-generated method stub
		long temp=(long)credit;
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustCreditEqualTo(temp);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public Set<Integer> findAllCustomerSatisfy() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustSatisfyIsNotNull();
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		Set<Integer> set=new HashSet<>();
		for(CstCustomer cstCustomer:list){
			set.add((cstCustomer.getCustSatisfy()).intValue());
		}
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return set;
		
	}

	@Override
	public List<CstCustomer> findCstCustomerBySatisfy(int satisfy) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		Long Lsatisfy=(long)satisfy;  
		
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustSatisfyEqualTo(Lsatisfy);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		return list;
	}

	@Override
	public CstCustomer findCustomerByCstNo(String cstNo) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	@Override
	public void updateCustomer(CstCustomer cstCustomer) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustAddrIsNotNull();
		int key = cstCustomerMapper.updateByPrimaryKey(cstCustomer);
		
		
	}

	@Override
	public void saveLinkMan(CstLinkman cstLinkman) throws CrmCommonException {
		
		cstLinkmanMapper.insert(cstLinkman);
		
		
		
		
	}

	@Override
	public void deleteLinkMan(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageInfo<CstCustomer> findAllCstCustomer(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		//设置分页信息（传入当前页码，每一页有多少条数据）
		PageHelper.startPage(curpage,row);
		//需要找到需要分页数据的list
		List<CstCustomer> list = findAllCustomer();
		//返回一个查询页码后的对象
		PageInfo<CstCustomer> pageInfo=new PageInfo<CstCustomer>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<CstCustomer> findCustomerPageByCon(int curpage, int row, CstCustomer cstCustomer)
			throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		//拼接查询
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustNoLike("%"+cstCustomer.getCustNo()+"%").
		andCustManagerNameLike("%"+cstCustomer.getCustManagerName()+"%").
		andCustNameLike("%"+cstCustomer.getCustName()+"%").
		andCustLevelLabelLike("%"+cstCustomer.getCustLevelLabel()+"%").
		andCustRegionLike("%"+cstCustomer.getCustRegion()+"%");
		
		PageInfo<CstCustomer> pageInfo=new PageInfo<>(cstCustomerMapper.selectByExample(example));
		
		System.out.println("-------"+pageInfo);
		
		return pageInfo	;
	}

	@Override
	public List<CstLinkman> findAllLinkManByCstId(long cstId) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstLinkmanExample example=new CstLinkmanExample();
		example.createCriteria().andLkmCustIdEqualTo(cstId);
		List<CstLinkman> selectByExample = cstLinkmanMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public CstLinkman findLinkManById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstLinkmanExample example=new CstLinkmanExample();
		example.createCriteria().andLkmIdEqualTo(id);
		List<CstLinkman> list = cstLinkmanMapper.selectByExample(example);
		return list.get(0);
		
		
		/*CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustNameEqualTo(cstName);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);*/
	}

	@Override
	public void updateLinkman(CstLinkman lkm) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustIdEqualTo(id);
		int key = cstCustomerMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void saveCstActivity(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CstActivity> findAllCstActivityByCstNo(String cstNo) throws CrmCommonException {
		// TODO Auto-generated method stub
		long cstId=Long.parseLong(cstNo);
		CstActivityExample example=new CstActivityExample();
		example.createCriteria().andAtvCustIdEqualTo(cstId);
		List<CstActivity> list = cstActivityMapper.selectByExample(example);
		return list;
	}

	@Override
	public CstActivity findCstActivityById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAtv(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAtvById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCustomer(CstCustomer cst) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example=new CstCustomerExample();
		example.createCriteria().andCustAddrIsNotNull();
		cstCustomerMapper.insert(cst);
		
		
	}

}
