package xyz.itwill10.dao;

import java.util.List;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardDAO {
	int insertRestBoard(RestBoard restBoard);
	int updateRestBoard(RestBoard restBoard);
	int deleteRestBoard(int idx);
	RestBoard selectRestBoard(int idx);
	int selectRestBoardCount();
	List<RestBoard> selectRestBoardList();
}
