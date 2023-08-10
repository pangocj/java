package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.BadRequestException;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
@RequiredArgsConstructor
public class UserinfoController {
	private final UserinfoService userinfoService;
	
	//회원정보를 입력받기 위한 뷰이름을 반환하는 요청 처리 메소드
	// => 비로그인 사용자 또는 관리자가 아닌 사용자가 페이지를 요청할 경우 인위적 예외 발생
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(HttpSession session) throws BadRequestException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			//throw new Exception("비정상적인 요청입니다.");
			throw new BadRequestException("비정상적인 요청입니다.");
		}
		return "userinfo/user_write";
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 삽입하고 로그인 페이지를 요청할 수 있는 URL 주소를
	//클라이언트에게 전달하여 응답 처리하는 요청 처리 메소드
	// => UserinfoService 객체로 메소드 호출시 예외 발생 - try~catch 구문을 사용하여 예외 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			//매개변수로 전달받은 회원정보의 아이디가 중복될 경우 ExistsUserinfoException 발생
			userinfoService.addUserinfo(userinfo);
		} catch (ExistsUserinfoException e) {
			//ExistsUserinfoException 객체에 저장된 예외 메세지를 반환받아 속성값으로 저장
			model.addAttribute("message", e.getMessage());
			
			//ExistsUserinfoException 객체에 저장된 회원정보(Userinfo 객체)를 반환받아 속성값으로 저장
			//model.addAttribute("userinfo", e.getUserinfo());
			
			//아이디가 중복되어 예외가 발생된 경우 회원정보를 입력받기 위한 뷰이름 반환
			return "userinfo/user_write";
		}
		
		return "redirect:/userinfo/login";
	}
	
	//로그인정보를 입력받기 위한 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	//로그인정보를 전달받아 로그인 처리하고 환영메세지를 출력하는 뷰이름을 반환하는 요청 처리 메소드
	// => 인증 성공후 로그인 회원정보를 세션의 속성값으로 저장 - 권한
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, Model model, HttpSession session) {
		try {
			//매개변수로 전달받은 회원정보로 인증 실패된 경우 LoginAuthFailException 발생
			Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
			
			//LoginAuthFailException 미발생 - 인증 성공
			session.setAttribute("loginUserinfo", authUserinfo);
		} catch (LoginAuthFailException e) {
			 model.addAttribute("message", e.getMessage());
			 model.addAttribute("userid", e.getUserid());
			 return "userinfo/user_login";
		}
		
		return "userinfo/user_login";
	}
	
	//로그아웃 처리하고 로그인 페이지를 요청할 수 있는 URL 주소를 클라이언트에게 전달하여 
	//응답 처리하는 요청 처리 메소드
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUserinfo");
		session.invalidate();
		
		return "redirect:/userinfo/login";
	}

}















