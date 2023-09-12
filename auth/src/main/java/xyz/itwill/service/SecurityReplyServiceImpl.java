package xyz.itwill.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.SecurityReply;
import xyz.itwill.repository.SecurityReplyRepository;
import xyz.itwill.repository.SecurityUsersRepository;

@Service
@RequiredArgsConstructor
public class SecurityReplyServiceImpl implements SecurityReplyService {
	private final SecurityUsersRepository securityUsersRepository;
	private final SecurityReplyRepository securityReplyRepository;

	@Override
	public void addSecurityReply(SecurityReply reply) {
		if(securityUsersRepository.selectSecurityUsersByUserid(reply.getWriter()) == null) {
			new IllegalArgumentException("작성자를 찾을 수 없습니다.");
		}
		securityReplyRepository.insertSecurityReply(reply);
	}

	@Override
	public List<SecurityReply> getSecurityReplyList(int boardIdx) {
		return securityReplyRepository.selectSecurityReplyList(boardIdx);
	}
}
