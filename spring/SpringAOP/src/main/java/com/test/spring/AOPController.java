package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AOPController {
	
	@GetMapping("/test")
	public String test() {
		
		System.out.println("�־���: test");
		return "test";
	}
}
