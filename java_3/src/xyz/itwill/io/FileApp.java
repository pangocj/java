package xyz.itwill.io;

import java.io.File;

//File 클래스 : 파일(디렉토리 - 폴더) 관련 정보를 저장하기 위한 클래스
public class FileApp {
	public static void main(String[] args) {
		//File 클래스의 File(String pathname) 생성자를 이용하여 매개변수로 시스템(OS - 운영체제)의
		//파일경로를 전달받아 File 객체 생성
		// => 파일경로 : 시스템에 존재하는 파일 위치를 표현하는 방법 - 절대경로 표현방법, 상대경로 표현방법
		//절대경로 표현방법 : 파일경로를 최상위 디랙토리를 기준으로 파일 위치를 표현하는 방법
		//상대경로 표현방법 : 현재 실행 프로그램의 작업 디렉토리를 기준으로 파일 위치를 표현하는 방법
		// => 이클립스에서는 프로젝트 폴더를 작업 디렉토리로 처리
		//Windows 운영체제에서는 폴더(드라이브)와 파일을 구분하기 위한 \ 기호 사용
		// => Java에서는 \ 기로가 회피문자(Escape Character)를 표현하는 용도로 사용
		// => \ 기호를 문자로 사용하기 위해 \\ 형태의 회피문자로 표현
		File fileOne=new File("c:\\data");
		
		//File.exists() : File 객체에 저장된 파일경로의 파일(디렉토리)이 시스템에 존재하지
		//않을 경우 [false]를 반환하고 존재할 경우 [true]를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더가 이미 존재합니다.");
		} else {
			//
			fileOne.mkdir();
			System.out.println("c:\\data 폴더를 생성 하였습니다.");
		}
		System.out.println("==============================================================");
	}
}










