package xyz.itwill10.mapper;

import xyz.itwill10.dto.PointUser;
 
public interface PointUserMapper {
	int insertPointUser(PointUser user);
	int updatePlusPointUser(String id);
	int updateMinusPointUser(String id);
	PointUser selectPointUser(String id);
}
