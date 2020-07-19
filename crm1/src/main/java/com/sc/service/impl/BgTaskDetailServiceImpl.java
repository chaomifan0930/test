package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.BgTaskDetail;
import com.sc.entity.BgTaskDetailExample;
import com.sc.entity.BgTaskDetailExample.Criteria;
import com.sc.mapper.BgTaskDetailMapper;
import com.sc.service.BgTaskDetailService;

@Service
public class BgTaskDetailServiceImpl implements BgTaskDetailService {

	@Autowired
	BgTaskDetailMapper bgTaskDetailMapper;
	@Override
	public void addTaskDetail(BgTaskDetail tdetail) {
		bgTaskDetailMapper.insert(tdetail);

	}

	@Override
	public void updateTaskDetail(BgTaskDetail tdetail) {
		if(tdetail!=null&&tdetail.getId()!=null){
			bgTaskDetailMapper.updateByPrimaryKey(tdetail);
		}

	}

	@Override
	public void deleteTaskDetail(Long id) {
		if(id!=null){
			bgTaskDetailMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public BgTaskDetail getTaskDetail(Long id) {
		if(id!=null){
			return bgTaskDetailMapper.selectByPrimaryKey(id);
		}
		return null;
	}

	@Override
	public PageInfo<BgTaskDetail> selectTaskDetail(Integer pageNum, Integer pageSize, BgTaskDetail tdetail) {
		
		BgTaskDetailExample example=new BgTaskDetailExample();
		if(tdetail!=null){
			Criteria criteria = example.createCriteria();

			if(!StringUtils.isEmpty(tdetail.getState())){//��������״̬ģ����ѯ
				criteria.andStateLike("%"+tdetail.getState()+"%");
			}
			if(!StringUtils.isEmpty(tdetail.getDatemin())){//����޸�ʱ����ڵ�����С����
				System.out.println("-------С----------:"+tdetail.getDatemin());
				criteria.andLastModifyDateGreaterThanOrEqualTo(tdetail.getDatemin());
			}
			if(!StringUtils.isEmpty(tdetail.getDatemax())){//����޸�ʱ��С�ڵ����������
				Date d=tdetail.getDatemax();
				d.setHours(23);
				d.setMinutes(59);
				d.setSeconds(59);
				System.out.println("-------��----------:"+d);
				criteria.andLastModifyDateLessThanOrEqualTo(d);
			}
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<BgTaskDetail> list = bgTaskDetailMapper.selectByExample(example);
		PageInfo<BgTaskDetail> page=new PageInfo<BgTaskDetail>(list);
		
		return page;
	}

}
