package com.sc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.BgMsg;
import com.sc.entity.Message;
import com.sc.service.BgMsgService;

@Controller
@RequestMapping("/bgMsgctrl")
public class BgMsgController {

	@Autowired
	BgMsgService bgMsgService;
	
	//��ѯ
		@RequestMapping("/selectmsg.do")
		public ModelAndView selectMsg(ModelAndView mav,
				@RequestParam(defaultValue="1") Integer pageNum,
				@RequestParam(defaultValue="10") Integer pageSize,
				BgMsg msg){
			
			System.out.println("�����ѯ����Ϣ��ҳ������"+msg);
			
			//Ϊ��������ѯ��׼��
			PageInfo<BgMsg> page = bgMsgService.selectMsg(pageNum, pageSize, msg);
			
			mav.addObject("p", page);
			mav.addObject("msg", msg);
			mav.setViewName("bg/bgmsg-list"); //WEB-INF/bg/bgmsg-list.jsp
			return mav;
		}
		

		@RequestMapping("/goaddmsg.do")
		public ModelAndView goAddMsg(ModelAndView mav,BgMsg msg){
			System.out.println("�������ҳ��"+msg);
			//�޸�
			if(msg.getMsgId()!=null){
				msg=bgMsgService.getMsg(msg.getMsgId());
			}
			
			mav.setViewName("bg/bgmsg-add"); //WEB-INF/bg/bgmsg-add.jsp
			mav.addObject("msg", msg);
			return mav;
		}
		
		@RequestMapping("/addmsg.do")
		@ResponseBody
		public Message addMsg(ModelAndView mav,BgMsg msg){
			System.out.println("������Ӷ���Ϣ:"+msg);
			if(msg.getMsgId()!=null){//�޸�
				bgMsgService.updateMsg(msg);
			}else{//���
				bgMsgService.addMsg(msg);
			}
			return new Message("1","success","�ɹ�");
		}
		
		@RequestMapping("/deletemsg.do")
		@ResponseBody
		public Message deleteMsg(ModelAndView mav,BgMsg msg){
			System.out.println("����ɾ������Ϣ:"+msg);
			bgMsgService.deleteMsg(msg.getMsgId());
			return new Message("1","success","�ɹ�");
		}
		
		@RequestMapping("/deletemsgall.do")
		public String deleteMsgAll(ModelAndView mav,Long[] ids){
			System.out.println("��������ɾ����������:"+Arrays.toString(ids));
			if(ids!=null&&ids.length>0){
				for (Long id : ids) {
					bgMsgService.deleteMsg(id);
				}
			}
			//�ض��򵽲�ѯ����
			return "redirect:selectmsg.do";
		}
}
