package xyz.itwill.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
create table security_users(userid varchar2(100) primary key, passwd varchar2(100)
    , name varchar2(50), email varchar2(100), enabled varchar2(1));
    
create table security_auth(userid varchar2(100), auth varchar2(50)
    , CONSTRAINT auth_userid_fk foreign key(userid) references security_users(userid));
    
create unique index auth_userid_index on security_auth(userid, auth);   
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUsers {
	private String userid;
	private String passwd;
	private String name;
	private String email;
	private String enabled;
	private List<SecurityAuth> securityAuthList;
}
