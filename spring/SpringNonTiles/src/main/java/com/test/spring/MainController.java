package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value="/member/info")
	public String info() {
		
		// ȸ�� > ���� ������
		
		return "member/info";
	}
	
	@GetMapping(value="/member/point")
	public String point() {
		
		// ȸ�� > ����Ʈ ������
		
		return "member/point";
	}
	
	@GetMapping(value="/admin/chart")
	public String chart() {
		
		// ������ > ��Ʈ ������
		
		return "admin/chart";
	}
	
	@GetMapping(value="/admin/preference")
	public String preference() {
		
		// ������ > ȯ�� ���� ������
		
		return "admin/preference";
	}
}
