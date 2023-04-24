package xyz.itwill.swing;

import javax.swing.JFrame;

//javax.swing 패키지의 클래스를 이용하여 GUI 프로그램을 작성하는 방법 - AWT와 다른점
//1.java.awt 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스 대신 javax.swing 패키지의 컴퍼넌트와
//컨테이너 관련 클래스를 사용하여 UI 구현
// => AWT 컴퍼넌트(컨테이너) 관련 클래스 이름 앞에 J를 붙이면 SWING 컴퍼넌트와 동일
//2.프레임의 [닫기]를 누른 경우 동작되는 기능을 기본적으로 제공
// => JFrame.setDefaultCloseOperation(int operation) 메소드를 호출하여 프레임의 [닫기]를 
//누른 경우되는 동작되는 기능을 변경 가능 
// => operation 매개변수에서는 WindowConstants 클래스의 상수 전달
// => DO_NOTHING_ON_CLOSE
// => HIDE_ON_CLOSE
// => DISPOSE_ON_CLOSE
// => EXIT_ON_CLOSE 

public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public SwingApp(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}
}





