package oop;

public class MemberApp {
	public static void main(String[] args) {
		//new 연산자로 Member 클래스의 매개변수가 없는 기본 생성자를 호출하여 객체 생성 
		// => 생성된 객체의 필드에는 기본값이 초기값으로 자동 저장
		// => new 연산자로 호출한 생성자가 없는 경우 에러 발생 - 객체 생성 불가능
		Member member1=new Member();
		
		//Getter 메소드를 호출하여 Member 객체의 필드값을 반환받아 출력
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		System.out.println("==============================================================");
		//Setter 메소드를 호출하여 Member 객체의 필드값 변경
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		
		/*
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		*/
		member1.display();
		System.out.println("==============================================================");
		//new 연산자로 매개변수가 있는 생성자를 호출하여 객체 생성
		Member member2=new Member("def456");
		member2.display();
		System.out.println("==============================================================");
		Member member3=new Member("ghj789", "임꺽정");
		member3.display();
		System.out.println("==============================================================");
		Member member4=new Member("xyz258", "전우치", "xyz@itwill.xyz");
		member4.display();
		System.out.println("==============================================================");
	}
}
