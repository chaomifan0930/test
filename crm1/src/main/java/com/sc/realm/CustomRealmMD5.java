package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
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
import com.sc.service.SysPermissionService;
import com.sc.service.SysUserService;

public class CustomRealmMD5 extends AuthorizingRealm{
	
	@Autowired
	SysUserService sysUserService;

	
	//�û���Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		SysUser sysUser=(SysUser)arg0.getPrimaryPrincipal();
		System.out.println("��ǰ��Ҫ����֤���û��ǣ�"+sysUser.getUsercode());
		
		
		//1.�����ݿ��ѯ���û�����ЩȨ��
		List<String> list=new ArrayList<String>();
		
		List<SysPermission> perms = sysPermissionService.getPermissionByUsercode(sysUser.getUsercode());
		if(perms!=null&&perms.size()>0){
			System.out.println("���û�ӵ�е�Ȩ�ޣ�");
			for (SysPermission perm : perms) {
				String code=perm.getPercode();
				if(code!=null&&!code.equals("")){
					System.out.println("------------"+code);
					list.add(code);//��Ȩ����Դ������ӵ�list����
				}
			}
		}
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(list);
		return info;
	}

	//�û���֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {		
		
		String username=(String)token.getPrincipal();
		System.out.println("��ǰ��Ҫ����֤���û��ǣ�"+username);		
		
		//1.�����ݿ��ѯ�Ƿ��и��û�
		SysUser sysUser = sysUserService.login(username);
		
		if(sysUser==null){
			System.out.println("�û������ڣ�");
			return null;//�����ڴ��û�
		}
		
		//2.�����ݿ��ѯ���û������룬���жԱ�
		String password=sysUser.getPassword();
		String salt=sysUser.getSalt();//��
		
		//ƥ������
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(sysUser, password, ByteSource.Util.bytes(salt), super.getName());
		
		return info;
	}
	
}
