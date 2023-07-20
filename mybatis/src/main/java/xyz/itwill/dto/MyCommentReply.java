package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYREPLY 테이블의 컬럼값을 저장하기 위한 클래스
// => 1:N 관계의 테이블 조인에 대한 검색결과를 저장할 목적의 클래스
public class MyCommentReply {
	private int commentNo;
	
	//MYCOMMENT 테이블(게시글정보)의 검색행을 객체로 제공받아 저장하기 위한 필드 - 검색행 1개
	private MyComment1 comment;
	
	//MYREPLY 테이블(댓글정보)의 검색행을 객체로 제공받아 저장하기 위한 필드 - 검색행 0개 이상
	private List<MyReply> replyList;	
	
	public MyCommentReply() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public List<MyReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<MyReply> replyList) {
		this.replyList = replyList;
	}
}
