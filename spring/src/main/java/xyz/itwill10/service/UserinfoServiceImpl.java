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
//3.BCrypt.checkpw(String plaintext, String hashed) 메소드로 암호화된 비밀번호를 비교하여 실행결과를 반환받아 처리 
// => 매개변수로 일반 문자열과 암호화된 문자열을 전달받아 비교하여 다른 경우 [false]를 반환하고
//같은 경우 [true]를 반환하는 메소드

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

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		//매개변수로 전달받은 회원정보의 아이디로 기존 회원정보를 검색하여 검색결과가 없는 경우
		if(userinfoDAO.selectUserinfo(userinfo.getUserid()) == null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		
		//매개변수로 전달받은 회원정보의 비밀번호가 존재할 경우 비밀번호를 암호화 처리하여 필드값으로 저장
		if(userinfo.getPassword() != null && !userinfo.getPassword().equals("")) {
			String hashedPassword=BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt());
			userinfo.setPassword(hashedPassword);			
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		//매개변수로 전달받은 아이디로 기존 회원정보를 검색하여 검색결과가 없는 경우
		if(userinfoDAO.selectUserinfo(userid) == null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}	
		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		//매개변수로 전달받은 아이디로 기존 회원정보를 검색하여 검색결과를 반환받아 저장
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		
		//검색된 회원정보가 없는 경우
		if(userinfo == null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}

	//매개변수로 회원정보(아이디와 비밀번호)를 전달받아 인증 처리하기 위한 메소드
	// => 인증 실패시 예외 발생하고 인증 성공시 예외 미발생
	// => 인증 성공시 매개변수로 전달받은 아이디의 회원정보를 검색하여 반환 - 세션에 권한 관련 정보로 저장
	@Override
	public Userinfo loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		//매개변수로 전달받은 회원정보의 아이디로 기존 회원정보를 검색하여 검색결과를 반환받아 저장
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());

		//검색된 회원정보가 없는 경우 - 아이디 인증 실패
		if(authUserinfo == null) {
			throw new LoginAuthFailException("아이디의 회원정보가 존재하지 않습니다.", userinfo.getUserid());
		}
		
		//매개변수로 전달받은 회원정보의 비밀번호와 검색된 회원정보의 비밀번호를 비교하여
		//같지 않은 경우 - 비밀번호 인증 실패
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {
			throw new LoginAuthFailException("아이디가 없거나 비밀번호가 맞지 않습니다.", userinfo.getUserid());
		}
		
		//매개변수로 전달받은 회원정보의 아이디로 검색된 회원정보 반환 
		return authUserinfo;
	}
}
