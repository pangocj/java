package xyz.itwill.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
create table users(username varchar2(100) primary key, password varchar2(100), enabled varchar2(1));

insert into users values('abc123','123456','1');
insert into users values('xyz789','123456','1');
insert into users values('opq456','123456','1');
insert into users values('test','123456','0');
commit;

create table authorities(username varchar2(100), authority varchar2(50)
    , CONSTRAINT auth_username_fk foreign key(username) references users(username));
    
create unique index auth_username_index on authorities(username, authority);   

insert into authorities values('abc123','ROLE_USER');
insert into authorities values('abc123','ROLE_MANAGER');
insert into authorities values('xyz789','ROLE_MANAGER');
insert into authorities values('opq456','ROLE_ADMIN');
insert into authorities values('test','ROLE_USER');
commit;
*/

@Controller
public class LoginController {
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login() {
		return "login_page";
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "access_denied";
	}
}
