package com.marondal.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.mybatis.domain.RealEstate;
import com.marondal.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
	}

}
