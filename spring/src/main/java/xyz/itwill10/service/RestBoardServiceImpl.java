package xyz.itwill10.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.RestBoardDAO;
import xyz.itwill10.dto.RestBoard;
import xyz.itwill10.util.Pager;

@Service
@RequiredArgsConstructor
public class RestBoardServiceImpl implements RestBoardService {
	private final RestBoardDAO restBoardDAO;

	@Override
	public void addRestBoard(RestBoard restBoard) {
		restBoardDAO.insertRestBoard(restBoard);
	}

	@Override
	public void modifyRestBoard(RestBoard restBoard) {
		/*
		if(restBoardDAO.selectRestBoard(restBoard.getIdx()) == null) {
			throw new Exception("해당 게시글을 찾을 수 없습니다.");
		}
		*/
		
		restBoardDAO.updateRestBoard(restBoard);
	}

	@Override
	public void removeBoard(int idx) {
		restBoardDAO.deleteRestBoard(idx);

	}

	@Override
	public RestBoard getRestBoard(int idx) {
		return restBoardDAO.selectRestBoard(idx);
	}

	@Override
	public Map<String, Object> getRestBoardList(int pageNum) {
		int totalBoard=restBoardDAO.selectRestBoardCount();
		
		Pager pager=new Pager(pageNum, totalBoard, 5, 5);
		
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		
		List<RestBoard> restBoardList=restBoardDAO.selectRestBoardList(pageMap);
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("restBoardList", restBoardList);
		resultMap.put("pager", pager);

		return resultMap;
	}
}
