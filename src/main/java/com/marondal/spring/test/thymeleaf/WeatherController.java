package com.marondal.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController {
	
	@GetMapping("/list")
	public String weatherhistory() {
		return "thymeleaf/weather/list";
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "thymeleaf/weather/input";
		
	}

}
