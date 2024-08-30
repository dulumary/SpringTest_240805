package com.marondal.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.spring.test.jpa.domain.Recruit;
import com.marondal.spring.test.jpa.repository.RecruitRepository;

@RestController // @Controller + @ResponseBody
@RequestMapping("/jpa/recruit/read")
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;

	@GetMapping("/1")
	public Recruit readRecruit1() {
		// id가 8인 공고 조회
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
		
	}
	
	@GetMapping("/2")
	public List<Recruit> readRecruit2(@RequestParam("companyId") int companyId) {
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		
		return recruitList;
	}
	
	@GetMapping("/3")
	public List<Recruit> readRecruit3() {
		
//		 return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
//		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
//		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8000);
		return recruitRepository.selectByNativeQuery("2026-04-10 00:00:00", 8100, "정규직");
	}
	

}
