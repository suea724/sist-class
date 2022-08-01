package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

	private final SqlSessionTemplate template;

	@Override
	public int add(BoardDTO dto) {
		return template.insert("board.add", dto);
	}

	@Override
	public List<BoardDTO> list() {
		return template.selectList("board.list");
	}

	@Override
	public BoardDTO get(String seq) {
		return template.selectOne("board.get", seq);
	}
	
	
}
