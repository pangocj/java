package xyz.itwill.service;

import java.util.Map;

import xyz.itwill.dto.SecurityBoard;

public interface SecurityBoardService {
	void addSecurityBoard(SecurityBoard board);
	void modifySecurityBoard(SecurityBoard board);
	void removeSecurityBoard(int idx);
	SecurityBoard getSecurityBoardByIdx(int idx);
	Map<String, Object> getSecurityBoardList(Map<String, Object> map);
}
