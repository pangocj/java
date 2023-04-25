package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//ObjectOutputStream 클래스 : OutputStream 객체를 전달받아 Java 객체를 원시데이터로
		//전달하는 출력스트림을 생성하기 위한 클래스
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object o) : 매개변수로 전달받은 객체를 원시데이타로
		//변환하여 출력스트림으로 전달하는 메소드
		out.writeObject("홍길동");//String 객체
		out.writeObject(new Date());//Date 객체
		out.writeObject(Arrays.asList("임꺽정","전우치","일지매","장길산"));//List 객체
		
		out.close();
		
		System.out.println("c:\\data\\object.txt 파일을 확인해 보세요.");	
	}
}
