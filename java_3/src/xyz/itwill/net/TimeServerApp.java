package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버 프로그램 작성
// => NTP(Network Time Protocol) Server : 날짜와 시간을 제공하는 서버 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket 객체 생성 : 포트를 활성화하여 클라이언트가 접속할 수 있는 환경 제공
			ntpServer=new ServerSocket(2000);
			
			//ServerSocket.toString() : ServerSocket 객체에 저장된 접속 관련 정보를 문자열로
			//반환하는 메소드
			//System.out.println("ntpServer = "+ntpServer);
			
			System.out.println("[메세지]NTP Server Running...");
			
			//서버 프로그램에 다수의 클라이언트 접속을 허용하도록 무한루프 사용
			while(true) {
				//ServerSocket.accept() : 클라이언트가 접속되면 클라이언트와 값을 주고 받을
				//수 있는 Socket 객체를 반환하는 메소드
				// => 클라이언트가 접속되기 전까지 스레드가 일시 중지되며 클라이언트가 접속되면 
				//클라이언트의 소켓과 연결될 소켓을 생성하여 반환하고 스레드 재실행
				Socket socket=ntpServer.accept();
				
				//System.out.println("socket = "+socket);
				
				/**
				//Socket.getOutputStream() : Socket 객체의 출력스트림(OutputStream 객체)을 
				//반환하는 메소드 
				OutputStream stream=socket.getOutputStream();

				//OutputStream 객체를 전달받아 객체를 전달할 수 있는 출력스트림으로 확장
				ObjectOutputStream out=new ObjectOutputStream(stream);
				
				//출력스트림을 이용하여 시스템의 현재 날짜와 시간이 저장된 Date 객체를 생성
				//하여 전달 - 클라이언트에게 날짜와 시간을 전송
				out.writeObject(new Date());
				*/
				
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그 처리 - 기록
				//Socket.getInetAddress() : 소켓과 연결된 외부 컴퓨터의 네트워크 식별자가  
				//저장된 InetAddress 객체를 반환하는 메소드
				System.out.println("[정보]클라이언트["+socket.getInetAddress()
					.getHostAddress()+"]에게 날짜와 시간을 제공 하였습니다.");
				
				//클라이언트와의 접속 해제
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생 되었습니다.");
		}
	}
}
