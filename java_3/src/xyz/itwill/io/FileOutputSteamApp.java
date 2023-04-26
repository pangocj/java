package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드로 입력된 값을 원시데이타로 제공받아 파일로 전달하여 저장하는 프로그램 작성
// => EOF(End Of File : 입력종료 - Ctrl+Z) 신호를 입력하면 프로그램 종료
public class FileOutputSteamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");
		
		//FileOutputStream 클래스 : 파일에 원시데이타를 전달하기 위한 출력스트림을 생성하기 위한 클래스
		// => FileOutputStream 클래스의 FileOutputStream(String name) 생성자를 이용하여 
		//매개변수로 파일경로를 전달받아 파일 출력스트림 생성
		// => 매개변수로 전달받은 파일경로의 파일이 없는 경우 FileNotFoundException 발생
		// => 예외처리를 하지 않고 예외를 전달할 경우 매개변수로 전달받은 파일경로의 파일을 
		//JVM이 자동으로 생성하여 출력스트림 제공
		// => 매개변수로 전달받은 파일경로의 파일이 있는 경우 기존 파일의 내용 대신 새로운
		//내용이 파일에 저장 - 덮어씌우기(OverWrite)
		//FileOutputStream out=new FileOutputStream("c:/data/byte.txt");

		//FileOutputStream 클래스의 FileOutputStream(String name, boolean append) 생성자를 
		//이용하여 매개변수로 파일경로와 내용 추가에 대한 상태값을 전달받아 파일 출력스트림 생성
		// => false : 파일 내용 덮어씌우기(기본), true : 파일 내용 이어쓰기 
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt",true);
		
		int readByte;
		
		while(true) {
			//키보드 입력스트림에 존재하는 입력값을 원시데이타로 반환받아 저장
			readByte=System.in.read();
			
			if(readByte==-1) break;
			
			//파일 출력스트림으로 원시데이타를 전달하여 저장 - SAVE
			out.write(readByte);
		}
		
		//FileOutputStream.close() : 파일 출력스트림을 제거하는 메소드
		// => 파일에는 입력스트림과 출력스트림을 하나씩만 생성 가능
		out.close();
		
		System.out.println("c:\\data\\byte.txt 파일을 확인해 보세요.");
	}
}
