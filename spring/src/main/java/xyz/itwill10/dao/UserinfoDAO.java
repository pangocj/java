package xyz.itwill10.dao;

import java.util.List;

import xyz.itwill10.dto.Userinfo;

public interface UserinfoDAO {
	int insertUserinfo(Userinfo userinfo);
	int updateUserinfo(Userinfo userinfo);
	int deleteUserinfo(String userid);
	Userinfo selectUserinfo(String userid);
	List<Userinfo> selectUserinfoList();
}
