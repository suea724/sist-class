package com.test.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ������Ʈ ��ĵ�� base-package ���̹Ƿ� ������� ����!

@Controller
@RequestMapping("/test.do")
public class TestController {
	
	@RequestMapping
	public String test() {
		return "ex03";
	}
	
}
