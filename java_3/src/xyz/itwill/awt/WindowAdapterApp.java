package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//프레임의 [닫기]를 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
// => 프레임에서는 WindowEvent 발생 - WindowAdapter 클래스를 상속받은 자식클래스로 이벤트 처리
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowEventHandleTwo());
		
		//프레임의 [닫기]를 누른 경우 프로그램을 종료하는 기능의 명령 - 익명의 내부클래스 사용
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("윈도우 이벤트");
	}

	/*
	//Adapter 클래스를 상속받은 자식클래스(이벤트 처리 클래스)는 필요한 메소드만 오버라이드 선언
	//Adapter 클래스 : Listener 인터페이스 중 추상메소드가 2개이상 선언된 경우 Listener 
	//인터페이스 대신 이벤트 처리 위해 제공하는 클래스
	public class WindowEventHandleTwo extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	*/
}
