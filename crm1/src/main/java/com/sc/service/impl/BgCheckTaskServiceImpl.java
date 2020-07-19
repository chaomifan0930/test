package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.BgCheckTask;
import com.sc.entity.BgCheckTaskExample;
import com.sc.entity.BgCheckTaskExample.Criteria;
import com.sc.mapper.BgCheckTaskMapper;
import com.sc.service.BgCheckTaskService;

@Service
public class BgCheckTaskServiceImpl implements BgCheckTaskService {

	@Autowired
	BgCheckTaskMapper bgCheckTaskMapper;
	
	@Override
	public void addTask(BgCheckTask task) {
		bgCheckTaskMapper.insert(task);

	}

	@Override
	public void updateTask(BgCheckTask task) {
		if(task!=null&&task.getTaskId()!=null){
			bgCheckTaskMapper.updateByPrimaryKey(task);
		}

	}

	@Override
	public void deleteTask(Long taskId) {
		if(taskId!=null){
			bgCheckTaskMapper.deleteByPrimaryKey(taskId);
		}

	}

	@Override
	public BgCheckTask getTask(Long taskId) {
		if(taskId!=null){
			return bgCheckTaskMapper.selectByPrimaryKey(taskId);
		}
		return null;
	}

	@Override
	public PageInfo<BgCheckTask> selectTask(Integer pageNum, Integer pageSize, BgCheckTask task) {
		
		BgCheckTaskExample example=new BgCheckTaskExample();
		if(task!=null){
			Criteria criteria = example.createCriteria();
			//if(task.getTaskTitle()!=null&&!task.getTaskDetail().equals(""))
			if(!StringUtils.isEmpty(task.getTaskTitle())){//�����������ģ����ѯ
				criteria.andTaskTitleLike("%"+task.getTaskTitle()+"%");
			}
			if(!StringUtils.isEmpty(task.getDatemin())){//����޸�ʱ����ڵ�����С����
				System.out.println("-------С----------:"+task.getDatemin());
				criteria.andLastModifyDateGreaterThanOrEqualTo(task.getDatemin());
			}
			if(!StringUtils.isEmpty(task.getDatemax())){//����޸�ʱ��С�ڵ����������
				Date d=task.getDatemax();
				d.setHours(23);
				d.setMinutes(59);
				d.setSeconds(59);
				System.out.println("-------��----------:"+d);
				criteria.andLastModifyDateLessThanOrEqualTo(d);
			}
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<BgCheckTask> list = bgCheckTaskMapper.selectByExample(example);
		PageInfo<BgCheckTask> page=new PageInfo<BgCheckTask>(list);
		
		return page;
	}

}
