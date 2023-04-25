package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//파일에 저장된 값을 문자데이타로 제공받아 모니터에 전달하여 출력하는 프로그램 작성
public class FileReaderApp {
	public static void main(String[] args) throws IOException {
		//FileReader 클래스 : 파일에 저장된 값을 문자데이타를 제공받기 위한 입력스트림을
		//생성하기 위한 클래스
		FileReader in=null;
		try {
			//FileReader 클래스의 FileReader(String name) 생성자를 이용하여 매개변수로
			//파일경로를 제공받아 파일 입력스트림을 생성
			// => 매개변수로 전달받은 파일경로의 파일이 없는 경우 FileNotFoundException 발생
			// => 파일이 없으면 파일 입력스트림을 생성할 수 없으므로 반드시 예외처리
			in=new FileReader("c:/data/char.txt");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]c:\\data\\char.txt 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		//OutputStreamWriter out=new OutputStreamWriter(System.out);
		PrintWriter out=new PrintWriter(System.out);
		
		System.out.println("[메세지]c:\\data\\char.txt 파일에 저장된 내용입니다.");
		
		int readByte;
		
		while(true) {
			readByte=in.read();
			
			if(readByte==-1) break;
			
			out.write(readByte);
			out.flush();
		}
		
		//FileReader.close() : 파일 입력스트림을 제거하는 메소드
		in.close();
	}
}
