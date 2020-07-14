package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.Goods;

public interface GoodsService {

	public List<Goods> selectGoods();
	
	public void addGoods(Goods g);
	
	public void updateGoods(Goods g);
	
	public void deleteGoods(Goods g);
	
	public Goods getGoods(Integer gid);
	
	public PageInfo<Goods> selectGoodsPage(int pageNum,int pageSize);
}
