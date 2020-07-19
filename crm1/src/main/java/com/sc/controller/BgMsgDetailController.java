package com.sc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.BgMsgDetail;
import com.sc.entity.Message;
import com.sc.service.BgMsgDetailService;

@Controller
@RequestMapping("/bgMsgDetailctrl")
public class BgMsgDetailController {

	@Autowired
	BgMsgDetailService bgMsgDetailService;
	
	//��ѯ
	@RequestMapping("/selectmdetail.do")
	public ModelAndView selectMsgDetail(ModelAndView mav,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize,
			BgMsgDetail mdetail){
		
		System.out.println("�����ѯ���������ҳ������:"+mdetail);
		/*System.out.println("-------С----------:"+mdetail.getDatemin());
		System.out.println("-------��----------:"+mdetail.getDatemax());*/
		
		//Ϊ��������ѯ��׼��
		PageInfo<BgMsgDetail> page = bgMsgDetailService.selectMsgDetail(pageNum, pageSize, mdetail);
		
		mav.addObject("p", page);
		mav.addObject("mdetail", mdetail);
		mav.setViewName("bg/bgmdetail-list"); //WEB-INF/bg/bgmdetail-list.jsp
		return mav;
	}
	

	@RequestMapping("/goaddmdetail.do")
	public ModelAndView goAddMsgDetail(ModelAndView mav,BgMsgDetail mdetail){
		System.out.println("�������ҳ��"+mdetail);
		//�޸�
		if(mdetail.getMsgDetailId()!=null){
			mdetail=bgMsgDetailService.getMsgDetail(mdetail.getMsgDetailId());
		}
		
		mav.setViewName("bg/bgmdetail-add"); //WEB-INF/bg/bgmdetail-add.jsp
		mav.addObject("mdetail", mdetail);
		return mav;
	}
	
	@RequestMapping("/addmdetail.do")
	@ResponseBody
	public Message addMsgDetail(ModelAndView mav,BgMsgDetail mdetail){
		System.out.println("������ӿ�������:"+mdetail);
		if(mdetail.getMsgDetailId()!=null){//�޸�
			bgMsgDetailService.updateMsgDetail(mdetail);
		}else{//���
			bgMsgDetailService.addMsgDetail(mdetail);
		}
		return new Message("1","success","�ɹ�");
	}
	
	@RequestMapping("/deletemdetail.do")
	@ResponseBody
	public Message deleteMsgDetail(ModelAndView mav,BgMsgDetail mdetail){
		System.out.println("����ɾ����������:"+mdetail);
		bgMsgDetailService.deleteMsgDetail(mdetail.getMsgDetailId());
		return new Message("1","success","�ɹ�");
	}
	
	@RequestMapping("/deletemdetailall.do")
	public String deleteMsgAll(ModelAndView mav,Long[] ids){
		System.out.println("��������ɾ����������:"+Arrays.toString(ids));
		if(ids!=null&&ids.length>0){
			for (Long id : ids) {
				bgMsgDetailService.deleteMsgDetail(id);
			}
		}
		//�ض��򵽲�ѯ����
		return "redirect:selectmdetail.do";
	}
}
