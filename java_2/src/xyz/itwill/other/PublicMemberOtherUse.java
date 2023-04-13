package xyz.itwill.other;

import xyz.itwill.access.PublicMember;

public class PublicMemberOtherUse {
	public void run() {
		PublicMember member=new PublicMember();
		
		member.num=100;
		member.display();
	}
}
