package com.ddu.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.security.KeyStoreUtil;

import com.ddu.board.model.BoardDAO;
import com.ddu.board.model.BoardVO;

public class BoardServiceImpl implements BoardService{
	
	// 글 등록
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		//title , writer , content
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title, content);
		
	}

	
	// 글 목록 가져오기
	@Override
	public List<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.getList();
		
		
		return list;
	}


	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		
		String bno = request.getParameter("bno");
		BoardVO vo = dao.getContent(bno);
		
		return vo;
	}


	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		dao.update(bno, title, content);
		
	}


	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		String bno = request.getParameter("bno");
		dao.delete(bno);
		
	}

	

}
