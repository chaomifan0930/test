package com.sc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SysUser;

//把该类注册成bean对象，并且作为控制器组件
@Controller
//给该类配置一个请求映射的url地址
@RequestMapping("/loginctrl")
public class LoginController {

	//登录认证失败的方法
	@RequestMapping("/login.do")
	public ModelAndView login(ModelAndView mav,HttpServletRequest req){
		System.out.println("用户登录认证失败");

		//通过认证失败的属性名称获取对应的值
		String msg=(String)req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		System.out.println("认证失败的消息："+msg);
		
		String fail="";
		if(msg!=null){
			if(msg.equals(UnknownAccountException.class.getName())){
				fail="unknow";//账户不存在
			}else if(msg.equals(IncorrectCredentialsException.class.getName())){
				fail="error";//密码不正确
			}else if(msg.equals("randomCodeError")){
				fail="code";//验证码错误
			}else{
				fail="other";//其他未知错误
			}
		}
		
		//进入登录页面
		mav.setViewName("redirect:../login.jsp?isfail="+fail);

		return mav;
	}
	
	
		//登录认证成功的方法
		@RequestMapping("/main.do")
		public ModelAndView main(ModelAndView mav,HttpSession session){
			System.out.println("用户登录认证成功");
			
			Subject subject = SecurityUtils.getSubject();
			SysUser sysUser=(SysUser)subject.getPrincipal();
			session.setAttribute("nowuser", sysUser);
			//进入登录页面
			mav.setViewName("redirect:../main.jsp");

			return mav;
			
		}
		
}
