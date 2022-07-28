package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Controller�� URL�� �����ϰ� Model�� ����� �����͸� �Ѱ��ִ� ���Ҹ� > Service���� ����Ͻ� ���� ����
@Controller
public class BoardController {
	
	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	// ��� ����
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	// ����
	@GetMapping(value="/write")
	public String write() {
		return "write";
	}
	
	@PostMapping(value="/writeok")
	public String writeok(HttpServletRequest req, Model model, String title) {
		
		int result = service.write(req, title);
		
		model.addAttribute("result", result);
		
		return "writeok";
	}
	
	
}
