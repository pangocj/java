package xyz.itwill.awt;

import java.awt.Frame;

//GUI 프로그램을 UI 구성 및 이벤트 처리를 위해 Frame 클래스를 상속받아 작성하는 것을 권장
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	//생성자에서 프레임을 구성하는 디자인 설정 - UI 구현
	public FrameTwoApp(String title) {
		super(title);//Frame(String title) 생성자를 이용하여 Frame 객체 생성
		
		//Frame.setTitle(String title) : 프레임의 제목을 변경하는 메소드
		//setTitle(title);
		
		//Component.setBounds(int x, int y, int width, int height) : 컴퍼넌트의 출력 위치와
		//크기를 변경하는 메소드
		setBounds(600, 100, 400, 300);
		
		//Frame.setResizable(boolean resize) : 프레임의 크기 변경 여부를 설정하기 위한 메소드
		// => false : 프레임 크기 변경 불가능, true : 프레임 크기 변경 가능 - 기본
		//setResizable(false);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		//Frame 클래스를 상속받은 자식클래스로 객체 생성
		// => Frame 객체 생성 - 프레임 생성
		new FrameTwoApp("프레임 연습");
	}
}
