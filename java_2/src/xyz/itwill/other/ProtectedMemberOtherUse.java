package xyz.itwill.other;

import xyz.itwill.access.ProtectedMember;

public class ProtectedMemberOtherUse {
	public void run() {
		@SuppressWarnings("unused")
		ProtectedMember member=new ProtectedMember();
		
		//member.num=100;
		//member.display();
	}
}
