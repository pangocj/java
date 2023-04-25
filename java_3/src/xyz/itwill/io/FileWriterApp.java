package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드로 입력된 값을 문자데이타로 제공받아 파일로 전달하여 저장하는 프로그램 작성
// => EOF(End Of File : 입력종료 - Ctrl+Z) 신호를 입력하면 프로그램 종료
public class FileWriterApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");

		//키보드 입력스트림을 InputStreamReader 클래스의 입력스트림으로 확장
		// => 원시데이타가 아닌 문자데이타를 입력받기 위한 입력스트림
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter 클래스 : 파일에 문자데이타를 전달하기 위한 출력스트림을 생성하기 위한 클래스
		// => FileWriter 클래스의 FileWriter(String name) 생성자를 이용하여  매개변수로 
		//파일경로를 전달받아 파일 출력스트림 생성
		// => 매개변수로 전달받은 파일경로의 파일이 없는 경우 FileNotFoundException 발생
		// => 예외처리를 하지 않고 예외를 전달할 경우 매개변수로 전달받은 파일경로의 파일을 
		//자동으로 생성하여 출력스트림 제공
		// => 매개변수로 전달받은 파일경로의 파일이 있는 경우 기존 파일의 내용 대신 새로운
		//내용이 파일에 저장 - 덮어씌우기(OverWrite)
		//FileWriter out=new FileWriter("c:/data/char.txt");
		FileWriter out=new FileWriter("c:/data/char.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=in.read();
			
			if(readByte==-1) break;
			
			out.write(readByte);
		}
		
		//FileWriter.close() : 파일 출력스트림을 제거하는 메소드
		out.close();
	
		System.out.println("c:\\data\\char.txt 파일을 확인해 보세요.");
	}
}














