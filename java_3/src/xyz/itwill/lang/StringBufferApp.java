package xyz.itwill.lang;

//StringBuffer 클래스 : 문자열을 저장하기 위한 클래스
// => String 객체는 저장된 문자열을 조작하기 위한 메소드를 제공하지 않고 조작결과를 반환하는
//메소드 제공 - 문자열 간접 처리
// => StringBuffer 객체에 저장된 문자열을 조작하기 위한 메소드 제공 - 문자열 직접 처리
// => String 클래스보다 StringBuffer 클래스의 메소드가 문자열 처리 속도가 우수
public class StringBufferApp {
	public static void main(String[] args) {
		//StringBuffer 클래스는 new 연산자로 생성자를 호출하여 객체 생성
		StringBuffer sb=new StringBuffer("ABC");
		
		//StringBuffer.toString() : StringBuffer 객체에 저장된 문자열(String 객체)을 반환하는 메소드
		System.out.println("sb.toString() = "+sb.toString());
		//StringBuffer 객체가 저장된 참조변수를 출력할 경우 toString 메소드 자동 호출
		System.out.println("sb = "+sb);//ABC
		
		//StringBuffer 객체에 저장된 문자열을 반환받아 String 객체로 생성하여 참조변수 저장
		String str=sb.toString();//StringBuffer 객체 >> String 객체
		System.out.println("str = "+str);
		System.out.println("==============================================================");
		//StringBuffer.append(Object o) : StringBuffer 객체에 저장된 문자열에 매개변수로
		//전달받은 값을 추가하는 메소드
		// => String 객체에 저장된 문자열에 += 연산자를 사용한 효과와 동일
		sb.append("DEF");
		System.out.println("sb = "+sb);//ABCDEF
		
		str+="DEF";
		System.out.println("str = "+str);
		System.out.println("==============================================================");
		//StringBuffer.insert(int index, Object o) : StringBuffer 객체에 저장된 문자열에 
		//매개변수로 전달받은 값을 원하는 위치(첨자)에 삽입하는 메소드
		sb.insert(4, "X");
		System.out.println("sb = "+sb);//ABCDXEF
		System.out.println("==============================================================");
		//StringBuffer.deleteCharAt(int index) : StringBuffer 객체에 저장된 문자열에서 
		//매개변수로 전달받은 위치(첨자)의 문자를 제거하는 메소드
		sb.deleteCharAt(2);
		System.out.println("sb = "+sb);//ABDXEF
		System.out.println("==============================================================");
		//StringBuffer.delete(int beginIndex, int endIndex) : StringBuffer 객체에 저장된 
		//문자열에서 매개변수로 전달받은 시작첨자부터 종료첨자 범위의 문자열을 제거하는 메소드
		sb.delete(4, 6);
		System.out.println("sb = "+sb);//ABDX
		System.out.println("==============================================================");
		//StringBuffer.reverse() : StringBuffer 객체에 저장된 문자열의 문자를 역순으로 
		//나열되도록 저장하는 메소드
		sb.reverse();
		System.out.println("sb = "+sb);//XDBA
		System.out.println("==============================================================");
	}
}
