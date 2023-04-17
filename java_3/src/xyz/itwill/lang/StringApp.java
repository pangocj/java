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
		//String.equals(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은
		//문자열을 비교하여 다른 경우 [false]를 반환하고 같은 경우 [true]를 반환하는 메소드
		// => 비교 문자열이 영문자인 경우 대소문자를 구분하여 비교
		if(str1.equals(str3)) {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 문자열이 같습니다.");			
		} else {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 문자열이 다릅니다.");			
		}
		System.out.println("==============================================================");
		String str4="abc";
		
		if(str1.equals(str4)) {
			System.out.println("str1 변수와 str4 변수에 저장된 String 객체의 문자열이 같습니다.");			
		} else {
			System.out.println("str1 변수와 str4 변수에 저장된 String 객체의 문자열이 다릅니다.");
		}
		System.out.println("==============================================================");
		//String.equalsIgnoreCase(String str) : String 객체에 저장된 문자열과 매개변수로 
		//전달받은 문자열을 비교하여 다른 경우 [false]를 반환하고 같은 경우 [true]를 반환하는
		//메소드 => 비교 문자열이 영문자인 경우 대소문자를 구분하지 않고 비교
		if(str1.equalsIgnoreCase(str4)) {
			System.out.println("str1 변수와 str4 변수에 저장된 String 객체의 문자열이 같습니다.");			
		} else {
			System.out.println("str1 변수와 str4 변수에 저장된 String 객체의 문자열이 다릅니다.");
		}
		System.out.println("==============================================================");
		//String.compareTo(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은
		//문자열을 비교하여 String 객체의 문자열이 큰 경우 양수를 반환하고 매개변수로 전달
		//받은 문자열이 큰 경우 음수를 반환하면 같은 경우 0를 반환하는 메소드		
		if(str1.compareTo(str4) > 0) {
			System.out.println("str1 변수에 저장된 문자열이 str4에 저장된 문자열보다 큽니다.");
		} else if(str1.compareTo(str4) < 0) {
			System.out.println("str1 변수에 저장된 문자열이 str4에 저장된 문자열보다 작습니다.");
		} else {
			System.out.println("str1 변수에 저장된 문자열과 str4에 저장된 문자열이 같습니다.");
		}
		System.out.println("==============================================================");
		//String.getBytes() : String 객체에 저장된 문자열을 byte 배열로 변환하여 반환하는 메소드
		// => byte 배열의 요소에는 문자열을 구성하는 문자들이 코드값(정수값)으로 차례대로 저장
		byte[] array=str1.getBytes();
		
		for(byte ch : array) {
			//System.out.print(ch);
			System.out.print((char)ch);//byte 배열의 요소값(정수값)을 문자로 형변환하여 출력
		}
		System.out.println();
		System.out.println("==============================================================");
		String str5="ABCDEFG";
		
		//String.length() : String 객체에 저장된 문자열의 문자 갯수를 반환하는 메소드
		System.out.println("문자열의 문자 갯수 = "+str5.length());
		System.out.println("==============================================================");
		//String.charAt(int index) : String 객체에 저장된 문자열에서 첨자(Index) 위치의
		//문자를 반환하는 메소드
		System.out.println("두번째 위치의 문자 = "+str5.charAt(1));
		System.out.println("==============================================================");
		//String.indexOf(String str) : String 객체에 저장된 문자열에서 매개변수로 전달받은
		//문자열(문자)을 처음부터 차례대로 검색하여 시작위치값(첨자)를 반환하는 메소드
		// => 매개변수로 전달받은 문자열을 찾을 수 없는 경우 -1 반환
		System.out.println("A 문자열의 저장 위치 = "+str5.indexOf("A"));
		System.out.println("EFG 문자열의 저장 위치 = "+str5.indexOf("EFG"));
		System.out.println("X 문자열의 저장 위치 = "+str5.indexOf("X"));
		System.out.println("==============================================================");
		String str6="Java Programming";
		
		System.out.println("str6 = "+str6);
		//String.toUpperCase() : String 객체에 저장된 문자열을 모두 대문자로 변환하여 반환하는 메소드
		System.out.println("str6.toUpperCase() = "+str6.toUpperCase());
		//String.toLowerCase() : String 객체에 저장된 문자열을 모두 소문자로 변환하여 반환하는 메소드
		System.out.println("str6.toLowerCase() = "+str6.toLowerCase());
		System.out.println("==============================================================");
		String str7="     홍길동      ";
		
		System.out.println("입력된 이름은 ["+str7+"]입니다.");
		//String.trim() : String 객체에 저장된 문자열에서 앞과 뒤에 존재하는 모든 공백을
		//제거하여 반환하는 메소드
		System.out.println("입력된 이름은 ["+str7.trim()+"]입니다.");
		System.out.println("==============================================================");
		String str8="   임    꺽     정      ";

		System.out.println("입력된 이름은 ["+str8+"]입니다.");
		//String.replace(String regEx, String replacement) : String 객체에 저장된 문자열에서
		//검색 문자열(정규표현식)을 찾아 치환 문자열로 변경하여 반환하는 메소드
		System.out.println("입력된 이름은 ["+str8.replace(" ", "").replace("꺽", "걱")+"]입니다.");
		System.out.println("==============================================================");
		String str9="010-1234-5678";
		
		System.out.println("전화번호 = "+str9);
		System.out.println("==============================================================");
		///String.split(String regEx) : String 객체에 저장된 문자열을 매개변수로 전달받은
		//문자열(구분자 : Delimiter - 정규표현식)로 구분 분리하여 문자열 배열로 반환하는 메소드
		// => 정규표현식에서 사용되는 메타문자를 일반문자로 변환하여 사용하기 위해 [\\]를 
		//사용하여 회피문자로 처리하여 표현
		String[] numArray=str9.split("-");
		//String[] numArray=str9.split("\\*");
		
		System.out.println("전화번호 앞부분 = "+numArray[0]);
		System.out.println("전화번호 중간부분 = "+numArray[1]);
		System.out.println("전화번호 뒷부분 = "+numArray[2]);
		System.out.println("==============================================================");
		//String.substring(int beginIndex, int endIndex) : String 객체에 저장된 문자열에서
		//시작첨자(문자포함)에서 종료첨자(문자미포함)까지의 문자열을 분리하여 반환하는 메소드
		System.out.println("전화번호 앞부분 = "+str9.substring(0, 3));
		System.out.println("전화번호 중간부분 = "+str9.substring(4, 8));
		//System.out.println("전화번호 뒷부분 = "+str9.substring(9, 13));
		//substring() 메소드 매개변수에 시작첨자만 전달하면 시작첨자의 문자로부터 문자열의
		//마지막 문자까지 분리하여 반환
		System.out.println("전화번호 뒷부분 = "+str9.substring(9));
		System.out.println("==============================================================");
		//String.valueOf(Object obj) : 매개변수로 전달된 모든 자료형의 값을 문자열(String 
		//객체)로 변환하여 반환하는 메소드
		//String numString=String.valueOf(100);
		//""+값 또는 값+"" 형식으로 모든 자료형의 값을 문자열과 결합하여 문자열로 사용 가능
		String numString=100+"";
		
		System.out.println("numString = "+numString);
		System.out.println("==============================================================");
	}
}
