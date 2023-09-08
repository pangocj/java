package xyz.itwill.repository;

import java.util.List;
import java.util.Map;

import xyz.itwill.dto.SecurityBoard;

public interface SecurityBoardRepository {
	int insertSecurityBoard(SecurityBoard board);
	int updateSecurityBoard(SecurityBoard board);
	int deleteSecurityBoard(int idx);
	SecurityBoard selectSecurityBoardByIdx(int idx);
	int selectSecurityBoardCount(Map<String, Object> map);
	List<SecurityBoard> selectSecurityBoardList(Map<String, Object> map);
}
