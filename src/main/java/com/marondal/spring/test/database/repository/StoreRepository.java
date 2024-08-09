package com.marondal.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.marondal.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	// store테이블 모든행 조회 
	public List<Store> selectStoreList();

}
