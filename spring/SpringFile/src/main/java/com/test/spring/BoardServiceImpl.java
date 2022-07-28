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
		
		// �Խ��� �۾���
		int result = dao.add(title);
		
		// ��� �� ���� ��ȣ
		int seq = dao.getSeq();
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;
		
		// 1��
//		MultipartFile file = multi.getFile("attachlist");
//		System.out.println(file.getOriginalFilename());
		
		List<MultipartFile> files = multi.getFiles("attachlist");
		String path = req.getRealPath("resources/files");
		
		System.out.println(path);
		
		// ������
//		for (MultipartFile file : files) {
//			System.out.println(file.getOriginalFilename());
//		}
		
		for (MultipartFile file : files) {
			
			String filename = getFileName(path, file.getOriginalFilename());
			
			File tempFile = new File(path + "\\" + filename);
			
			try {
				file.transferTo(tempFile); // ���� ������ �̸��� ��ġ�� �ʰ� ���ϴ� ��η� �ű�
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
	
	// ���� ������ ���ϸ��� �ߺ����� �ʰ� �����
	private String getFileName(String path, String filename) {
		
		int n = 1;
		
		int index = filename.lastIndexOf(".");
		
		String tempName = filename.substring(0, index);
		String tempExt = filename.substring(index);
		
		while (true) {
			
			File file = new File(path + "\\" + filename);
			
			if (file.exists()) {
				// ���ϸ� �̹� ���� > ���ϸ� ����
				filename = tempName + "_" + n + tempExt;
				n ++;
			} else {
				// ���ϸ� ���� X > ���ϸ� ��� ����
				return filename;
				
			}
		}
		
	}
	
	@Override
	public List<BoardDTO> list() {
		
		// �Խù� select
		List<BoardDTO> list = dao.list();
		
		// �Խù��� ÷������ select
		for (BoardDTO dto : list) {
			List<FileDTO> flist = dao.flist(dto.getSeq());
			dto.setFiles(flist); // �Խù��� ÷������ ����Ʈ setting
		}
		
		return list;
	}
	
	
}
