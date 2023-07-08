package com.ddu.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddu.board.model.BoardVO;

public interface BoardService {
	
	// 글 등록 기능
	
	void regist(HttpServletRequest request , HttpServletResponse response);
	
	// 글 목록 기능
	List<BoardVO> getList(HttpServletRequest request , HttpServletResponse response);
	
	//상세내역
	BoardVO getContent(HttpServletRequest request , HttpServletResponse response);
	
	//업데이트 (글 수정)
	void update(HttpServletRequest request , HttpServletResponse response);
	
	// 글 삭제
	void delete(HttpServletRequest request , HttpServletResponse response);
	
	// 조회수 증가
	
	
	/*
	 * 1. github사용
	 * 2. 작은프로세스 - 대여프로세스
	 * 3. 누구는 ppt, 누구는 프로그램 x (협업)
	 *  => 1개의 작은 기능을 스스로 
	 * 4. ui는 신경쓰지마세요. 흰바탕 ㅇㅋㅇㅋ
	 * 5. 주제선정 -> 디비설계 -> 유아이 -> 프로그램
	 * 6. 수요일 4시반 , 월요일 오전에는 수업
	 */
	
	
	
	

}
