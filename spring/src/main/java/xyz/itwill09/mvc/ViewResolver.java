package xyz.itwill09.mvc;

//응답 관련 정보를 제공하기 위한 클래스
public class ViewResolver {
	//매개변수로 ViewName을 전달받아 응답처리할 JSP 문서의 경로를 생성하여 반환
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}
