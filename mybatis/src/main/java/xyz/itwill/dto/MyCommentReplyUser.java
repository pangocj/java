package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYUSER 테이블 및 MYREPLY 테이블(MYUSER 테이블)의 컬럼값을 저장하기 위한 클래스
public class MyCommentReplyUser {
	//MYCOMMENT 테이블(게시글정보)의 검색결과를 컬럼값으로 제공받아 저장하기 위한 필드 - 검색행 : 1개
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	//MYUSER 테이블(회원정보 - 게시글)의 검색결과를 객체로 제공받아 저장하기 위한 필드 - 검색행 : 1개
	private MyUser user;
	
	//MYREPLY 테이블(댓글정보)와 MYUSER(회원정보 - 댓글)의 검색결과가 요소로 저장된 List 객체를  
	//제공받아 저장하기 위한 필드 - 검색행 : 0개 이상
	private List<MyReplyUser> replyUserList;
	
	public MyCommentReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplyUserList() {
		return replyUserList;
	}

	public void setReplyUserList(List<MyReplyUser> replyUserList) {
		this.replyUserList = replyUserList;
	}
}
