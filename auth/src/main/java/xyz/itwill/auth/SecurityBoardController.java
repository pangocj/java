package xyz.itwill.auth;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
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
}















