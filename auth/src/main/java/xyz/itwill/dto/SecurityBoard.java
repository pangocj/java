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
}
