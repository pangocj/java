package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;

//클라이언트가 [/writeform.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 관리자만 요청 가능하도록 권한 설정
// => [user_write.jsp]로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class WriteFormModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			//비로그인 상태의 사용자이거나 로그인 사용자가 관리자가 아닌 경우 - 비정상적인 요청
			if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
				throw new Exception();
			}
			
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_write.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}
