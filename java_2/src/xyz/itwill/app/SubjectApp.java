package xyz.itwill.app;

//패키지(Package) : 같은 목적의 자료형(참조형)을 명확하게 구분하여 그룹화 하기 위한 폴더
// => Java 참조형 : 클래스(Class), 인터페이스(Interface), 열거형(Enum)
// => Java 자료형을 보다 쉽게 관리하기 위해 패키지 사용
// => 패키지의 이름은 도메인을 역방향으로 나열하고 그룹명을 지정하여 작성하는 것을 권장
//ex) itwill.xyz : 도메인 >> xyz.itwill.board
//도메인(Domain) : 인터넷에서 개인 또는 그룹이 사용하기 위한 네트워크 식별자

//패키지에 작성된 소스파일의 처음 위치에는 소스파일이 작성된 패키지를 반드시 명확하게 작성
//형식) package 패키지경로;
// => Java 자료형이 어떤 패키지에서 선언된 자료형인지를 명확하게 구분하여 사용

//import 키워드 : 다른 패키지에 작성된 Java 자료형을 명확히 표현하여 접근하기 위한 키워드
//형식) import 패키지경로.자료형;   >> 자료형 대신 *(전체) 사용 가능
// => package 키워드로 작성된 명령 하단에 선언하며 자료형 위에 선언
//이클립스에서는 다른 패키지에 작성된 자료형을 사용할 경우 import 명령을 자동 완성하는 기능 
//제공 - [Ctrl]+[Space] => 같은 이름의 자료형이 여러개인 경우 선택
// => [Ctrl]+[Shift]+[O] >> import 명령을 정리하는 단축키 : 불필요한 자료형에 대한 import
//설정을 제거하거나 필요한 자료형에 대한 import 설정을 추가하는 기능 제공
import xyz.itwill.subject.OracleSubject;
import xyz.itwill.subject.JavaSubject;
//자료형의 이름이 같은 경우 import 처리 불가능
//import xyz.uniwill.subject.JavaSubject;

public class SubjectApp {
	public static void main(String[] args) {
		//같은 패키지에 작성된 클래스는 패키지 경로 표현 없이 클래스 접근 가능
		// => 형식) 클래스명
		//다른 패키지에 작성된 클래스는 반드시 패키지 경로를 표현해야만 클래스 접근 가능
		// => 형식) 패키지경로.클래스명
		//xyz.itwill.subject.OracleSubject subject1=new xyz.itwill.subject.OracleSubject();
		
		//다른 패키지에 작성된 클래스를 import 처리한 경우 패키지 경로 표현없이 클래스 접근 가능
		OracleSubject subject1=new OracleSubject();
		subject1.display();
		
		JavaSubject subject2=new JavaSubject();
		subject2.display();
		
		//import 설정이 불가능 자료형은 패키지 경로를 반드시 표현해야만 접근 가능
		xyz.uniwill.subject.JavaSubject subject3=new xyz.uniwill.subject.JavaSubject();
		subject3.display();
	}
}



