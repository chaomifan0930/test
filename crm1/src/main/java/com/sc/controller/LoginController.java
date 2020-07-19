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

//�Ѹ���ע���bean���󣬲�����Ϊ���������
@Controller
//����������һ������ӳ���url��ַ
@RequestMapping("/loginctrl")
public class LoginController {

	//��¼��֤ʧ�ܵķ���
	@RequestMapping("/login.do")
	public ModelAndView login(ModelAndView mav,HttpServletRequest req){
		System.out.println("�û���¼��֤ʧ��");

		//ͨ����֤ʧ�ܵ��������ƻ�ȡ��Ӧ��ֵ
		String msg=(String)req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		System.out.println("��֤ʧ�ܵ���Ϣ��"+msg);
		
		String fail="";
		if(msg!=null){
			if(msg.equals(UnknownAccountException.class.getName())){
				fail="unknow";//�˻�������
			}else if(msg.equals(IncorrectCredentialsException.class.getName())){
				fail="error";//���벻��ȷ
			}else if(msg.equals("randomCodeError")){
				fail="code";//��֤�����
			}else{
				fail="other";//����δ֪����
			}
		}
		
		//�����¼ҳ��
		mav.setViewName("redirect:../login.jsp?isfail="+fail);

		return mav;
	}
	
	
		//��¼��֤�ɹ��ķ���
		@RequestMapping("/main.do")
		public ModelAndView main(ModelAndView mav,HttpSession session){
			System.out.println("�û���¼��֤�ɹ�");
			
			Subject subject = SecurityUtils.getSubject();
			SysUser sysUser=(SysUser)subject.getPrincipal();
			session.setAttribute("nowuser", sysUser);
			//�����¼ҳ��
			mav.setViewName("redirect:../main.jsp");

			return mav;
			
		}
		
}
