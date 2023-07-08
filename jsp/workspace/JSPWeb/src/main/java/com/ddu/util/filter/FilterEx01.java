package com.ddu.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 1. Filter 클래스를 상속받습니다.
// 3. 어노테이션 방법 or web.xml 으로 걸러낼 요청선언
//@WebFilter("/*") // 모든 요청

public class FilterEx01 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("첫번째 필터 실행됨");
		
		//2. 다음 프로그램 코드로 연결 (필터 체인이 있다면 다음필터로 연결)
		chain.doFilter(request, response);
		
		
		
		
	}

}
