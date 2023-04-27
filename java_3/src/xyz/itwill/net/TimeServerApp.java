package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
				
				System.out.println("socket = "+socket);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}












