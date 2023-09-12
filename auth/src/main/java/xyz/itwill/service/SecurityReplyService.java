package xyz.itwill.service;

import java.util.List;

import xyz.itwill.dto.SecurityReply;

public interface SecurityReplyService {
	void addSecurityReply(SecurityReply reply);
	List<SecurityReply> getSecurityReplyList(int boardIdx);
}
