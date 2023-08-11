package xyz.itwill10.dao;

import java.util.List;

import xyz.itwill10.dto.FileBoard;

public interface FileBoardDAO {
	int insertFileBoard(FileBoard fileBoard);
	int deleteFileBoard(int idx);
	FileBoard selectFileBoard(int idx);
	List<FileBoard> selectFileBoardList();
}
