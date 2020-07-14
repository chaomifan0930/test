package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.Goods;
import com.sc.mapper.GoodsMapper;
import com.sc.service.GoodsService;

@Service //把该类注册成bean对象，放在容器管理
public class GoodsServiceImpl implements GoodsService {

	@Autowired //对象属性通过类型自动注入，spring自动找跟此对象的接口下的实现类对象，然后自动注入
	GoodsMapper goodsMapper;
	
	@Override
	public List<Goods> selectGoods() {		
		return this.goodsMapper.selectByExample(null);
	}

	@Override
	public void addGoods(Goods g) {
		if(g!=null){
		this.goodsMapper.insert(g);
		}
	}

	@Override
	public void updateGoods(Goods g) {
		this.goodsMapper.updateByPrimaryKey(g);

	}

	@Override
	public void deleteGoods(Goods g) {
		this.goodsMapper.deleteByPrimaryKey(g.getGid());

	}

	@Override
	public Goods getGoods(Integer gid) {
		return this.goodsMapper.selectByPrimaryKey(gid);
	}

	@Override
	public PageInfo<Goods> selectGoodsPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = this.goodsMapper.selectByExample(null);
		PageInfo<Goods> pafeInfo=new PageInfo<Goods>(list);
		return pafeInfo;
	}

}
