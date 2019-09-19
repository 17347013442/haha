package com.yc.dao;

import java.util.List;

import com.yc.po.FavoritePO;

public interface FavoriteMapper {

	public FavoritePO findById(Integer fid);
	
	
	public List<FavoritePO> findByCondition(FavoritePO favoritePO);
	
	
}
