package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ObjectInputStreamApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//ObjectInputStream 클래스 : InputStream 객체를 전달받아 원시데이타를 Java 객체로  
		//제공받기 위한 입력스트림을 생성하기 위한 클래스
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/object.txt"));
		
		//ObjectInputStream.readObject() : 입력스트림으로 원시데이타를 제공받아 Java 객체로
		//변환하여 반환하는 메소드
		// => Object 타입의 객체로 반환되므로 반드시 명시적 객체 형변환 사용
		// => 반환되는 객체에 대한 클래스가 없는 경우 ClassNotFoundException 발생
		String string=(String)in.readObject();
		Date date=(Date)in.readObject();
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)in.readObject();
		
		System.out.println("string = "+string);
		System.out.println("date = "+date);
		System.out.println("list = "+list);
		
		in.close();
	}
}
