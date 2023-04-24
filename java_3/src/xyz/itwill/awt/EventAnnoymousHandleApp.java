package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

public class EventAnnoymousHandleApp extends Frame {
private static final long serialVersionUID = 1L;
	
	public EventAnnoymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");//이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnnoymousHandleApp("이벤트처리");
	}
}
