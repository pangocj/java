package xyz.itwill.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityAuth;
import xyz.itwill.dto.SecurityUsers;
import xyz.itwill.mapper.SecurityUsersMapper;

@Repository
@RequiredArgsConstructor
public class SecurityUsersRepositoryImpl implements SecurityUsersRepository {
	private final SqlSession sqlSession;
	
	@Override
	public int insertSecurityUsers(SecurityUsers users) {
		return sqlSession.getMapper(SecurityUsersMapper.class).insertSecurityUsers(users);
	}

	@Override
	public int insertSecurityAuth(SecurityAuth auth) {
		return sqlSession.getMapper(SecurityUsersMapper.class).insertSecurityAuth(auth);
	}

	@Override
	public SecurityUsers selectSecurityUsersByUserid(String userid) {
		return sqlSession.getMapper(SecurityUsersMapper.class).selectSecurityUsersByUserid(userid);
	}

}
