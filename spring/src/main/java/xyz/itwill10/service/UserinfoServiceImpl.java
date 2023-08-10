package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.UserinfoDAO;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

//사용자로부터 입력받아 전달된 문자열(비밀번호)을 암호화 처리하는 방법
//1.jbcrypt 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml

@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Override
	public void addUserinfo(Userinfo userinfo) throws ExistsUserinfoException {
		//매개변수로 전달받은 회원정보의 아이디가 기존 회원정보의 아이디와 중복될 경우
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) != null) {
			//예외를 명확하기 구분하고 예외처리시 필요한 값을 제공하기 위해 직접 생성한 예외 
			//클래스를 사용하여 인위적인 예외 발생
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력 하였습니다.", userinfo);
		}
		
		//매개변수로 전달받은 회원정보의 비밀번호를 암호화 처리하여 필드값으로 저장
		
		userinfoDAO.insertUserinfo(userinfo);
	}

	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Userinfo loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		// TODO Auto-generated method stub
		return null;
	}
}
