package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value="/member/info")
	public String info() {
		
		// ȸ�� > ���� ������
		
		// return "member.info";
		return "one.member.info";
	}
	
	@GetMapping(value="/member/point")
	public String point() {
		
		// ȸ�� > ����Ʈ ������
		
		// return "member.point";
		return "two.member.point";
	}
	
	@GetMapping(value="/admin/chart")
	public String chart() {
		
		// ������ > ��Ʈ ������
		
		// return "admin.chart";
		return "three.admin.chart";
	}
	
	@GetMapping(value="/admin/preference")
	public String preference() {
		
		// ������ > ȯ�� ���� ������
		
		return "admin.preference";
	}
	
	@GetMapping(value="/test")
	public String test() {
		
		// Tiles ViewResolver
		// - tiles.xml���� ������ definition�� �̸����� ã�� (jsp ���� X)
		return "test";
	}
}
