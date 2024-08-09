package com.marondal.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.database.domain.Store;
import com.marondal.spring.test.database.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		// 가게 정보 리스트를 json으로 response 담는다. 
		// 가게 정보 리스트 얻어 오기 
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
		
	}

}
