package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP 프로그램 : DatagramSocket 클래스와 DatagramPacket 클래스를 이용하여 작성
// => 값을 전달하는 컴퓨터와 값을 전달받는 컴퓨터로 구분하여 처리

//키보드로 메세지를 입력받아 다른 컴퓨터에게 전달하는 UDP 프로그램 작성
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		//DatagramSocket 클래스 : 다른 컴퓨터와 연결하기 위한 정보를 저장하기 위한 클래스
		// => 다른 컴퓨터로 데이타를 보내기 위해 DatagramSocket 클래스의 기본 생성자로 객체 생성
		DatagramSocket socket=new DatagramSocket();
		
		//연결할 컴퓨터의 네트워크 식별자가 저장된 InetAddress 객체를 반환받아 저장
		InetAddress address=InetAddress.getByName("192.168.13.31");
		
		//String.getBytes() : String 객체에 저장된 문자열을 byte 배열로 변환하여 반환하는 메소드
		byte[] data=message.getBytes();
		
		//DatagramPacket 클래스 : 연결 컴퓨터에게 보낼 패킷정보를 저장하기 위한 클래스
		// => DatagramPacket 클래스의 DatagramPacket(byte[] data, int length, InetAddress address, int port)
		//생성자를 사용하여 데이타를 보내기 위한 패킷정보가 저장된 DatagramPacket 객체 생성
		DatagramPacket packet=new DatagramPacket(data, data.length, address, 4000);
		
		//DatagramSocket.send(DatagramPacket packet) : 매개변수로 전달받은 DatagramPacket 
		//객체의 패킷정보를 이용하여 데이타(패킷)를 전달하는 메소드
		socket.send(packet);
		
		//DatagramSocket.close() : DatagramSocket 객체를 제거하는 메소드
		socket.close();
		
		System.out.println("[결과]연결 컴퓨터에게 메세지를 보냈습니다.");
	}
}
