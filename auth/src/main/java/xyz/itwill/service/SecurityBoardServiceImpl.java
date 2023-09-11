package xyz.itwill.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityBoard;
import xyz.itwill.repository.SecurityBoardRepository;
import xyz.itwill.repository.SecurityUsersRepository;
import xyz.itwill.util.Pager;

@Service
@RequiredArgsConstructor
public class SecurityBoardServiceImpl implements SecurityBoardService {
	private final SecurityUsersRepository securityUsersRepository;
	private final SecurityBoardRepository securityBoardRepository;

	@Transactional(rollbackFor = IllegalArgumentException.class)
	@Override
	public void addSecurityBoard(SecurityBoard board) {
		if(securityUsersRepository.selectSecurityUsersByUserid(board.getWriter()) == null) {
			throw new IllegalArgumentException("게시글 작성자를 찾을 수 없습니다.");
		}
		securityBoardRepository.insertSecurityBoard(board);
	}

	@Transactional(rollbackFor = IllegalArgumentException.class)
	@Override
	public void modifySecurityBoard(SecurityBoard board) {
		if(securityUsersRepository.selectSecurityUsersByUserid(board.getWriter()) == null) {
			throw new IllegalArgumentException("게시글 작성자를 찾을 수 없습니다.");
		}
		
		if(securityBoardRepository.selectSecurityBoardByIdx(board.getIdx()) == null) {
			throw new IllegalArgumentException("게시글을 찾을 수 없습니다.");
		}
		securityBoardRepository.updateSecurityBoard(board);
	}

	@Transactional(rollbackFor = IllegalArgumentException.class)
	@Override
	public void removeSecurityBoard(int idx) {
		if(securityBoardRepository.selectSecurityBoardByIdx(idx) == null) {
			throw new IllegalArgumentException("게시글을 찾을 수 없습니다.");
		}
		securityBoardRepository.deleteSecurityBoard(idx);
	}

	@Override
	public SecurityBoard getSecurityBoardByIdx(int idx) {
		SecurityBoard board=securityBoardRepository.selectSecurityBoardByIdx(idx);
		if(board == null) {
			throw new IllegalArgumentException("게시글을 찾을 수 없습니다.");
		}
		return board;
	}

	@Override
	public Map<String, Object> getSecurityBoardList(Map<String, Object> map) {
		int pageNum=1;
		if(map.get("pageNum") != null) {
			pageNum=Integer.parseInt((String)map.get("pageNum"));
		}
		int pageSize=5;
		int totalBoard=securityBoardRepository.selectSecurityBoardCount(map);
		int blockSize=5;
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		map.put("startRow", pager.getStartRow());
		map.put("endRow", pager.getEndRow());
		List<SecurityBoard> securityBoardList=securityBoardRepository.selectSecurityBoardList(map);
		
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("pager", pager);
		result.put("securityBoardList", securityBoardList);
		
		return result;
	}
}





