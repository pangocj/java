package xyz.itwill.access;

//접근제한자(Access Modifier) : 클래스, 필드, 메소드에 대한 접근 설정을 제한하기 위한 키워드
// => private, package(default), protected, public

//private 접근 제한자 : 클래스 내부에서만 접근 가능하며 클래스 외부에서는 접근 불가능 - 은닉화
public class PrivateMember {
	private int num;
	
	@SuppressWarnings("unused")
	private void display() {
		System.out.println("num = "+num);
	}
}
