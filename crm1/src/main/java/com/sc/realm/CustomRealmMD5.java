package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.entity.SysPermission;
import com.sc.entity.SysUser;
import com.sc.service.SysUserService;

public class CustomRealmMD5 extends AuthorizingRealm{
	
	@Autowired
	SysUserService sysUserService;

	
	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		SysUser sysUser=(SysUser)arg0.getPrimaryPrincipal();
		System.out.println("当前需要被认证的用户是："+sysUser.getUsercode());
		
		
		//1.从数据库查询该用户有哪些权限
		List<String> list=new ArrayList<String>();
		
		List<SysPermission> perms = sysPermissionService.getPermissionByUsercode(sysUser.getUsercode());
		if(perms!=null&&perms.size()>0){
			System.out.println("该用户拥有的权限：");
			for (SysPermission perm : perms) {
				String code=perm.getPercode();
				if(code!=null&&!code.equals("")){
					System.out.println("------------"+code);
					list.add(code);//把权限资源名称添加到list集合
				}
			}
		}
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(list);
		return info;
	}

	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {		
		
		String username=(String)token.getPrincipal();
		System.out.println("当前需要被认证的用户是："+username);		
		
		//1.从数据库查询是否有该用户
		SysUser sysUser = sysUserService.login(username);
		
		if(sysUser==null){
			System.out.println("用户不存在！");
			return null;//不存在此用户
		}
		
		//2.从数据库查询该用户的密码，进行对比
		String password=sysUser.getPassword();
		String salt=sysUser.getSalt();//盐
		
		//匹配密码
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(sysUser, password, ByteSource.Util.bytes(salt), super.getName());
		
		return info;
	}
	
}
