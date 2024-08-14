package com.marondal.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mvc.domain.Seller;
import com.marondal.spring.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// 데이터 저장 과정을 진행할 페이지
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickName") String nickName
			, @RequestParam("temperature") double temperature
			, @RequestParam("profile") String profileImage) {
		
		int count = sellerService.addSeller(nickName, temperature, profileImage);
		
		// redirect : response에 특정 path(경로) 로 이동하라는 정보를 전달
		
		return "redirect:/mvc/seller/info";
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			,Model model) {
		
		Seller seller = null;
		// id가 전달이 안되면 최근 판매자 조회
		if(id == null) {
			seller = sellerService.getLastSeller();
		} else {
			// id가 전달이 되면 매치된 판매자 조회 
			seller = sellerService.getSeller(id);
		}
		
		model.addAttribute("seller", seller);
		
		return "mvc/sellerInfo";
	}

}
