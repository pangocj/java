package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;

public interface PointBoardService {
	PointUser addPointBoard(PointBoard board) throws Exception;
	PointUser removePointBoard(int idx) throws Exception;
	List<PointBoard> getPointBoardList();
}
