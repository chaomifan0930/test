package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.BgTaskTarget;
import com.sc.entity.BgTaskTargetExample;
import com.sc.entity.BgTaskTargetExample.Criteria;
import com.sc.mapper.BgTaskTargetMapper;
import com.sc.service.BgTaskTargetService;

@Service
public class BgTaskTargetServiceImpl implements BgTaskTargetService {

	@Autowired
	BgTaskTargetMapper bgTaskTargetMapper;
	
	@Override
	public void addTaskTarget(BgTaskTarget target) {
		bgTaskTargetMapper.insert(target);

	}

	@Override
	public void updateTaskTarget(BgTaskTarget target) {
		if(target!=null&&target.getTargetId()!=null){
			bgTaskTargetMapper.updateByPrimaryKey(target);
		}


	}

	@Override
	public void deleteTaskTarget(Long targetId) {
		if(targetId!=null){
			bgTaskTargetMapper.deleteByPrimaryKey(targetId);
		}

	}

	@Override
	public BgTaskTarget getTaskTarget(Long targetId) {
		if(targetId!=null){
			return bgTaskTargetMapper.selectByPrimaryKey(targetId);
		}
		return null;
	}

	@Override
	public PageInfo<BgTaskTarget> selectTaskTarget(Integer pageNum, Integer pageSize, BgTaskTarget target) {
		
		BgTaskTargetExample example=new BgTaskTargetExample();
		if(target!=null){
			Criteria criteria = example.createCriteria();
			
			if(!StringUtils.isEmpty(target.getTaskTarget())){//��������ָ��ģ����ѯ
					criteria.andTaskTargetLike("%"+target.getTaskTarget()+"%");
			}
			if(!StringUtils.isEmpty(target.getDatemin())){//����޸�ʱ����ڵ�����С����
				System.out.println("-------С----------:"+target.getDatemin());
				criteria.andLastModifyDateGreaterThanOrEqualTo(target.getDatemin());
			}
			if(!StringUtils.isEmpty(target.getDatemax())){//����޸�ʱ��С�ڵ����������
				Date d=target.getDatemax();
				d.setHours(23);
				d.setMinutes(59);
				d.setSeconds(59);
				System.out.println("-------��----------:"+d);
				criteria.andLastModifyDateLessThanOrEqualTo(d);
			}
		}
		PageHelper.startPage(pageNum, pageSize);
		List<BgTaskTarget> list = bgTaskTargetMapper.selectByExample(example);
		PageInfo<BgTaskTarget> page=new PageInfo<BgTaskTarget>(list);
		
		return page;
	}

}
