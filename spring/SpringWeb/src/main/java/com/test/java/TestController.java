package com.test.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 컴포넌트 스캔의 base-package 밖이므로 실행되지 않음!

@Controller
@RequestMapping("/test.do")
public class TestController {
	
	@RequestMapping
	public String test() {
		return "ex03";
	}
	
}
