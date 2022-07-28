package com.test.spring;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao;
	
	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public int write(HttpServletRequest req, String title) {
		
		// 게시판 글쓰기
		int result = dao.add(title);
		
		// 방금 쓴 글의 번호
		int seq = dao.getSeq();
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;
		
		// 1개
//		MultipartFile file = multi.getFile("attachlist");
//		System.out.println(file.getOriginalFilename());
		
		List<MultipartFile> files = multi.getFiles("attachlist");
		String path = req.getRealPath("resources/files");
		
		System.out.println(path);
		
		// 여러개
//		for (MultipartFile file : files) {
//			System.out.println(file.getOriginalFilename());
//		}
		
		for (MultipartFile file : files) {
			
			String filename = getFileName(path, file.getOriginalFilename());
			
			File tempFile = new File(path + "\\" + filename);
			
			try {
				file.transferTo(tempFile); // 원본 파일의 이름을 겹치지 않게 원하는 경로로 옮김
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			FileDTO fdto = new FileDTO();
			
			fdto.setFilename(filename);
			fdto.setFilesize(String.valueOf(file.getSize()));
			fdto.setMimetype(file.getContentType());
			fdto.setBseq(String.valueOf(seq));
			
			dao.addFile(fdto);
		}
		return result;
	}
	
	// 저장 폴더의 파일명을 중복되지 않게 만들기
	private String getFileName(String path, String filename) {
		
		int n = 1;
		
		int index = filename.lastIndexOf(".");
		
		String tempName = filename.substring(0, index);
		String tempExt = filename.substring(index);
		
		while (true) {
			
			File file = new File(path + "\\" + filename);
			
			if (file.exists()) {
				// 파일명 이미 존재 > 파일명 변경
				filename = tempName + "_" + n + tempExt;
				n ++;
			} else {
				// 파일명 존재 X > 파일명 사용 가능
				return filename;
				
			}
		}
		
	}
	
	@Override
	public List<BoardDTO> list() {
		
		// 게시물 select
		List<BoardDTO> list = dao.list();
		
		// 게시물당 첨부파일 select
		for (BoardDTO dto : list) {
			List<FileDTO> flist = dao.flist(dto.getSeq());
			dto.setFiles(flist); // 게시물의 첨부파일 리스트 setting
		}
		
		return list;
	}
	
	
}
