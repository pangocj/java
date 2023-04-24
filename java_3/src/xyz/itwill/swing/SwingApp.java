package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//javax.swing 패키지의 클래스를 이용하여 GUI 프로그램을 작성하는 방법 - AWT와 다른점
//1.java.awt 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스 대신 javax.swing 패키지의 컴퍼넌트와
//컨테이너 관련 클래스를 사용하여 UI 구현
// => AWT 컴퍼넌트(컨테이너) 관련 클래스 이름 앞에 J를 붙이면 SWING 컴퍼넌트와 동일
//2.프레임의 [닫기]를 누른 경우 동작되는 기능을 기본적으로 제공
// => JFrame.setDefaultCloseOperation(int operation) 메소드를 호출하여 프레임의 [닫기]를 누른
//경우되는 동작되는 기능을 변경 가능 - operation 매개변수에서는 WindowConstants 클래스의 상수 전달
// => DO_NOTHING_ON_CLOSE : 아무런 동작도 실행되지 않도록 설정하는 상수
// => HIDE_ON_CLOSE : 프레임을 보여지지 않도록 설정하는 상수 - 기본값
// => DISPOSE_ON_CLOSE : 메모리를 정리하고 프로그램을 종료하는 상수
// => EXIT_ON_CLOSE  : 프로그램을 종료하는 상수
//3.프레임을 직접 변경하지 않고 프레임의 Container 객체를 반환받아 변경 처리
// => 프레임의 배치관리자 변경, 프레임의 배경색 변경, 프레임의 컴퍼넌트 배치 등

//JTextField 컴퍼넌트에서 메세지를 입력 후 엔터를 누르면 JTextArea 컴퍼넌트에 메세지를 
//추가하여 출력되도록 프로그램 작성
// => JTextField 컴퍼넌트에서 메세지를 입력 후 엔터를 누르면 ActionEvent 발생
public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JTextField jTextField;
	JTextArea jTextArea;
	
	public SwingApp(String title) {
		super(title);
		
		jTextField=new JTextField();
		jTextArea=new JTextArea("[홍길동]님이 입장 하였습니다.\n");
		
		//Swing 프로그램에서는 운영체제에서 제공되는 모든 글꼴 사용 가능
		jTextField.setFont(new Font("굴림체", Font.BOLD, 20));
		jTextArea.setFont(new Font("굴림체", Font.BOLD, 20));
		
		jTextArea.setBackground(Color.YELLOW);
		
		//JTextArea 컴퍼넌트에 입력촛점을 제공하지 않도록 설정 - 출력 컴퍼넌트로만 사용
		jTextArea.setFocusable(false);
		
		//JFrame.getContentPane() : 프레임의 컨테이너 기능을 객체를 반환하는 메소드
		Container container=getContentPane();
		
		//JScrollPane : 컴퍼넌트에 스크롤을 제공하는 컨테이너
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		
		//container.add(jTextArea, BorderLayout.CENTER);
		container.add(jScrollPane, BorderLayout.CENTER);
		container.add(jTextField, BorderLayout.SOUTH);
		
		//JTextField 컴퍼넌트에서 ActionEvent가 발생될 경우 이벤트 처리할 클래스로 객체를
		//생성하여 이벤트 처리 기능 등록
		jTextField.addActionListener(new TextEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}
	
	public class TextEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//TextComponenet.getText() : JTextField 컴퍼넌트 또는 JTextArea 컴퍼넌트에 입력된
			//문자열을 반환하는 메소드
			String text=jTextField.getText();
			
			if(!text.equals("")) {//입력된 문자열이 있는 경우
				//JTextArea.append(String text) : JTextArea 컴퍼넌트에 문자열을 추가하여 출력하는 메소드
				jTextArea.append("[홍길동]"+text+"\n");
				
				//JTextArea.setCaretPosition(int position) : JTextArea 컴퍼넌트의 스크롤을
				//이동하는 메소드
				jTextArea.setCaretPosition(jTextArea.getText().length());//스크롤을 맨아래로 이동
				
				//TextComponenet.setText(String text) : JTextField 컴퍼넌트 또는 JTextArea 
				//컴퍼넌트에 입력된 문자열을 변경하는 메소드
				jTextField.setText("");
			}
		}
	}
}
