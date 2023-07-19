package xyz.itwill.dto;

//MYREPLY 테이블과 MYUSER 테이블의 컬럼값을 저장하기 위한 클래스
// => 1:1 관계의 테이블 조인에 대한 검색결과를 저장할 목적의 클래스
public class MyReplyUser {
	//MYREPLY 테이블(댓글정보)의 검색행을 객체로 제공받아 저장하기 위한 필드 - 검색행 1개
	private MyReply reply;
	
	//MYUSER 테이블(회원정보)의 검색행을 객체로 제공받아 저장하기 위한 필드 - 검색행 1개
	private MyUser user;
	
	public MyReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyReply getReply() {
		return reply;
	}

	public void setReply(MyReply reply) {
		this.reply = reply;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
}
