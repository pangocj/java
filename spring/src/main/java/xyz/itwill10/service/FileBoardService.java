package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.FileBoard;

public interface FileBoardService {
	void addFileBoard(FileBoard fileBoard);
	void removeFileBoard(int idx);
	FileBoard getFileBoard(int idx);
	List<FileBoard> getFileBoardList();
}
