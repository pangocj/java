package xyz.itwill.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityAuth;
import xyz.itwill.dto.SecurityUsers;
import xyz.itwill.service.SecurityUsersService;

@Controller
@RequiredArgsConstructor
public class SecurityUsersController {
	private final SecurityUsersService securityUsersService;
	private final PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/security/add", method = RequestMethod.GET)
	@ResponseBody
	public String addUsers() {
		SecurityUsers user1=new SecurityUsers("abc123", 
				passwordEncoder.encode("123456"), "홍길동", "abc@itwill.xyz", "1", null);
		SecurityUsers user2=new SecurityUsers("xyz789", 
				passwordEncoder.encode("123456"), "임꺽정", "xyz@itwill.xyz", "1", null);
		SecurityUsers user3=new SecurityUsers("opq456", 
				passwordEncoder.encode("123456"), "전우치", "opq@itwill.xyz", "1", null);
		
		securityUsersService.addSecurityUsers(user1);
		securityUsersService.addSecurityUsers(user2);
		securityUsersService.addSecurityUsers(user3);
		
		SecurityAuth auth1=new SecurityAuth("abc123", "ROLE_USER");
		SecurityAuth auth2=new SecurityAuth("abc123", "ROLE_MANAGER");
		SecurityAuth auth3=new SecurityAuth("xyz789", "ROLE_MANAGER");
		SecurityAuth auth4=new SecurityAuth("opq456", "ROLE_ADMIN");

		securityUsersService.addSecurityAuth(auth1);
		securityUsersService.addSecurityAuth(auth2);
		securityUsersService.addSecurityAuth(auth3);
		securityUsersService.addSecurityAuth(auth4);
		
		return "success";
	}
}
