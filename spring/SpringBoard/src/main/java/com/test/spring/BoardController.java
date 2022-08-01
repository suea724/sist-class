package com.test.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
//	@GetMapping(value="/test")
//	public String test() {
//		return "test";
//	}
	
	@GetMapping(value="/login")
	public String login(HttpSession session, String id, HttpServletRequest request) {
		
		session.setAttribute("auth", id);
		return "redirect:/list";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		
		session.removeAttribute("auth");
		return "redirect:/list";
	}
	
	@GetMapping(value="/add")
	public String add(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		return "add";
	}
	
	@PostMapping(value="/addok")
	public void addok(HttpSession session, HttpServletResponse response, BoardDTO dto, HttpServletRequest request) throws IOException {
		
		dto.setId((String) session.getAttribute("auth"));
		
		int result = boardService.add(dto);
		
		if (result == 1) {
			response.sendRedirect("/spring/list");
		} else {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('failed');");
			writer.println("location.href='/spring/add';");
			writer.println("</script>");
			writer.close();
		}
	}
	
	@GetMapping(value="/list")
	public String list(Model model, HttpServletRequest request, HttpSession session) {
		
		List<BoardDTO> list = boardService.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value="/view")
	public String view(HttpSession session, HttpServletResponse response, Model model, String seq, HttpServletRequest request) {
		
		BoardDTO dto = boardService.get(seq);
		
		model.addAttribute("dto", dto);
		return "view";
	}
	
	
}
