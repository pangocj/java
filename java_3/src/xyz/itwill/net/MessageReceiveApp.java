package xyz.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//다른 컴퓨터에서 보내온 메세지를 얻어와 출력하는 UDP 프로그램 작성
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		//다른 컴퓨터에서 보내온 데이타를 전달받기 위한 DatagramSocket 객체 생성 
		// => DatagramSocket 클래스의 DatagramSocket(int port) 생성자를 사용하여 포트를
		//활성화 처리하여 데이타를 받기 위한 DatagramSocket 객체 생성
		DatagramSocket socket=new DatagramSocket(4000);
		
		//전달받은 값(메세지)을 저장하기 위한 byte 배열 선언 
		byte[] data=new byte[1024];
		
		//연결 컴퓨터에서 보내온 값을 byte 배열에 저장하기 위한 DatagramPacket 객체 생성
		// => DatagramPacket 클래스의 DatagramPacket(byte[] buf, int length) 생성자를
		//이용하여 DatagramPacket 객체 생성
		DatagramPacket packet=new DatagramPacket(data, data.length);
		
		System.out.println("메세지 수신중...");
		
		//DatagramSocket.receive(DatagramPacket packet) : 연결 컴퓨터에서 보내온 값을 
		//얻어와 DatagramPacket 객체의 byte 배열에 저장하기 위한 메소드 
		// => 패킷을 받기 전까지 스레드 일시 중지
		socket.receive(packet);
		
		//byte 배열에 저장된 원시데이타를 문자열로 변환하여 저장
		String message=new String(data);
		
		System.out.println("[결과]메세지 = "+message);
		
		socket.close();
	}
}
