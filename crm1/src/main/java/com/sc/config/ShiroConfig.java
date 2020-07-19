package com.sc.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sc.realm.CustomRealmMD5;
import com.sc.service.SysPermissionService;

@Configuration //shiro������
public class ShiroConfig {

	@Autowired
	SysPermissionService sysPermissionService;
	
	@Bean
	public CustomRealmMD5 customRealmMD5(){
		CustomRealmMD5 realm=new CustomRealmMD5();
		HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(3);
		realm.setCredentialsMatcher(matcher);
		return realm;
	}
	
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
		manager.setRealm(this.customRealmMD5());
		return manager;
	}
	
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(){
		//���ʵ����֤�빦�ܣ���Ҫ�Ѹ����Ϊ�Զ���ı���֤��������
		FormAuthenticationFilter form=new FormAuthenticationFilter();
		form.setLoginUrl("/loginctrl/login.do");
		form.setUsernameParam("userName");
		form.setPasswordParam("userPass");
		
		ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(this.securityManager());
		shiroFilter.setLoginUrl("/login.jsp");
		shiroFilter.setSuccessUrl("/loginctrl/main.do");
		shiroFilter.setUnauthorizedUrl("/nopermission.jsp");
		
		LogoutFilter logout=new LogoutFilter();
		logout.setRedirectUrl("/login.jsp");
		
		Map<String, Filter> filters=new HashMap<String, Filter>();
		filters.put("authc", form);
		filters.put("logout", logout);
		shiroFilter.setFilters(filters);
		
		Map<String, String> map=new LinkedHashMap<String, String>();
		//anon:����������
		map.put("/css/**", "anon");
		map.put("/images/**", "anon");
		map.put("/js/**", "anon");
		map.put("/sql/**", "anon");
		map.put("/upload/**", "anon");
		
		map.put("/html/**", "anon");
		map.put("/lib/**", "anon");
		map.put("/static/**", "anon");
		map.put("/temp/**", "anon");
				
		map.put("/login.jsp", "anon");

		
		//logout:�˳���¼
		map.put("/logout.do", "logout");
		
		//��Ϊ��Ȩ�ޱ��ѯ����Ȩ�޲�����
/*		List<SysPermission> list = sysPermissionService.getAllPermissions();
		if(list!=null&&list.size()>0){
			System.out.println("����Ȩ�޲����ã�");
			for (SysPermission perm : list) {
				String url=perm.getUrl();
				String code=perm.getPercode();
				if(code!=null&&!code.equals("")&&url!=null&&!url.equals("")){
					System.out.println("------url:"+url+"------code:"+code);
					map.put(url, "perms["+code+"]");
				}
			}
		}*/
		
		//authc:����֤���ܷ���
		map.put("/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(map);
		
		return shiroFilter;
	}
}
