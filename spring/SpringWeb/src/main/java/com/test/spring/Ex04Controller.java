package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class Ex04Controller	 {
	
	@RequestMapping(value="/ex04.do")
	public String test() {
		return "ex04";
	}
	
	@RequestMapping(value="/ex04_1.do")
	public String test_1() {
		return "ex04";
	}
	
	@RequestMapping(value="/list.do")
	public String list() {
		return "list";
	}
	
	@RequestMapping(value="/add.do")
	public String add() {
		return "add";
	}
	
	@RequestMapping(value="/addok.do", method = RequestMethod.POST)
	public String addok() {
		return "addok";
	}
	
	@RequestMapping(value="/edit.do", method=RequestMethod.GET)
	public String edit() {
		return "edit";
	}
	
	@RequestMapping(value="/edit.do", method=RequestMethod.POST)
	public String editok() {
		return "editok";
	}
	
	@GetMapping("/del.do")
	public String del() {
		return "del";
	}
	
	@PostMapping("/delok.do")
	public String delok() {
		return "delok";
	}
	
}
