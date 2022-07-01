package com.test.toy.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 인코딩
		 * 2. 데이터 가져오기 (subject, content, seq)
		 * 3. DB 작업 > DAO 위임
		 * 4. 결과 JSP에 반환
		 */
		
		HttpSession session = req.getSession();
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 1.5 새로운 파일을 선택했을 때
		String path = req.getRealPath("/files");
		int size = 1024 * 1024 * 100;
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest( req,
											path,
											size,
											"UTF-8",
											new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2.
		String seq = multi.getParameter("seq");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		
		String isSearch = multi.getParameter("isSearch");
		String column = multi.getParameter("column");
		String word = multi.getParameter("word");
		
		// 3.
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setSeq(seq);
		
		BoardDAO dao = new BoardDAO();
		
		// 3.5 첨부파일 처리
		// 3.5.1 기존 파일 O > 새로운 파일로 교체
		
		// 새파일
		String filename = multi.getFilesystemName("attach");
		String orgfilename = multi.getOriginalFileName("attach");
		
		System.out.println("filename: " + (filename == null));
		
		// 기존파일
		BoardDTO tempdto = dao.get(seq);
		
		if (tempdto.getFilename() != null && filename != null) {
			
			// 기존 파일 삭제
			File file = new File(path + "\\" + tempdto.getFilename());
			file.delete();
			
			dto.setFilename(filename);
			dto.setOrgfilename(orgfilename);
			
		} else if (filename == null && multi.getParameter("delfile").equals("y")) {
			
			// 기존 파일만 삭제하고 새로운 파일을 추가하지 않았을 경우
			File file = new File(path + "\\" + tempdto.getFilename());
			file.delete();
			
		} else if (filename == null) {
			
			// 기존 파일의 유무와 상관없이 새로운 파일을 추가하지 않았을 경우
			dto.setFilename(tempdto.getFilename());
			dto.setOrgfilename(tempdto.getOrgfilename());
			
		} else if (tempdto.getFilename() == null && filename != null) {
			
			// 기존 파일이 없을 때 새로운 파일을 추가하는 경우
			dto.setFilename(filename);
			dto.setOrgfilename(orgfilename);
			
		} 
		
		int temp = 0;
		
		if (session.getAttribute("auth") == null) {
			temp = 1; // 익명 사용자
		} else {
			if (session.getAttribute("auth").equals(dao.get(seq).getId())) {
				temp = 2; // 글쓴이 > 수정 권한 O
			} else {
				
				if (session.getAttribute("auth").toString().equals("admin")) {
					temp = 3; // 관리자 > 수정 권한 O
				} else {
					temp = 4; // 타인
				}
			}
		}
		
		
		int result = 0;
		
		if (temp == 2 || temp == 3) {
			result = dao.edit(dto);
		}
		
		// 4.
		req.setAttribute("result", result);
		req.setAttribute("seq", seq); // 되돌아가기 위해 필요한 seq
		
		req.setAttribute("isSearch", isSearch);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/editok.jsp");
		dispatcher.forward(req, resp);
	}

}