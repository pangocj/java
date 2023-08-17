package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.service.RestBoardService;

@Controller
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestBoardController {
	private final RestBoardService restBoardService;
	
	//페이지 번호를 전달받아 RESTBAORD 테이블에 저장된 게시글 중 페이지 번호에 출력될 게시글
	//목록을 검색하여 JSON 형식의 문자열로 응답하는 요청 처리 메소드
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		
		
	}
}
