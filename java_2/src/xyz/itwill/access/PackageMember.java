package xyz.itwill.access;

//package 접근 제한자 : 같은 패키지의 클래스에서 접근 가능하도록 설정
// => 다른 패키지의 클래스에서 무조건 접근 불가능
// => 클래스, 필드, 메소드 선언시 접근 제한자 관련 키워드를 사용하지 않으면 자동 설정되는 접근 제한자

public class PackageMember {
	int num;
	
	void display() {
		System.out.println("num = "+num);
	}
}
