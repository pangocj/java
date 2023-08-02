package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모델 기능을 제공하는 클래스가 반드시 상속받아야 되는 인터페이스
// => 모든 모델 클래스에 동일한 메소드가 작성되도록 규칙 제공
// => 컨트롤러에서 모델 클래스의 객체로 요청 처리 메소드를 쉽게 호출하기 위해 인터페이스 필요
public interface Controller {
	//모든 모델 클래스에서 반드시 작성할 요청 처리 메소드를 추상메소드로 선언
	String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}
