package com.sc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.BgCheckTask;
import com.sc.entity.Message;
import com.sc.service.BgCheckTaskService;

@Controller
@RequestMapping("/bgCheckTaskctrl")
public class BgCheckTaskController {

	@Autowired
	BgCheckTaskService bgCheckTaskService;
	
	//��ѯ
	@RequestMapping("/selecttask.do")
	public ModelAndView selectTask(ModelAndView mav,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize,
			BgCheckTask task){
		
		System.out.println("�����ѯ���������ҳ������:"+task);
/*		System.out.println("-------С----------:"+task.getDatemin());
		System.out.println("-------��----------:"+task.getDatemax());*/
		
		//Ϊ��������ѯ��׼��
		PageInfo<BgCheckTask> page = bgCheckTaskService.selectTask(pageNum, pageSize, task);
		
		mav.addObject("p", page);
		mav.addObject("task", task);
		mav.setViewName("bg/bgchecktask-list"); //WEB-INF/bg/bgchecktask-list.jsp
		return mav;
	}
	

	@RequestMapping("/goaddtask.do")
	public ModelAndView goAddTask(ModelAndView mav,BgCheckTask task){
		System.out.println("�������ҳ��"+task);
		//�޸�
		if(task.getTaskId()!=null){
			task=bgCheckTaskService.getTask(task.getTaskId());
		}
		
		mav.setViewName("bg/bgchecktask-add"); //WEB-INF/bg/bgchecktask-add.jsp
		mav.addObject("task", task);
		return mav;
	}
	
	@RequestMapping("/addtask.do")
	@ResponseBody
	public Message addTask(ModelAndView mav,BgCheckTask task){
		System.out.println("������ӿ�������:"+task);
		if(task.getTaskId()!=null){//�޸�
			bgCheckTaskService.updateTask(task);
		}else{//���
			bgCheckTaskService.addTask(task);
		}
		return new Message("1","success","�ɹ�");
	}
	
	@RequestMapping("/deletetask.do")
	@ResponseBody
	public Message deleteTask(ModelAndView mav,BgCheckTask task){
		System.out.println("����ɾ����������:"+task);
		bgCheckTaskService.deleteTask(task.getTaskId());
		return new Message("1","success","�ɹ�");
	}
	
	@RequestMapping("/deletetaskall.do")
	public String deleteTaskAll(ModelAndView mav,Long[] ids){
		System.out.println("��������ɾ����������:"+Arrays.toString(ids));
		if(ids!=null&&ids.length>0){
			for (Long id : ids) {
				bgCheckTaskService.deleteTask(id);
			}
		}
		//�ض��򵽲�ѯ����
		return "redirect:selecttask.do";
	}
}
