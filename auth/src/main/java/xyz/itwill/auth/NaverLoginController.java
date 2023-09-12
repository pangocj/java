package xyz.itwill.auth;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import xyz.itwill.security.NaverLoginBean;

//네이버의 로그인 OpenAPI를 사용하여 간편 로그인하는 방법
//1.네이버 개발자 센터에 OpenAPI 신청 기능을 사용하여 어플리케이션 등록
// => 어플리케이션 이름, 사용자 API, 서비스 환경(서비스 URL, 콜백 URL)등을 입력하여 등록
//2.내 어플리케이션에서 Client Id, Client Secret  확인
//3.네이버 로그인 이미지를 다운로드 받아 출력하고 서비스 URL로 링크 제공
//4.scribejava-apis 라이브러리와 json-simple 라이브러리 프로젝트에 빌드 처리
//5.로그인 관련 API를 요청하기 위한 클래스 작성 - NaverLoginApi 클래스와 NaverLoginBean 클래스
//6.요청 처리 메소드에서 로그인 관련 API를 요청하기 위한 클래스의 메소드를 호출하여 인증을 이용한 권한 처리

@Controller
@RequestMapping("/naver")
@RequiredArgsConstructor
public class NaverLoginController {
	private final NaverLoginBean naverLoginBean;
	
	@RequestMapping("/login")
	public String login(HttpSession session) throws UnsupportedEncodingException {
		String naverAuthUrl=naverLoginBean.getAuthorizationUrl(session);
		return "redirect:"+naverAuthUrl;
	}
}










