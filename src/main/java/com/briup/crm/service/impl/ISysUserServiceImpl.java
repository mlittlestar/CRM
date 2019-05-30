package com.briup.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysRoleExample;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.bean.SysUserExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mapperInterface.SysRoleMapper;
import com.briup.crm.dao.mapperInterface.SysUserMapper;
import com.briup.crm.service.interfaces.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Service
public class ISysUserServiceImpl implements ISysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;//用户的映射
	@Autowired
	private SysRoleMapper sysRoleMapper;//角色
	
	public SysUser login(String username, String password) throws CrmCommonException {
		// TODO Auto-generated method stub
		//判断账号密码是否为空
		if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
			//抛出异常
			CrmCommonException.getMessage(401);
		}
		//需要的是example对象
		SysUserExample userExample=new SysUserExample();
		userExample.createCriteria().andUsrNameEqualTo(username).andUsrPasswordEqualTo(password);
		//要根据example对象查询数据库
		List<SysUser> list=sysUserMapper.selectByExample(userExample);
		//判断list中是否有值
		if(list==null&&list.size()==0){
			//抛异常
			throw CrmCommonException.getException(402);
		}
		return list.get(0);
	}

	
	/**
	 * 查找所有的用户角色
	 * @return
	 * @throws CrmCommonException
	 */
	@Override
	public List<SysUser> findAllMgr() throws CrmCommonException {
		// TODO Auto-generated method stub
		SysUserExample userExample=new SysUserExample();
		
		
		return sysUserMapper.selectByExample(userExample);
	}


	@Override
	public List<SysRole> findAllRole() throws CrmCommonException {
		// TODO Auto-generated method stub
		SysRoleExample roleExample=new SysRoleExample();
		
		return sysRoleMapper.selectByExample(roleExample);
	}

//	根据角色编号查找角色
	@Override
	public SysRole findRoleBySysRoleId(long roleId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public void updateRole(SysRole role) throws CrmCommonException {
		// TODO Auto-generated method stub
		SysRoleExample roleExample=new SysRoleExample();
		sysRoleMapper.updateByExample(role, roleExample);
		
	}

	@Override
	public PageInfo<SysUser> findAllSysUser(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(curpage,row);
		SysUserExample example=new SysUserExample();
		List<SysUser> list = sysUserMapper.selectByExample(example);
		PageInfo<SysUser> pageInfo=new PageInfo<SysUser>(list);
		
		System.out.println(pageInfo);
		
		return pageInfo;
	}

	
	@Override
	public int getAllRows() throws CrmCommonException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser findOneUser(long usrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		return sysUserMapper.selectByPrimaryKey(usrId);
	}

	@Override
	public void updateUser(SysUser user) throws CrmCommonException {
		// TODO Auto-generated method stub
		SysUserExample userExample=new SysUserExample();
		sysUserMapper.updateByExample(user, userExample);
	}

	@Override
	public void addUser(SysUser user) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysUserMapper.insert(user);
	}

	@Override
	public void deleteUser(long usrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysUserMapper.deleteByPrimaryKey(usrId);
	}

	@Override
	public void addRole(SysRole role) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		sysRoleMapper.insert(role);
	}

	@Override
	public void deleteRole(long roleId) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysRoleMapper.deleteByPrimaryKey(roleId);
	}

}