package com.sc.service;

import java.util.List;

import com.sc.entity.SysPermission;
import com.sc.entity.SysUser;

public interface SysPermissionService {
	
	public List<SysPermission> getPermissionByUsercode(String usercode);
	
	public List<SysPermission> getAllPermissions();
}
