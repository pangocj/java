package xyz.itwill.auth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

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
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "board/register";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute SecurityBoard board) {
		board.setSubject(HtmlUtils.htmlEscape(board.getSubject()));
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		securityBoardService.addSecurityBoard(board);		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam Map<String, Object> map, Model model) {
		int idx=Integer.parseInt((String)map.get("idx"));
		model.addAttribute("securityBoard", securityBoardService.getSecurityBoardByIdx(idx));
		model.addAttribute("search", map);
		return "board/detail";
	}

	//로그인 사용자가 관리자이거나 로그인 사용자의 아이디와 게시글 작성자가 같은 경우에만 
	//요청 처리 메소드 호출
	// => SpEL을 이용하여 권한 설정시 EL 연산자 사용 가능
	@PreAuthorize("hasRole('ROLE_ADMIN') or principal.userid eq #map['writer']")
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam Map<String, Object> map, Model model) {
		int idx=Integer.parseInt((String)map.get("idx"));
		model.addAttribute("securityBoard", securityBoardService.getSecurityBoardByIdx(idx));
		model.addAttribute("search", map);
		return "board/modify";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or principal.userid eq #board.writer")
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute SecurityBoard board, @RequestParam Map<String, Object> map) throws UnsupportedEncodingException {
		board.setSubject(HtmlUtils.htmlEscape(board.getSubject()));
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		securityBoardService.modifySecurityBoard(board);
		
		String pageNum=(String)map.get("pageNum");
		String column=(String)map.get("column");
		String keyword=URLEncoder.encode((String)map.get("keyword"),"utf-8");
		return "redirect:/board/detail?idx="+board.getIdx()+"&pageNum="+pageNum
				+"&column="+column+"&keyword="+keyword;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or principal.userid eq #writer")
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam int idx, @RequestParam String writer) {
		securityBoardService.removeSecurityBoard(idx);
		return "redirect:/board/list";
	}
}
