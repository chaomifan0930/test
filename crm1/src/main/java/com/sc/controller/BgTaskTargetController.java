package com.sc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.BgTaskTarget;
import com.sc.entity.Message;
import com.sc.service.BgTaskTargetService;

@Controller
@RequestMapping("/bgTaskTargetctrl")
public class BgTaskTargetController {

	@Autowired
	BgTaskTargetService bgTaskTargetService;
	
	//��ѯ
	@RequestMapping("/selecttarget.do")
	public ModelAndView selectTaskTarget(ModelAndView mav,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize,
			BgTaskTarget target){
		
		System.out.println("�����ѯ���������ҳ������:"+target);
		/*System.out.println("-------С----------:"+task.getDatemin());
		System.out.println("-------��----------:"+task.getDatemax());*/
		
		//Ϊ��������ѯ��׼��
		PageInfo<BgTaskTarget> page = bgTaskTargetService.selectTaskTarget(pageNum, pageSize, target);
		
		mav.addObject("p", page);
		mav.addObject("target", target);
		mav.setViewName("bg/bgtarget-list"); //WEB-INF/bg/bgtarget-list.jsp
		return mav;
	}
	

	@RequestMapping("/goaddtarget.do")
	public ModelAndView goAddTaskTarget(ModelAndView mav,BgTaskTarget target){
		System.out.println("�������ҳ��"+target);
		//�޸�
		if(target.getTargetId()!=null){
			target=bgTaskTargetService.getTaskTarget(target.getTargetId());
		}
		
		mav.setViewName("bg/bgtarget-add"); //WEB-INF/bg/bgtarget-add.jsp
		mav.addObject("target", target);
		return mav;
	}
	
	@RequestMapping("/addtarget.do")
	@ResponseBody
	public Message addTaskTarget(ModelAndView mav,BgTaskTarget target){
		System.out.println("������ӿ�������:"+target);
		if(target.getTargetId()!=null){//�޸�
			bgTaskTargetService.updateTaskTarget(target);
		}else{//���
			bgTaskTargetService.addTaskTarget(target);
		}
		return new Message("1","success","�ɹ�");
	}
	
	@RequestMapping("/deletetarget.do")
	@ResponseBody
	public Message deleteTaskTarget(ModelAndView mav,BgTaskTarget target){
		System.out.println("����ɾ����������:"+target);
		bgTaskTargetService.deleteTaskTarget(target.getTargetId());
		return new Message("1","success","�ɹ�");
	}
	
	@RequestMapping("/deletetargetall.do")
	public String deleteTaskTargetAll(ModelAndView mav,Long[] ids){
		System.out.println("��������ɾ����������:"+Arrays.toString(ids));
		if(ids!=null&&ids.length>0){
			for (Long id : ids) {
				bgTaskTargetService.deleteTaskTarget(id);
			}
		}
		//�ض��򵽲�ѯ����
		return "redirect:selecttarget.do";
	}
}
