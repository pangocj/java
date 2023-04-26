package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//파일에 저장된 값을 원시데이타로 제공받아 모니터에 전달하여 출력하는 프로그램 작성
public class FileInputStreamApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream 클래스 : 파일에 저장된 값을 원시데이타를 제공받기 위한 입력스트림을
		//생성하기 위한 클래스
		FileInputStream in=null;
		try {
			//FileInputStream 클래스의 FileInputStream(String name) 생성자를 이용하여 매개변수로
			//파일경로를 제공받아 파일 입력스트림을 생성
			// => 매개변수로 전달받은 파일경로의 파일이 없는 경우 FileNotFoundException 발생
			// => 파일이 없으면 파일 입력스트림을 생성할 수 없으므로 반드시 예외처리
			in=new FileInputStream("c:/data/byte.txt");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]c:\\data\\byte.txt 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]c:\\data\\byte.txt 파일에 저장된 내용입니다.");
		
		int readByte;
		
		while(true) {
			//파일 입력스트림을 이용하여 파일에 저장된 값을 원시데이타로 반환받아 저장 - LOAD
			readByte=in.read();
			
			//파일 입력스트림로 제공받을 파일 내용이 없는 경우 반복문 종료
			if(readByte==-1) break;
			
			//원시데이타를 모니터 출력스트림으로 전달하여 출력
			System.out.write(readByte);
		}
		
		//FileInputStream.close() : 파일 입력스트림을 제거하는 메소드
		in.close();
	}
}
