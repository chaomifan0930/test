package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.entity.SysUser;
import com.sc.entity.SysUserExample;
import com.sc.entity.SysUserExample.Criteria;
import com.sc.mapper.SysUserMapper;
import com.sc.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;
	
	@Override
	public SysUser login(String usercode) {
		
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		//设置用户账号的条件
		criteria.andUsercodeEqualTo(usercode);
		
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);//查到该用户
		}
		
		return null;//未查到该用户
	}

}
