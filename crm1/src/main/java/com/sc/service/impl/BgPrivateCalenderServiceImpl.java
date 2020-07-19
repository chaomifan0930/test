package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.BgPrivateCalender;
import com.sc.entity.BgPrivateCalenderExample;
import com.sc.entity.BgPrivateCalenderExample.Criteria;
import com.sc.mapper.BgPrivateCalenderMapper;
import com.sc.service.BgPrivateCalenderService;

@Service
public class BgPrivateCalenderServiceImpl implements BgPrivateCalenderService {

	@Autowired
	BgPrivateCalenderMapper bgPrivateCalenderMapper;
	
	@Override
	public void addPrivateCalender(BgPrivateCalender pc) {
		bgPrivateCalenderMapper.insert(pc);

	}

	@Override
	public void updatePrivateCalender(BgPrivateCalender pc) {
		if(pc!=null&&pc.getCalendarId()!=null){
			bgPrivateCalenderMapper.updateByPrimaryKey(pc);
		}

	}

	@Override
	public void deletePrivateCalender(Long calendarId) {
		if(calendarId!=null){
			bgPrivateCalenderMapper.deleteByPrimaryKey(calendarId);
		}


	}

	@Override
	public BgPrivateCalender getPrivateCalender(Long calendarId) {
		if(calendarId!=null){
			return bgPrivateCalenderMapper.selectByPrimaryKey(calendarId);
		}
		return null;
	}

	@Override
	public PageInfo<BgPrivateCalender> selectPrivateCalender(Integer pageNum, Integer pageSize, BgPrivateCalender pc) {
		
		BgPrivateCalenderExample example=new BgPrivateCalenderExample();
		if(pc!=null){
			Criteria criteria = example.createCriteria();

			if(!StringUtils.isEmpty(pc.getCalendarTitle())){//�����ճ̰�������ģ����ѯ
				criteria.andCalendarTitleLike("%"+pc.getCalendarTitle()+"%");
			}
			if(!StringUtils.isEmpty(pc.getDatemin())){//����޸�ʱ����ڵ�����С����
				System.out.println("-------С----------:"+pc.getDatemin());
				criteria.andLastModifyDateGreaterThanOrEqualTo(pc.getDatemin());
			}
			if(!StringUtils.isEmpty(pc.getDatemax())){//����޸�ʱ��С�ڵ����������
				Date d=pc.getDatemax();
				d.setHours(23);
				d.setMinutes(59);
				d.setSeconds(59);
				System.out.println("-------��----------:"+d);
				criteria.andLastModifyDateLessThanOrEqualTo(d);
			}
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<BgPrivateCalender> list = bgPrivateCalenderMapper.selectByExample(example);
		PageInfo<BgPrivateCalender> page=new PageInfo<BgPrivateCalender>(list);
		return page;
	}

}
