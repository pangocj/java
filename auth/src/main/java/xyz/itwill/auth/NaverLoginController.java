package xyz.itwill.auth;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/naver")
public class NaverLoginController {
	@RequestMapping("/login")
	public String login(HttpSession session) throws UnsupportedEncodingException {
		String clientId = "xi6thXCdpMBmXIrqcirU";
		String redirectURI = URLEncoder.encode("http://localhost:8000/auth/naver/callback", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    session.setAttribute("state", state);
	    
	    return "redirect:"+apiURL;
	}
}
