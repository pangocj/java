package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//색상 버튼을 누르면 캔버스의 배경색을 변경하는 프로그램 작성
public class EventSourceGetApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	//이벤트 처리 클래스의 메소드에서 사용될 컴퍼넌트 또는 컨테이너는 필드 선언
	// => 이벤트 처리 클래스의 이벤트 처리 메소드에서 필드를 사용하여 이벤트 처리 가능
	Button red, green, blue, white;
	Canvas canvas;
	
	public EventSourceGetApp(String title) {
		super(title);
		
		red=new Button("RED");
		green=new Button("GREEN");
		blue=new Button("BLUE");
		white=new Button("WHITE");

		canvas=new Canvas();
		
		Panel panel=new Panel();
		panel.setLayout(new GridLayout(1, 4));
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		
		//프레임의 [닫기]를 누른 경우 프로그램을 종료하는 이벤트 처리 객체 등록
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		red.addActionListener(new RedButtonHandle());
		
		setBounds(800, 200, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceGetApp("이벤트처리");
	}
	
	public class RedButtonHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.RED);	
		}
	}
}

















