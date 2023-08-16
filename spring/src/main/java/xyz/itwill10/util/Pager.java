package xyz.itwill10.util;

import lombok.Data;

//페이징 처리 관련 값을 저장하기 위한 클래스
@Data
public class Pager {
	//생성자를 이용하여 초기값을 전달받아 필드에 저장
	private int pageNum;//요청 페이지의 번호
	private int totalBoard;//전체 게시글의 갯수
	private int pageSize;//하나의 페이지에 출력될 게시글의 갯수
	private int blockSize;//하나의 블럭에 출력될 페이지 번호의 갯수

	//생성자로 초기화된 필드값을 계산하여 결과값을 필드에 저장
	private int totalPage;//전체 페이지의 갯수
	private int startRow;//요청 페이지에 출력될 게시글의 시작 행번호
	private int endRow;//요청 페이지에 출력될 게시글의 종료 행번호
	private int startPage;//현재 블럭에 출력될 시작 페이지 번호
	private int endPage;//현재 블럭에 출력될 종료 페이지 번호
	private int prevPage;//이전 블럭에 출력될 시작 페이지 번호
	private int nextPage;//다음 블럭에 출력될 시작 페이지 번호
	
	public Pager(int pageNum, int totalBoard, int pageSize, int blockSize) {
		super();
		this.pageNum = pageNum;
		this.totalBoard = totalBoard;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		calcPage();
	}
	
	//계산된 결과값을 필드에 저장하는 메소드 - 생성자에서 호출하여 사용
	private void calcPage() {
		totalPage=(int)Math.ceil((double)totalBoard/pageSize);
		if(pageNum<=0 || pageNum>totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
 		endRow=pageNum*pageSize;
		if(endRow>totalBoard) {
			endRow=totalBoard;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}
	
}
