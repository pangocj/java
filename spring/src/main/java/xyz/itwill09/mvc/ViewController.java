package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모델 기능을 제공하기 위한 클래스 - 요청 처리 메소드가 추상메소드로 선언된 인터페이스를 상속받아 작성
// => 클라이언트가 [/view.itwill]의 URL 주소로 요청한 경우 컨트롤러에 의해 실행될 요청 처리 클래스
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test", "일지매", "서울시 종로구");
		request.setAttribute("member", member);
		return "member_view";
	}

}
