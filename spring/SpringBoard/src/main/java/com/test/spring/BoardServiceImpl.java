package com.test.spring;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardDAO boardDAO;

	@Override
	public int add(BoardDTO dto) {
		
		return boardDAO.add(dto);
	}

	@Override
	public List<BoardDTO> list() {
		return boardDAO.list();
	}

	@Override
	public BoardDTO get(String seq) {
		return boardDAO.get(seq);
	}

}
