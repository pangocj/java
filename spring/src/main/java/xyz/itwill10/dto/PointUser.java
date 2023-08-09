package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

//create table pointuser(id varchar2(20) primary key, name varchar2(30), point number);
@Data
@Builder
public class PointUser {
	private String id;
	private String name;
	private int point;
}
