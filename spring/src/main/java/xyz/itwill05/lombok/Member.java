package xyz.itwill05.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//클래스 작성에 필요한 메소드를 자동으로 생성해주는 Lombok 라이브러리를 사용하는 방법
//1.Lombok 라이브러리를 프로젝트 빌드 처리 - 메이븐 사용 : pom.xml
//2.이클립스(IDE)를 종료하고 콘솔(명령 프롬프트 - cmd)를 관리자 권한으로 실행한 후 Lombok 라이브러리가
//저장된 로컬 저장소(Local Repository - 사용자 폴더의 .m2 폴더)의 라이브러리 폴더로 이동
//3.콘솔에서 Jar 프로그램 실행하여 Lombok 라이브러리를 이클립스에 사용할 수 있도록 설정
// => Jar 프로그램 실행 방법 : java -jar lombok-1.18.28.jar
// => 탐색기에서 로컬 저장소의 라이브러리 폴더로 이동하여 Jar 파일을 더블클릭하여 실행 가능
//4.Jar 프로그램을 실행하여 제공된 설치창(Installer)에서 Lombok 라이브러리를 사용할 이클립스를 선택하여 Lombok 설치 
// => 이클립스를 자동으로 찾을 수 없는 경우 이클립스가 설치된 폴더를 선택하여 Lombok 설치
//5.이클립스를 실행하여 클래스를 작성할 때 Lombok 라이브러리가 제공하는 어노테이션 사용하여 확인
// => @Setter, @Getter, @ToString, @Date, @AllArgsConstructor, @RequiredArgsConstructor 등
// => 이클립스가 실행되지 않는 경우 이클립스 설치 폴더로 이동하여 eclipse.ini 파일 변경 
// => eclipse.ini 파일에서 javaagent 속성의 lombok 경로를 절대경로에서 상대경로로 변경 => -javaagent:lmbok.jar    

//@NoArgsConstructor : 매개변수가 없는 생성자를 자동 생성하여 제공하는 어노테이션
//@AllArgsConstructor : 매개변수가 있는 생성자를 자동 생성하여 제공하는 어노테이션
// => 모든 필드에 초기값을 저장할 수 있는 매개변수가 있는 생성자 생성 
//@RequiredArgsConstructor : 매개변수가 있는 생성자를 자동 생성하여 제공하는 어노테이션
// => final 제한자를 사용하여 선언된 필드에 초기값을 저장할 수 있는 매개변수가 있는 생성자 생성 
// => @NoArgsConstructor 어노테이션과 같이 사용 불가능
//@Setter : 클래스에 선언된 모든 필드에 대한 Setter 메소드를 자동 생성하여 제공하는 어노테이션
// => 필드에 @Setter 어노테이션을 사용하면 해당 필드에 대한 Setter 메소드만을 자동 생성하여 제공
//@Getter : 클래스에 선언된 모든 필드에 대한 Getter 메소드를 자동 생성하여 제공하는 어노테이션
//=> 필드에 @Getter 어노테이션을 사용하면 해당 필드에 대한 Getter 메소드만을 자동 생성하여 제공
//@ToString : 클래스에 toString() 메소드를 자동 생성하여 제공하는 어노테이션
// => 클래스에 선언된 모든 필드값을 문자열로 반환하는 기능 제공 - 필드값 확인을 목적으로 작성
//@Data : 기본 생성자, Setter 메소드, Getter 메소드, toString() 메소드, equals() 메소드
//, hashCode() 메소드를 자동 생성하여 제공하는 어노테이션
//@Builder : 클래스 내부에 Builder 클래스를 자동 생성하여 제공하는 어노테이션
// => Builder 클래스 : 객체 생성시 객체 필드에 필요한 값을 저장하기 위한 메소드를 제공하는 클래스 
// => 생성자 보다 가독성 좋으며 필드의 순서에 상관없이 필드 초기화 작업 편리
// => 매개변수가 선언된 생성자에 @Builder 어노테이션을 사용하면 생성자 매개변수로 초기화 처리하기
//위한 필드에만 값을 저장할 수 있는 메소드 제공
//@Slf4j : 로그 이벤트를 발생하는 Logger 객체가 저장된 필드(필드명 : log)를 자동 생성하여 제공하는 어노테이션  

@AllArgsConstructor
@Builder
@Data
public class Member {
	private String id;
	private String name;
	private String email;
}









