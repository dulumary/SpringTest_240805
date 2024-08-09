package com.marondal.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);

}
