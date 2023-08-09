package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

//create table pointboard(idx number primary key, writer varchar2(20), subject varchar2(100));
//create sequence pointboard_seq;

@Data
@Builder
public class PointBoard {
	private int idx;
	private String writer;
	private String subject;
}
