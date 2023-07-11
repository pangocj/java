package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 [/list.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => USEINFO 테이블에 저장된 모든 회원정보를 검색하여 request 객체의 속성값으로 저장하고
//[user_list.jsp]로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class ListModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
