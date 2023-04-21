package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public ComponentAddApp(String title) {
		super(title);
		
		//Button 클래스 : 버튼 컴퍼넌트를 구현하기 위한 클래스
		// => Button 클래스의 Button(String label) 생성자로 버튼의 이름이 설정된 Button 객체 생성
		Button button=new Button("BUTTON");
		
		//Container.add(Component c) : 컨테이너에 컴퍼넌트를 배치하는 메소드
		// => 컨테이너에 설정된 배치관리자(LayoutManager)에 의해 컴퍼넌트가 출력 위치와 
		//크기가 자동 설정되어 컨테이너에 배치  
		add(button);
		
		setBounds(600, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("컴퍼넌트 배치");
	}
}






