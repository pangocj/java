package xyz.itwill.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

//로그인 성공 후에 실행될 기능을 제공하기 위한 클래스
// => 사용자의 마지막 로그인 날짜를 변경 처리 또는 로그인 실패 횟수 초기화 등의 기능 구현
// => AuthenticationSuccessHandler 인터페이스를 상속받아 작성하거나 AuthenticationSuccessHandler 
//인터페이스를 상속받은 클래스를 상속받아 작성
@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	//로그인 계정의 권한을 확인하여 특정 페이지를 무조건 요청되도록 설정
	//Authentication 객체 : 인증 및 인가(권한)와 관련된 정보를 저장한 객체
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//로그인 사용자의 권한의 저장하기 위한 List 객체 생성
		List<String> roleNames=new ArrayList<String>();
		
		//Authentication.getAuthorities() : 인증된 계정된 모든 권한(GrantedAuthority 객체)을 
		//List 객체로 반환하는 메소드
		//GrantedAuthority 객체 : 사용자에게 부여된 권한에 대한 정보를 저장한 객체
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			//GrantedAuthority.getAuthority() : GrantedAuthority 객체에 저장된 권한을 반환하는 메소드 
			roleNames.add(authority.getAuthority());
		}
		
		log.warn(roleNames.toString());
		
		//Collection<T>.contains(T obj) : Collection 객체에 저장된 요소의 존재 유무를 확인하여
		//Collection 객체에 요소가 없는 [false]를 반환하고 요소가 있는 경우 [true]를 반환하는 메소드
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect(request.getContextPath()+"/admin/page");
			return;
		}
		
		if(roleNames.contains("ROLE_MANAGER")) {
			response.sendRedirect(request.getContextPath()+"/manager/page");
			return;
		}
		
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect(request.getContextPath()+"/user/page");
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/guest/page");
	}

}












