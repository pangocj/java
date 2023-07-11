package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/remove.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 관리자만 요청 가능하도록 권한 설정
// => 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하고 [/list.do]로 리다이렉트 
//이동하기 위한 정보가 저장된 ActionForward 객체 반환
// => 관리자가 자신을 삭제 처리한 경우 [/logout.do]로 리다이렉트 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class RemoveModel implements Action {

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
			
			if(request.getParameter("userid")==null) {//전달값이 없는 경우 - 비정상적인 요청
				throw new Exception();
			}
			
			String userid=request.getParameter("userid");
			
			//UserinfoService 클래스의 removeUserinfo() 메소드를 호출하여 회원정보 삭제 처리
			UserinfoService.getService().removeUserinfo(userid);
				
			actionForward.setForward(false);
			if(loginUserinfo.getUserid().equals(userid)) {
				actionForward.setPath(request.getContextPath()+"/logout.do");
			} else {
				actionForward.setPath(request.getContextPath()+"/list.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}
