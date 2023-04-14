package xyz.itwill.lang;

//String 클래스 : 문자열을 저장하기 위한 클래스
// => String 객체에 저장된 문자열에 대한 다양한 기능을 메소드로 제공
// => String 객체는 문자열을 내부적으로 byte 배열로 처리하여 배열 요소에 문자를 하나씩 저장
public class StringApp {
	public static void main(String[] args) {
		//문자열을 " " 기호를 사용하여 표현하면 자동으로 메모리의 메소드영역(MethodArea)에 
		//String 객체를 생성하여 String 객체에 문자열 저장
		// => 메모리의 메소드영역에는 동일한 문자열이 저장된 String 객체를 생성 불가능
		String str1="ABC";//String 객체를 생성하여 참조변수에 메모리 주소 저장
		
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		System.out.println("str1.toString() = "+str1.toString());
		//참조변수를 출력할 경우 자동으로 toString() 메소드 호출
		System.out.println("str1 = "+str1);
		System.out.println("==============================================================");
		//" " 기호로 String 객체를 표현할 경우 동일한 문자열의 String 객체는 생성하지 않고
		//기존에 생성된 String 객체를 재활용하여 사용
		String str2="ABC";//기존의 String 객체의 메모리 주소를 제공받아 변수에 저장
		
		//참조변수를 비교연산자로 비교할 경우 참조변수에 저장된 객체의 메모리 주소를 비교
		// => String 객체에 저장된 문자열을 비교하는 것이 아니라 String 객체의 메모리 주소 비교
		if(str1 == str2) {
			System.out.println("str1 변수와 str2 변수에 저장된 String 객체의 메모리 주소가 같습니다.");
		} else {
			System.out.println("str1 변수와 str2 변수에 저장된 String 객체의 메모리 주소가 다릅니다.");
		}
		System.out.println("==============================================================");
		//new 연산자로 생성자를 호출하여 String 객체를 생성하면 메모리의 힙영역(HeapArea)에
		//새로운 String 객체를 생성하여 사용
		String str3=new String("ABC");
		
		if(str1 == str3) {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 메모리 주소가 같습니다.");
		} else {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 메모리 주소가 다릅니다.");
		}
		System.out.println("==============================================================");
		
		
	}
}















