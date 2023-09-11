package xyz.itwill.auth;

import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityBoard;
import xyz.itwill.service.SecurityBoardService;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class SecurityBoardController {
	private final SecurityBoardService securityBoardService;
	
	@RequestMapping("/list")
	public String list(@RequestParam Map<String, Object> map, Model model) {
		 model.addAttribute("result", securityBoardService.getSecurityBoardList(map));
		 model.addAttribute("search", map);
		 return "board/list";
	}

	//@PreAuthorize : 요청 처리 메소드에 필요한 권한을 설정하기 위한 어노테이션
	// => value 속성에 SpEL을 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	public String register() {
		return "board/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("isAuthenticated()")
	public String register(@ModelAttribute SecurityBoard board) {
		board.setSubject(HtmlUtils.htmlEscape(board.getSubject()));
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		securityBoardService.addSecurityBoard(board);		
		return "redirect:/board/list";
	}
}















