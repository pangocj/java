package xyz.itwill.access;

public class ProtectedMemberUse {
	public void run() {
		ProtectedMember member=new ProtectedMember();
		
		member.num=100;
		member.display();
	}
}
