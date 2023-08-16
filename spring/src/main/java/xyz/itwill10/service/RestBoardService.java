package xyz.itwill10.service;

import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardService {
	void addRestBoard(RestBoard restBoard);
	void modifyRestBoard(RestBoard restBoard);
	void removeBoard(int idx);
	RestBoard getRestBoard(int idx);
	Map<String, Object> getRestBoardList(int pageNum);
}
