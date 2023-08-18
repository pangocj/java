package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.RestBoard;
import xyz.itwill10.service.RestBoardService;

//REST 기능을 제공하는 요청 처리 메소드가 정상적으로 실행되는지 확인하기 위해 Advanced REST
//Client 프로그램을 설치하여 사용 - Restful API 테스트 프로그램

//@RestController : REST 기능을 제공하는 요청 처리 메소드(Restful API)만 선언된 Controller 
//클래스를 Spring Bean으로 등록하는 어노테이션
// => 요청 처리 메소드에 @ResponseBody 어노테이션을 사용하지 않아도 문자열로 응답 처리 가능
@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestBoardController {
	private final RestBoardService restBoardService;
	
	//페이지 번호를 전달받아 RESTBAORD 테이블에 저장된 게시글 중 페이지 번호에 출력될 게시글
	//목록을 검색하여 JSON 형식의 문자열로 응답하는 요청 처리 메소드
	//REST 기능을 제공하는 요청 처리 메소드는 @RequestMapping 어노테이션 대신 @GetMapping,
	//@PostMapping, @PutMapping, @PatchMapping, @DeleteMapping 어노테이션을 사용하여 페이지의 
	//요청 URL 주소를 요청 처리 메소드와 매핑 처리하는 것을 권장
	// => 요청방식 : GET(검색), POST(삽입), PUT(전체 변경), PATCH(부분 변경), DELETE(삭제) 등
	//@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@GetMapping("/board_list")
	//Controller 클래스를 @RestController 어노테이션을 사용하여 Spring Bean으로 등록하였으므로
	//@ResponseBody 어노테이션을 생략해도 문자열로 응답 처리 가능
	//@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//Map 객체를 자바스트립트의 Object 객체 형식의 문자열로 변환하여 응답 처리
		return restBoardService.getRestBoardList(pageNum);		
	}
	
	//게시글을 전달받아 RESTBOARD 테이블에 게시글을 삽입 처리하고 실행결과를 일반 문자열로 응답하는 요청 처리 메소드
	// => [application/json] 형식의 문자열로 전달된 게시글을 Java 객체로 제공받아 매개변수에
	//저장하기 위해 @RequestBody 어노테이션 사용
	@PostMapping("/board_add")
	public String restBoardAdd(@RequestBody RestBoard restBoard) {
		//HtmlUtils.htmlEscape(String str) : 매개변수로 전달받은 문자열에 저장된 HTML 태그 관련
		//문자를 회피문자(Escape Character)로 변환하여 반환하는 메소드 - XSS 공격에 대한 방어
		restBoard.setContent(HtmlUtils.htmlEscape(restBoard.getContent()));
		restBoardService.addRestBoard(restBoard);
		return "success";
	}
	
	/*
	//글번호를 전달받아 RESTBOARD 테이블에 저장된 게시글에서 해당 글번호의 게시글을 검색하여
	//JSON 형식의 문자열로 응답하는 요청 처리 메소드
	// => 질의문자열(QueryString)로 전달된 글번호를 매개변수로 제공받아 사용
	@GetMapping("/board_view")
	public RestBoard restBoardView(@RequestParam int idx) {
		return restBoardService.getRestBoard(idx);
	}
	*/
	
	//글번호를 전달받아 RESTBOARD 테이블에 저장된 게시글에서 해당 글번호의 게시글을 검색하여
	//JSON 형식의 문자열로 응답하는 요청 처리 메소드
	// => 요청 URL 주소로 표현된 글번호를 매개변수로 제공받아 사용
	//요청 URL 주소로 값을  표현하여 전달하기 위해서는 @GetMapping 어노테이션의 value 속성값에 
	//{이름} 형식으로 요청 URL 주소를 표현 
	// => 요청 URL 주소로 표현된 값은 매개변수에 @PathVariable 어노테이션을 사용하여 전달값을 저장
	//@PathVariable : 요청 URL 주소로 표현된 값을 요청 처리 메소드의 매개변수에 저장하기 위한 어노테이션
	// => @GetMapping 어노테이션의 value 속성값으로 설정된 이름과 매개변수의 이름을 같도록 작성
	// => 전달값의 이름과 매개변수의 이름이 다른 경우 @PathVariable 어노테이션에 value 속성을
	//사용하여 요청 URL 주소로 표현하여 전달된 값을 매개변수에 저장 가능
	@GetMapping("/board_view/{idx}")
	public RestBoard restBoardView(@PathVariable int idx) {
		return restBoardService.getRestBoard(idx);
	}
	
	//게시글을 전달받아 RESTBOARD 테이블에 저장된 게시글을 변경하고 실행결과를 일반 문자열로 응답하는 요청 처리 메소드
	// => [application/json] 형식의 문자열로 전달된 게시글을 Java 객체로 제공받아 매개변수에
	//저장하기 위해 @RequestBody 어노테이션 사용	
	@PutMapping("/board_modify")
	public String restBoardModify(@RequestBody RestBoard restBoard) {
		restBoard.setContent(HtmlUtils.htmlEscape(restBoard.getContent()));
		restBoardService.modifyRestBoard(restBoard);
		return "success";
	}

	//글번호를 전달받아 RESTBOARD 테이블에 저장된 게시글을 삭제하고 실행결과를 일반 문자열로 응답하는 요청 처리 메소드
	// => 요청 URL 주소로 표현된 글번호를 매개변수로 제공받아 사용
	@DeleteMapping("/board_remove/{idx}")
	public String restBoardRemove(@PathVariable int idx) {
		restBoardService.removeBoard(idx);
		return "success";
	}

}