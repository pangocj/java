package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class PanelApp extends Frame {
	private static final long serialVersionUID = 1L;

	public PanelApp(String title) {
		super(title);
		
		Button red=new Button("RED");
		Button green=new Button("GREEN");
		Button blue=new Button("BULE");
		
		//TextField 클래스 : 한 줄의 문자열을 입출력하기 위한 컴퍼넌트를 구현하기 위한 클래스
		TextField textField=new TextField();
		//TextArea 클래스 : 여러 줄의 문자열을 입출력하기 위한 컴퍼넌트를 구현하기 위한 클래스
		TextArea textArea=new TextArea();

		//Panel 클래스 : 컴퍼넌트를 배치하여 그룹화 하기 위한 종속적인 컨테이너 클래스
		// => 독립적인 사용 불가능한 컨테이너이므로 다른 컨테이너에 배치하여 사용
		Panel panel=new Panel();//[FlowLayout]이 기본 배치관리자
		
		//패널 컨테이너에 버튼 컴퍼넌트를 차례대로 배치
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		
		//Component.setFont(Font f) : 컴퍼넌트의 글자 관련 속성을 변경하는 메소드
		//Font 클래스 : 글자 관련 속성을 저장하기 위한 클래스
		// => Font 클래스의 Font(String name, int style, int size) 생성자로 Font 객체 생성
		// => name : 글자의 글꼴, style : 글자 스타일, size : 글자 크기
		// => 글자의 글꼴과 스타일은 Font 클래스에서 제공하는 상수(Constant) 사용
		//컨테이너에 적용된 글자 관련 속성은 컨테이너에 배치된 컴퍼넌트에 동일하게 적용
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 18));
		
		//Component.setForeground(Color c) : 컴퍼넌트 글자색을 변경하는 메소드
		//Color 클래스 : 색상 정보를 저장하기 위한 클래스
		// => Color 클래스의 Color(int red, int green, int blue) 생성자로 Color 객체 생성
		// => 빨간색, 초록색, 파란색은  0~255 범위의 정수값으로 표현
		// => Color 클래스는 대표색을 상수(Color 객체)로 제공 
		red.setForeground(new Color(255, 0, 0));
		green.setForeground(new Color(0, 255, 0));
		blue.setForeground(new Color(0, 0, 255));
		
		//Component.setBackground(Color c) : 컴퍼넌트 배경색을 변경하는 메소드
		textArea.setBackground(Color.YELLOW);
		
		//Component.setEnabled(boolean b) : 컴퍼넌트의 활성화 상태 여부를 변경하는 메소드
		red.setEnabled(false);//컴퍼넌트 비활성화
		//TextComponent.setFocusable(boolean b) : 텍스트 컴퍼넌트의 입력촛점 위치 여부를 변경하는 메소드
		textArea.setFocusable(false);//입력촛점 미제공 - 입력 불가능
		
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PanelApp("Panel");
	}
}
