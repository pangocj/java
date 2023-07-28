package xyz.itwill05.lombok;

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
// => eclipse.ini 파일에서 javaagent 속성의 lombok 경로를 절대경로에서 상대경로로 변경 -javaagent:lmbok.jar    

@Data
public class Member {
	private String id;
	private String name;
	private String email;
}









