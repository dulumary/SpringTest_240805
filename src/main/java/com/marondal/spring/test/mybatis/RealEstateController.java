package com.marondal.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mybatis.domain.RealEstate;
import com.marondal.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate/select")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
		
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
		
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaAndPrice(
			 @RequestParam("area") int area
			 , @RequestParam("price")int price) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
		
	}

}
