package xyz.itwill.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Spring Security : SpringMVC 프로그램의 인증과 인가 기능을 지원하는 보안 프레임워크

//인증(Authentication) : 로그인 사용자가 맞는지를 확인하는 절차
// => 인증을 정상적으로 수행하기 위해 사용자를 식별할 수 있는 정보 필요 - Credential  
//인가(Authorization - 권한) : 인증된 사용자가 요청된 자원에 접근 가능한가를 결정하는 절차
// => 인증 처리 후 실행 - 권한은 일반적으로 역활(Role) 형태로 부여

//Spring Security는 인증과 인가를 위해 Principal 객체를 아이디로 Credential 객체를 비밀번호로 
//사용하는 Credential 기반의 인증 방식 사용

//Spring Security를 SpringMVC 프로그램에 적용하여 제공받을 수 있는 기능
// => 다양한 형태(폼로그인 인증, 토큰 기반 인증, OAuth2 기반 인증, LDAP 인증)의 사용자 인증 기능 적용 
// => 프로그램 사용자의 역화(Role)에 따른 권한 레벨 적용
// => 프로그램에서 제공하는 자원에 대한 접근 제어
// => 데이타 암호화
// => SSL 적용
// => 일반적으로 알려진 웹보안 공격 차단

//Spring Security를 SpringMVC 프로그램에 적용하는 방법
//1.spring-security-web, spring-security-core, spring-security-config, spring-security-tablibs
//라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
// => 모든 라이브러리 버전을 동일하게 설정하면 Spring 프레임워크 관련 라이브러리의 버전을 고려 빌드 처리
//2.[web.xml] 파일에 Spring Security 기능을 제공하는 Filter 클래스를 Filter로 등록하고 Filter가
//실행되기 위한 URL 주소를 매핑 처리 

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/user/page", method = RequestMethod.GET)
	public String userPage() {
		return "user_page";
	}
	
	@RequestMapping(value = "/manager/page", method = RequestMethod.GET)
	public String managerPage() {
		return "manager_page";
	}
	
	@RequestMapping(value = "/admin/page", method = RequestMethod.GET)
	public String adminPage() {
		return "admin_page";
	}
}
