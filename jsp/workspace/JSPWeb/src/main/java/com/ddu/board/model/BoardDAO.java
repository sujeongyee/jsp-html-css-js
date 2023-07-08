package com.ddu.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO(){		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}


	public static BoardDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";
	
	// 글등록
	public void regist(String writer , String title , String content) {
		
		String sql = "INSERT INTO BOARD(BNO , WRITER , TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
			conn= DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,writer);
			pstmt.setString(2,title);
			pstmt.setString(3,content);
			System.out.println(writer+" "+title+" "+content);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 등록 과정에서 오류 발생");
		} finally {
			
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		
		
	}

	//목록을 조회	
	public List<BoardVO> getList() {
		
		List<BoardVO> list = new ArrayList<>();
		String sql = "SELECT * FROM BOARD ORDER BY BNO DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			while(rs.next()) {
	
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				
				BoardVO vo = new BoardVO(bno,writer,title,content,hit,regdate);
				
				list.add(vo); // list 추가
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
		return list;
	}

	// 글의 상세내용
	public BoardVO getContent(String bno) {
		BoardVO vo = null;
		
		String sql = "SELECT * FROM BOARD WHERE BNO = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bno2 = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new BoardVO(bno2,writer,title,content,hit,regdate);			
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 상세내용을 불러오는 도중 오류가 발생했습니다");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
		return vo;
	}
	
	// 글의 수정기능
	public void update(String bno , String title , String content) {
		
		String sql = "UPDATE BOARD SET TITLE = ? ,CONTENT = ? WHERE BNO = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글을 수정하는 기능에서 오류가 발생했습니다.");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	}
	
	// 글의 삭제기능
	
	public void delete(String bno) {
		
		String sql = "DELETE FROM BOARD WHERE BNO = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn= DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글을 삭제하는 도중 오류가 발생했습니다.");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	}
	
	
	
	
}
