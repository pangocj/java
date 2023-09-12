package xyz.itwill.repository;

import java.util.List;

import xyz.itwill.dto.SecurityReply;

public interface SecurityReplyRepository {
	int insertSecurityReply(SecurityReply reply);
	List<SecurityReply> selectSecurityReplyList(int boardIdx);
}
