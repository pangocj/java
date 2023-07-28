package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memberService")
public class MemberServiceimpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberServiceimpl() {
		log.info("MemberServiceimpl 클래스의 기본 생성자 호출");
	}
	
	@Override
	public void addMember(Member member) {
		log.info("MemberServiceimpl 클래스의 addMember() 메소드 호출");
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		log.info("MemberServiceimpl 클래스의 modifyMember() 메소드 호출");
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String id) {
		log.info("MemberServiceimpl 클래스의 removeMember() 메소드 호출");
		memberDAO.deleteMember(id);
	}

	@Override
	public Member getMember(String id) {
		log.info("MemberServiceimpl 클래스의 getMember() 메소드 호출");
		return memberDAO.selectMember(id);
	}

	@Override
	public List<Member> getMemberList() {
		log.info("MemberServiceimpl 클래스의 getMemberList() 메소드 호출");
		return memberDAO.selectMemberList();
	}

}
