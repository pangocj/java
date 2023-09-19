package xyz.itwill.security;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

@Component
public class KakaoLoginBean {
	private final static String KAKAO_CLIENT_ID = "a1e137c4ce63297024703185095509d4";
    private final static String KAKAO_CLIENT_SECRET = "zh5r3lKn4GciSzG0L7CGuYFY5y1gvyHx";
    private final static String KAKAO_REDIRECT_URI = "http://localhost:8000/auth/kakao/callback";
    private final static String SESSION_STATE = "kakao_oauth_state";
    /* 프로필 조회 API URL */
    private final static String PROFILE_API_URL ="https://kapi.kakao.com/v2/user/me";


    /* 네아로 인증  URL 생성  Method */
    public String getAuthorizationUrl(HttpSession session) {

        /* 세션 유효성 검증을 위하여 난수를 생성 */
        String state = generateRandomString();
        /* 생성한 난수 값을 session에 저장 */
        setSession(session,state);

        /* Scribe에서 제공하는 인증 URL 생성 기능을 이용하여 네아로 인증 URL 생성 */
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(KAKAO_CLIENT_ID)
                .apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI)
                .state(state) //앞서 생성한 난수값을 인증 URL생성시 사용함
                .build(KakaoLoginApi.instance());

        return oauthService.getAuthorizationUrl();
    }

    /* 네아로 Callback 처리 및  AccessToken 획득 Method */
    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {

        /* Callback으로 전달받은 세선검증용 난수값과 세션에 저장되어있는 값이 일치하는지 확인 */
        String sessionState = getSession(session);
        if(StringUtils.pathEquals(sessionState, state)){

            OAuth20Service oauthService = new ServiceBuilder()
                    .apiKey(KAKAO_CLIENT_ID)
                    .apiSecret(KAKAO_CLIENT_SECRET)
                    .callback(KAKAO_REDIRECT_URI)
                    .state(state)
                    .build(KakaoLoginApi.instance());

            /* Scribe에서 제공하는 AccessToken 획득 기능으로 네아로 Access Token을 획득 */
            OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
            return accessToken;
        }
        return null;
    }

    /* 세션 유효성 검증을 위한 난수 생성기 */
    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    /* http session에 데이터 저장 */
    private void setSession(HttpSession session,String state){
        session.setAttribute(SESSION_STATE, state);
    }

    /* http session에서 데이터 가져오기 */
    private String getSession(HttpSession session){
        return (String) session.getAttribute(SESSION_STATE);
    }

    /* Access Token을 이용하여 네이버 사용자 프로필 API를 호출 */
    public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException{

        OAuth20Service oauthService =new ServiceBuilder()
                .apiKey(KAKAO_CLIENT_ID)
                .apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI).build(KakaoLoginApi.instance());

        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();

        // 응답 데이터 확인
        String responseBody = response.getBody();
        System.out.println("Kakao API Response: " + responseBody);

        return response.getBody();
    }

}
