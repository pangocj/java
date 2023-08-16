package xyz.itwill10.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.FileBoardDAO;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.util.Pager;

@Service
@RequiredArgsConstructor
public class FileBoardServiceImpl implements FileBoardService {
	private final FileBoardDAO fileBoardDAO;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeFileBoard(int idx) {
		/*
		if(fileBoardDAO.selectFileBoard(idx) == null) {
			throw new Exception();
		}
		*/
		fileBoardDAO.deleteFileBoard(idx);
	}

	@Override
	public FileBoard getFileBoard(int idx) {
		return fileBoardDAO.selectFileBoard(idx);
	}

	/*
	@Override
	public List<FileBoard> getFileBoardList() {
		return fileBoardDAO.selectFileBoardList();
	}
	*/
	
	//매개변수로 요청 페이지 번호를 전달받아 게시글 목록이 저장된 객체와 페이지 번호 관련 객체를
	//Map 객체의 엔트리로 추가하여 반환하는 메소드
	@Override
	public Map<String, Object> getFileBoardList(int pageNum) {
		//FILEBOARD 테이블에 저장된 모든 게시글의 갯수를 검색하여 반환하는 DAO 클래스의 메소드 호출
		int totalBoard=fileBoardDAO.selectFileBoardCount();
		int pageSize=5;//하나의 페이지에 출력될 게시글의 갯수 저장
		int blockSize=5;//하나의 블럭에 출력될 페이지의 갯수 저장
		
		//Pager 클래스로 객체를 생성하여 저장 - 생성자 매개변수에 페이징 처리 관련 값을 전달
		// => Pager 객체 : 페이징 처리 관련 값이 저장된 객체
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		//FileBoardDAO 클래스의 selectFileBoardList() 메소드를 호출하기 위해 매개변수에 전달하여
		//저장될 Map 객체(시작 행번호, 종료 행번호) 생성
		Map<String, Object> pageMap=new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		List<FileBoard> fileBoardList=fileBoardDAO.selectFileBoardList(pageMap);
		
		//Controller 클래스에게 제공되는 데이타 처리 결과값을 반환하기 위한 Map 객체 생성
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pager", pager);
		resultMap.put("fileBoardList", fileBoardList);
		
		return resultMap;
	}
}
