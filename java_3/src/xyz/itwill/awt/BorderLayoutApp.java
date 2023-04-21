package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//BorderLayout 클래스 : 컨테이너를 중앙, 동, 서, 남, 북으로 구분하여 컴퍼넌트를 배치하는 배치관리자
// => 컴퍼넌트를 배치할 때 반드시 배치위치를 제공
// => Frame, Window, Dialog 등의 컨테이너의 기본 배치관리자
public class BorderLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public BorderLayoutApp(String title) {
		super(title);
		
		//프레임의 배치관리자를 [BorderLayout]으로 변경
		// => Frame의 기본 배치관리자는 [BorderLayout]이므로 배치관리자 변경 생략 가능
		//setLayout(new BorderLayout());
		
		Button button1=new Button("Center");
		Button button2=new Button("East");
		Button button3=new Button("West");
		Button button4=new Button("South");
		Button button5=new Button("North");
		
		//Container.add(Component c, Object constraints) : 컴퍼넌트를 컨테이너의 원하는 위치에
		//배치하는 메소드 - 배치관리자가 [BorderLayout]인 경우에만 사용
		// => 컴퍼넌트가 배치되는 위치는 BorderLayout 클래스의 상수(Constant) 사용
		// => 컨테이너의 중앙에는 반드시 컴퍼넌트를 배치해야 되지만 동서남북은 생략 가능
		add(button1, BorderLayout.CENTER);
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.WEST);
		add(button4, BorderLayout.SOUTH);
		add(button5, BorderLayout.NORTH);
		
		setBounds(600, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayout");
	}
}
