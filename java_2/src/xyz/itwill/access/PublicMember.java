package xyz.itwill.access;

//public 접근 제한자 : 모든 패키지의 클래스에서 접근 가능하도록 설정

//public 접근 제한자를 사용하여 클래스 선언 - public 클래스
// => public 클래스로 설정된 클래스는 모든 패키지의 클래스에서 접근 가능
// => public 클래스로 설정되지 않은 클래스는 다른 패키지의 클래스에서 접근 불가능
// => 하나의 소스파일에는 public class를 하나만 설정 가능
public class PublicMember {
	public int num;

	public void display() {
		System.out.println("num = "+num);
	}
}
