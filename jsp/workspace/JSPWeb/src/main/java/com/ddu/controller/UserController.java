package com.ddu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddu.user.model.UserVO;
import com.ddu.user.service.UserService;
import com.ddu.user.service.UserServiceImpl;

//1. 확장자패턴으로 변경
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public UserController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	// 2. get/post 하나로 모은다
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();

		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);
		
		// MVC2에서는 화면을 띄우는 요청도 Controller를 거쳐 나가도록 처리
		// 기본이동이 전부 forward 형식으로 처리를 합니다.
		// 리다이렉트는 다시 컨트롤러를 태워 나가는 용도로 사용합니다.
		
		//필요한 객체를 if문 바깥에 선언
		
		UserService service = new UserServiceImpl();	
		//세션
		HttpSession session = request.getSession();
		
		if(command.equals("/user/user_join.user")) {
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
			
		}else if (command.equals("/user/user_login.user")) {
			
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		} else if (command.equals("/user/joinForm.user")) {
			
			//가입
					
			int result = service.join(request, response);
			
			if(result == 1) { // 중복
				request.setAttribute("msg", "중복된 아이디 입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			} else { //가입성공
				
				response.sendRedirect("user_login.user");
				
			}
			
		} else if(command.equals("/user/loginForm.user")) {
			
			UserVO vo = service.login(request, response);
			
			if(vo == null) { // 로그인 실패
				
				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
	
				
			}else { // 로그인 성공
				//세션에 회원정보 저장 (자바에서 세션얻는 방법)
				session = request.getSession();
				System.out.println("로그인성공");
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				response.sendRedirect("user_mypage.user");
			}
			
		} else if (command.equals("/user/user_mypage.user")) {
			
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
			
		// 로그아웃 - 인증수단을 삭제
		}else if (command.equals("/user/user_logout.user")) {
			
			session.invalidate();
			response.sendRedirect("../index.jsp");						
		
		// 정보 수정페이지
		}else if (command.equals("/user/user_modify.user")) {
			
//			if(session.getAttribute("user_id")==null) {
//				response.sendRedirect("user_login.user");
//				return;
//			}
			
			// 회원정보를 가지고 감
			UserVO vo = service.getInfo(request, response);
			
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("user_modify.jsp").forward(request, response);
		
		// 정보 수정
			//수정성공시에는 MAYPAGE로 리다이렉트 , 실패시에는 MYPAGE (MODIFY)로 리다이렉트
		}else if (command.equals("/user/user_update.user")) {
	
			int result = service.updateInfo(request,response);
			
			if(result == 0) { // 실패
				response.sendRedirect("user_modify.user");
				System.out.println("실패");
			}else { // 성공
				
				UserVO vo = service.login(request, response);
				session.setAttribute("vo", vo);
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('안녕하세요')");
				out.println("location.href = 'user_mypage.user';");
				out.println("</script>");
				
			}
			
		}else if (command.equals("/user/user_delete.user")) {
			
			int result = service.delete(request, response);
		
			if(result == 1) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('회원 탈퇴 성공')");
				out.println("location.href = '../index.jsp';");
				out.println("</script>");
				session.invalidate();
			}else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('회원 탈퇴 실패')");
				out.println("location.href = 'user_modify.user';");
				out.println("</script>");
			//	response.sendRedirect("user_modify.user");
			}
			
			
			
		}
		
		
		
		
		
	}
}
