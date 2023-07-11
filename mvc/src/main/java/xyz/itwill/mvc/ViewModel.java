package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/view.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 로그인 상태의 사용자만 요청 가능하도록 권한 설정
// => 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 request 객체의 속성값으로
//저장하고 [user_view.jsp]로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class ViewModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			//비로그인 상태의 사용자인 경우 - 비정상적인 요청
			if(loginUserinfo==null) {
				throw new Exception();
			}
			
			if(request.getParameter("userid")==null) {//전달값이 없는 경우 - 비정상적인 요청
				throw new Exception();
			}
			
			String userid=request.getParameter("userid");
			
			//UserinfoService 클래스의 getUserinfo() 메소드를 호출하여 검색된 회원정보를
			//DTO 객체로 반환받아 request 객체의 속성값 저장
			// => UserinfoService 클래스의 getUserinfo() 메소드를 호출하여 검색된 회원정보가 
			//없는 경우 UserinfoNotFoundException 발생 - 비정상적인 요청
			request.setAttribute("userinfo", UserinfoService.getService().getUserinfo(userid));
				
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_view.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}
