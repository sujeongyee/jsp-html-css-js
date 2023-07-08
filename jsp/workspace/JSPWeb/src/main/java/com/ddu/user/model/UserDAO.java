package com.ddu.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.jsp.el.ELParseException;



public class UserDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋습니다.

	//1. 나 자신의 객체를 스태틱으로 선언	
	private static UserDAO instance = new UserDAO();

	//2. 직접 생성하지 못하도록 생성자 제한
	private UserDAO(){		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//3.getter를 통해서 객체를 반환
	public static UserDAO getInstance() {
		return instance;
	}

	//데이터베이스 연결 주소
	//private String url = "jdbc:oracle:thin:localhost:1521/xe";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";
	//오라클 커넥터	

	/**
	 * @author 박수정 중복검사
	 * 
	 */

	//아이디 중복 검사

	public int idCheck(String id) {

		String sql = "SELECT * FROM USERS WHERE ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 1;
		try {

			//1. Connecter - 디비연결
			conn = DriverManager.getConnection(url,uid,upw);
			//2.Pstmt - sql을 실행하기 위한 클래스			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			//3.ResultSet 
			rs = pstmt.executeQuery(); // select문			
			if(rs.next()) {
				result= 1;
			}else { // 중복 x
				result =0;
			}		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이디중복검사 중에 오류가 발생했어요~");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}
		}
		return result;
	}

	// 가입 기능	

	public void join(UserVO vo) {

		String sql = "INSERT INTO USERS(ID,PW,NAME,EMAIL,GENDER) VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPw());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getEmail());
			pstmt.setString(5,vo.getGender());

			pstmt.executeUpdate(); //성공시 1, 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 도중 오류가 발생했습니다.");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// 로그인 기능

	public UserVO login(String id , String pw) {


		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo = null; // 로그인 실패면 null값이 반환
		try {
			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if(rs.next()) { // 로그인 가능

				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Timestamp regdate = rs.getTimestamp("regdate");

				vo = new UserVO(id2,null,name,email,gender,regdate);

			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 도중 오류가 발생했습니다!");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}
		}

		return vo;
	}

	// 회원정보 조회

	public UserVO getInfo(String id) {
		UserVO vo = null;

		String sql = "SELECT * FROM USERS WHERE ID = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {			
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");				
				vo = new UserVO(id2,null,name,email,gender,null);				
			}		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 조회 기능에서 오류가 발생했습니다.");
		} finally {
			try {				
				conn.close();
				pstmt.close();
				rs.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return vo;
	}


	// 회원정보 수정

	public int updateInfo (UserVO vo) {

		String sql = "UPDATE USERS SET PW = ? , NAME = ? , EMAIL = ? , GENDER = ?  WHERE ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;	
		int a = 0;


		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getId());


			a = pstmt.executeUpdate(); // 성공시 1

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 수정 과정에서 오류 발생!!!");
		} finally {
			try {
				conn.close();
				pstmt.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return a;
	}


	// 회원 삭제

	public int delete (String id) {

		int result = 0;
		String sql = "DELETE FROM USERS WHERE ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원삭제 도중 오류 발생!");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}

		return result;
	}

}
