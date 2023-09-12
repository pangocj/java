package xyz.itwill.dto;

import java.sql.Date;

import lombok.Data;

/*
create table security_board(idx number primary key, writer varchar2(100)
    , subject varchar2(1000), content varchar2(4000), regdate date);
    
create sequence security_board_seq;  
*/

@Data
public class SecurityBoard {
	private int idx;
	private String writer;
	private String subject;
	private String content;
	private Date regdate;
	//SECURITY_USERS 테이블에 저장된 게시글 작성자의 이름을 저장하기 위한 필드
	private String name;
}
