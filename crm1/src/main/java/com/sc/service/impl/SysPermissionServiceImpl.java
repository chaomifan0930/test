package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.entity.SysPermission;
import com.sc.mapper.SysPermissionMapper;
import com.sc.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	SysPermissionMapper sysPermissionMapper;
	
	@Override
	public List<SysPermission> getPermissionByUsercode(String usercode) {
		
		return sysPermissionMapper.getPermissionByUsercode(usercode);
	}

	@Override
	public List<SysPermission> getAllPermissions() {
		
		return sysPermissionMapper.selectByExample(null);
	}

}
