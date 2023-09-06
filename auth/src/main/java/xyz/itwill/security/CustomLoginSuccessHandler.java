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

//로그인 성공 후에 실행될 기능을 제공하기 위한 클래스
// => AuthenticationSuccessHandler 인터페이스를 상속받아 작성
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//로그인 계정의 권한을 확인하여 특정 페이지를 무조건 요청되도록 설정
		List<String> roleNames=new ArrayList<String>();
		
		//Authentication 객체 : 인증 및 인가와 관련된 모든 정보를 저장하기 위한 객체
		//Authentication.getAuthorities() : 인증된 계정된 모든 권한을 List 객체로 반환하는 메소드
		//GrantedAuthority 객체 : 사용자에게 부여된 권한에 대한 정보를 저장한 객체
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			//GrantedAuthority.getAuthority() : GrantedAuthority 객체에 저장된 권한을 반환하는 메소드 
			roleNames.add(authority.getAuthority());
		}
		
		if(roleNames.contains("ROLE_ADMIN")) {
					
		}
		
		if(roleNames.contains("ROLE_MANAGER")) {
			
		}
		
		if(roleNames.contains("ROLE_USER")) {
			
		}
	}

}












