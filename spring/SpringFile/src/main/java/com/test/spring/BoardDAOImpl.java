package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private SqlSessionTemplate template;
	
	@Autowired
	public BoardDAOImpl(SqlSessionTemplate template) {
		this.template = template; 
	}

	@Override
	public int add(String title) {
		return template.insert("file.add", title);
	}
	
	@Override
	public int getSeq() {
		return template.selectOne("file.getSeq");
	}
	
	@Override
	public void addFile(FileDTO fdto) {
		template.insert("file.addFile", fdto);
	}
	
	@Override
	public List<BoardDTO> list() {
		
		// 관습 > DAO의 메서드 1개는 1개의 SQL만 실행
		return template.selectList("file.list");
	}
	
	@Override
	public List<FileDTO> flist(String seq) {
		return template.selectList("file.flist", seq);
	}
	

}
