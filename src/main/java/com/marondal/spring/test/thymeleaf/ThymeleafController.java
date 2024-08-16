package com.marondal.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	
	@GetMapping("/thymeleaf/test01")
	public String test01() {
		return "thymeleaf/test01";
	}

}
