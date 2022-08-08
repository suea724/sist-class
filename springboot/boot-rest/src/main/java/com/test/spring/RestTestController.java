package com.test.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class RestTestController {

	@GetMapping("/fruit")
	@ResponseBody
	public List<String> list() {
		
		List<String> list = Arrays.asList("사과", "딸기", "바나나");
		
		return list;		
	}
	
}










