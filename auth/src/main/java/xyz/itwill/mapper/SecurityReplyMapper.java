package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.SecurityReply;

public interface SecurityReplyMapper {
	int insertSecurityReply(SecurityReply reply);
	List<SecurityReply> selectSecurityReplyList(int boardIdx);
}
