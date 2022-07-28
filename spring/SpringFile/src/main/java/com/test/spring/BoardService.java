package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	
	public int write(HttpServletRequest req, String title);

	public List<BoardDTO> list();
}
