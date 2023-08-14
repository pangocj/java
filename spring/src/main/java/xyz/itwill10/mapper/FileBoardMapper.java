package xyz.itwill10.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill10.dto.FileBoard;

public interface FileBoardMapper {
	int insertFileBoard(FileBoard fileBoard);
	int deleteFileBoard(int idx);
	FileBoard selectFileBoard(int idx);
	//List<FileBoard> selectFileBoardList();
	List<FileBoard> selectFileBoardList(Map<String, Object> map);
	int selectFileBoardCount();
}
