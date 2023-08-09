package xyz.itwill10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.mapper.PointUserMapper;

@Repository
@RequiredArgsConstructor
public class PointUserDAOImpl implements PointUserDAO {
	private final SqlSession sqlSession;
	
	@Override 
	public int insertPointUser(PointUser user) {
		return sqlSession.getMapper(PointUserMapper.class).insertPointUser(user);
	}

	@Override
	public int updatePlusPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updatePlusPointUser(id);
	}

	@Override
	public int updateMinusPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updateMinusPointUser(id);
	}

	@Override
	public PointUser selectPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).selectPointUser(id);
	}
}
