package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.FileBoardDAO;
import xyz.itwill10.dto.FileBoard;

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

	@Override
	public List<FileBoard> getFileBoardList() {
		return fileBoardDAO.selectFileBoardList();
	}
}
