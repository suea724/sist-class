package com.test.spring;

import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {
	private String seq;
	private String title;
	private String regdate;
	private List<FileDTO> files; // 하나의 글이 가지는 파일 리스트
}
