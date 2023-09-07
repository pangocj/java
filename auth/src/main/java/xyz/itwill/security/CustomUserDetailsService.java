package xyz.itwill.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityUsers;
import xyz.itwill.repository.SecurityUsersRepository;

//인증 처리 후 인증된 사용자 정보와 권한을 저장한 UserDetails 객체를 반환하는 기능을 제공하는 클래스
// => UserDetailsService 인터페이스를 상속받아 작성
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final SecurityUsersRepository securityUsersRepository;  

	//매개변수로 아이디를 전달받아 DB에 저장된 사용자 정보를 검색하여 검색된 사용자 정보로
	//UserDetails 객체를 생성하여 반환하는 메소드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUsers users=securityUsersRepository.selectSecurityUsersByUserid(username);
		
		if(users == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new CustomUserDetails(users);
	}

}
