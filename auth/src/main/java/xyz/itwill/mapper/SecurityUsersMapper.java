package xyz.itwill.mapper;

import xyz.itwill.dto.SecurityAuth;
import xyz.itwill.dto.SecurityUsers;

public interface SecurityUsersMapper {
	int insertSecurityUsers(SecurityUsers users);
	int insertSecurityAuth(SecurityAuth auth);
	SecurityUsers selectSecurityUsersByUserid(String userid);
}
