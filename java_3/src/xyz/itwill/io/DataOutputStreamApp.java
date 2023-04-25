package xyz.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataOutputStream 클래스 : OutputStream 객체를 전달받아 원하는 자료형의 값을 원시
		//데이타로 전달하기 위한 기능의 출력스트림을 생성하기 위한 클래스
		DataOutputStream out=new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int v) : 매개변수로 정수값을 전달받아 원시데이타로 변환
		//하여 출력스트림으로 전달하는 메소드
		out.writeInt(100);
		
		//DataOutputStream.writeBoolean(boolean v) : 매개변수로 논리값을 전달받아 원시데이타로
		//변환하여 출력스트림으로 전달하는 메소드
		out.writeBoolean(true);
		
		//DataOutputStream.writeUTF(String v) : 매개변수로 문자열을 전달받아 원시데이타로
		//변환하여 출력스트림으로 전달하는 메소드
		out.writeUTF("홍길동");
		
		out.close();
		
		System.out.println("c:\\data\\data.txt 파일을 확인해 보세요.");
	}
}
