package basic;

//리터럴(Literal) : 프로그램에서 사용하기 위해 표현되는 값(Value)
//변수(Variable) : 리터럴(값)을 저장하기 위해 메모리(Memory)에 부여된 이름(식별자)

//변수 선언 - 메모리에 변수 생성
//형식)자료형 변수명;
// => 자료형(DataType) : 변수에 저장될 리터럴의 형태 - 원시형(PrimitiveType) 또는 참조형(ReferenceType)
// => 변수명 : 리터럴을 저장하기 위한 메모리 영역을 구분하기 위해 사용되는 식별자(Identifier)

//예약어(키워드) : Java 프로그램을 개발하기 위해 미리 정해져 있는 단어
//사용자 정의 명칭(식별자) : Java 프로그램 개발을 위해 프로그래머 정의하여 사용하는 단어  

//식별자 작성 규칙
// => 영문자, 숫자, 특수문자(_ 또는 $)를 조합하여 작성 - Java에서는 한글을 식별자로 사용 가능
// => 숫자로 시작되도록 작성 불가능
// => 영문자는 대소문자를 구분하여 작성
// => 기존에 사용된 단어(키워드 또는 식별자)로 식별자 선언 불가능

//Java에서 사용되는 식별자 작성 방법 - 표기법 : 영문자의 소문자를 기본으로 식별자 작성
// => 파스칼 표기법(PascalCase) : 조합된 단어의 첫문자를 대문자로 표현하여 작성 - 클래스명, 인터페이스명 등
// => 카멜 표기법(CamelCase) : 첫번째 단어를 제외한 나머지 단어의 첫문자를 대문자로 표현하여 작성 - 변수명, 메소드명 등
// => 스네이크 표기법(SnakeCase) : 조합된 단어를 _로 구분하여 작성 - 상수(Constant : 상수명은 무조건 대문자로 작성)

public class VariableApp {
	public static void main(String[] args) {
		int su;//정수값을 저장하기 위한 변수 선언(생성)
		//값을 저장하기 위한 변수는 대입연산자 왼쪽에 반드시 작성
		su=100;//대입연산자(=)를 이용하여 값을 변수에 저장 - 입력
		System.out.print("초기값 = ");
		System.out.println(su);//변수에 저장된 값을 화면에 출력
		
		//int su;//동일한 이름의 변수를 재선언할 경우 에러 발생
		su=200;//변수에 기존값 대신 새로운 값 저장
		System.out.print("변경값 = ");
		System.out.println(su);
		
		System.out.println("==============================================================");
		int num=100;//변수 선언 및 초기값 저장
		
		//"문자열"+값 또는 값+"문자열" >> 문자열과 값이 결합 - 결과값 : 문자열 
		System.out.println("num = "+num);
		System.out.println("==============================================================");
		System.out.println("올해는 "+2+0+2+3+"년입니다.");
		System.out.println(2+0+2+3+"년은 토끼띠해입니다.");//잘못된 결과 발생 - 실행 오류
		//"" : 비어있는 문자열 - NullString
		System.out.println(""+2+0+2+3+"년은 토끼띠해입니다.");
		System.out.println("==============================================================");
		//동일한 자료형의 변수는 , 기호를 사용하여 나열 선언 가능
		int num1=100, num2=200;
		System.out.println("연산결과 = "+num1+num2);//잘못된 결과 발생 - 실행 오류
		System.out.println("연산결과 = "+(num1+num2));
		System.out.println("연산결과 = "+num1*num2);
		System.out.println("연산결과 = "+(num1*num2));
		System.out.println("==============================================================");
		int kor=88,eng=90;
		//int tot=88+90;
		int tot=kor+eng;//연산 결과를 변수에 저장
		System.out.println("점수 합계 = "+tot);
		System.out.println("==============================================================");
		//변수에 값이 저장되어 있지 않은 상태에서 변수를 사용할 경우 에러 발생
		//int count;
		//System.out.println("count = "+count);
		
		//변수에 저장 불가능한 값을 저장할 경우 에러 발생
		//int count=10.0;
		//System.out.println("count = "+count);
	}
}
