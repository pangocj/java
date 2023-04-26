package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//문자데이타 기반의 스트림(Character Stream) : 원시데이타를 가공 처리한 문자데이타를 전달하기
//위한 입출력스트림
// => 원시데이타를 인코딩 처리하여 원하는 문자형태(캐릭터셋 - CharSet)의 문자데이타로 변환
// => 값을 2Byte 단위로 입력 또는 출력하기 위한 스트림
// => Reader 클래스와 Writer 클래스를 최상위 클래스로 관계가 설정된 클래스

//키보드로 문자데이타(2Byte)를 입력받아 모니터에 전달하여 출력하는 프로그램 작성 
//=> EOF(End Of File : 입력종료 - Ctrl+Z) 신호를 입력하면 프로그램 종료
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");

		//InputStreamReader 클래스 : InputStream 객체를 전달받아 문자데이타를 입력받기 위한
		//입력스트림(Reader 객체)를 생성하기 위한 클래스 - 스트림 확장
		InputStreamReader in=new InputStreamReader(System.in);
		
		//OutputStreamWriter 클래스 : OutputStream 객체를 전달받아 문자데이타를 출력하기 위한
		//출력스트림(Writer 객체)를 생성하기 위한 클래스 - 스트림 확장
		//OutputStreamWriter out=new OutputStreamWriter(System.out);
		
		//PrintWriter 클래스 : OutputStream 객체를 전달받아 문자데이타를 출력하기 위한
		//출력스트림(Writer 객체)를 생성하기 위한 클래스 
		// => OutputStreamWriter 클래스보다 많은 출력메소드 제공
		PrintWriter out=new PrintWriter(System.out);
		
		int readByte;
		
		while(true) {
			//Reader.read() : 입력스트림에 존재하는 값을 문자데이타(2Byte)로 읽어 
			//정수값(int)으로 반환하는 메소드
			readByte=in.read();
			
			if(readByte==-1) break;
			
			//Writer.write(int b) : 매개변수로 제공받은 값을 문자데이타(2Byte)로 
			//출력스트림에 전달하는 메소드
			// => 문자데이타는 출력스트림에 존재하는 버퍼(Buffer : 임시 메모리)에 일정한   
			//크기만큼 저장하고 한번에 출력스트림으로 전달하여 출력 처리
			out.write(readByte);
			
			//Writer.flush() : 출력스트림의 버퍼에 존재하는 모든 값을 출력스트림으로 전달하는 메소드
			out.flush();
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");

	}
}

