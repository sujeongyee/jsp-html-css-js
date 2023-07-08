package com.ddu.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//세션검사를 하기위한 필터
@WebFilter(urlPatterns = {"/user/user_mypage.user",
						  "/user/user_modify.user",
						  "/user/user_update.user",
						  "/user/user_delete.user",
						  "/board/board_write.board",
						  "/board/registForm.board",
						  "/board/board_modify.board",
						  "/board/board_delete.board"
						  })
public class UserAuthFilter implements Filter {
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//ServletRequest는 HttpServletRequest 의 부모타입 입니다.
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		
		//세션을 얻음
		HttpSession session=req.getSession();
		//회원이 로그인 할 때 저장한 인증값
		String user_id=(String)session.getAttribute("user_id");
		
		// 로그인이 안됨
		if(user_id==null) {
			//절대경로
			String path = req.getContextPath() +"/user/user_login.user";
			// res.sendRedirect(path);
			res.setContentType("text/html; charset = UTF-8;");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다');");
			out.println("location.href = '"+path+"';");
			out.println("</script>");
			
			return; // 필터 종료
		}
		
		// 다음 코드를 실행함 or 필터를 실행함d
		chain.doFilter(request, response);
	}

	

}
