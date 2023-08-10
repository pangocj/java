package xyz.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.UserinfoDAO;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

//사용자로부터 입력받아 전달된 문자열(비밀번호)을 암호화 처리하는 방법
//1.jbcrypt 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.BCrypt.hashpw(String password, String salt) 메소드를 호출하여 문자열(비밀번호)을 암호화 처리
// => 매개변수로 암호화 처리할 문자열과 첨가물을 전달받아 암호화 처리 - 첨가물에 의해 비밀번호가 다르게 암호화 처리
// => BCrypt 클래스 : 단방향 암호화 기능의 BlowFish 알고리즘을 기반으로 설계된 암호화 처리 클래스
// => BCrypt.gensalt(int log_bounds) : 매개변수로 첨가물(Salt - String)의 길이를 전달받아 
//첨가물을 생성하여 반환하는 메소드 - 매개변수에 길이를 전달하지 않으면 자동으로 [10]으로 설정

@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUserinfo(Userinfo userinfo) throws ExistsUserinfoException {
		//매개변수로 전달받은 회원정보의 아이디가 기존 회원정보의 아이디와 중복될 경우
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) != null) {
			//예외를 명확하기 구분하고 예외처리시 필요한 값을 제공하기 위해 직접 생성한 예외 
			//클래스를 사용하여 인위적인 예외 발생
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력 하였습니다.", userinfo);
		}
		
		//매개변수로 전달받은 회원정보의 비밀번호를 암호화 처리하여 필드값으로 다시 저장
		String hashedPassword=BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt());
		userinfo.setPassword(hashedPassword);
		
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
