package xyz.itwill.access;

public class PrivateMemberUse {
	public void run() {
		@SuppressWarnings("unused")
		PrivateMember member=new PrivateMember();
		
		//private 접근제한자로 설정된 필드와 메소드에 접근할 경우 에러 발생
		//member.num=100;
		//member.display();
	}
}
