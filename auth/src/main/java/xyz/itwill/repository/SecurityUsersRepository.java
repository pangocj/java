package xyz.itwill.repository;

import xyz.itwill.dto.SecurityAuth;
import xyz.itwill.dto.SecurityUsers;

public interface SecurityUsersRepository {
	int insertSecurityUsers(SecurityUsers users);
	int insertSecurityAuth(SecurityAuth auth);
	SecurityUsers selectSecurityUsersByUserid(String userid);
}
