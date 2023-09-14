package xyz.itwill.security;

import com.github.scribejava.core.builder.api.DefaultApi20;

//로그인 관련 API 정보를 제공하기 위한 클래스
// => DefaultApi20 클래스를 상속받아 작성
public class NaverLoginApi extends DefaultApi20 {
	protected NaverLoginApi() {
		
	}
	
	private static class InstanceHolder {
		private static final NaverLoginApi INSTANCE = new NaverLoginApi();		
	}
	
	public static NaverLoginApi instance() {
		return InstanceHolder.INSTANCE;
	}
	
	//사용자 접근 토큰을 제공받기 위한 API의 URL 주소를 반환하는 메소드
	@Override
	public String getAccessTokenEndpoint() {
		return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	}

	//로그인 처리를 위한 API의 URL 주소를 반환하는 메소드
	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://nid.naver.com/oauth2.0/authorize";
	}
	
}
