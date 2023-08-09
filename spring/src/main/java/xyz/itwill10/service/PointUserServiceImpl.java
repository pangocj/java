package xyz.itwill10.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointUser;

@Service
@RequiredArgsConstructor
public class PointUserServiceImpl implements PointUserService {
	private final PointUserDAO pointUserDAO;

	//매개변수로 회원정보를 전달받아 POINTUSER 테이블에 회원정보를 삽입하고 삽입된 회원정보를 
	//검색하여 반환하는 메소드
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PointUser addPointUser(PointUser user) throws Exception {
		//매개변수로 전달받은 회원정보의 아이디가 POINTUSER 테이블에 저장된 기존 회원정보의
		//아이디와 중복될 경우 인위적 예외 발생 
		if(pointUserDAO.selectPointUser(user.getId()) != null) {
			throw new Exception("이미 사용중인 아이디입니다.");
		}
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}
}
