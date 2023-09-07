package xyz.itwill.xyz;

import xyz.itwill.dto.SecurityAuth;
import xyz.itwill.dto.SecurityUsers;

public interface SecurityUsersService {
	void addSecurityUsers(SecurityUsers users);
	void addSecurityAuth(SecurityAuth auth);
	SecurityUsers getSecurityUsers(String userid);
}
