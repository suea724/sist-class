package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러 구현
// 1. Controller 인터페이스 구현
// 2. 어노테이션 사용

@Controller(value="/ex03.do")
public class Ex03Controller {
	
	// 요청 메서드 @RequestMapping
//	@RequestMapping
//	public String test() {
//		return "ex03";
//	}
	
	// 요청 메서드가 void일 경우 주소와 동일한 이름의 JSP를 자동으로 찾아준다. > 자주 사용하지 않음(세밀한 제어 불가)
	@RequestMapping
	public void test() {
		System.out.println("test");
	}
}
