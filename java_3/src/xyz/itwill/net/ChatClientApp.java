package xyz.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//채팅 클라이언트 프로그램 - GUI
// => 서버에서 보내온 메세지를 전달받아 JTextArea 컴퍼넌트에 출력 - 무한루프
// => JTextField 컴퍼넌트에서 입력된 메세지를 서버에 전달 - 이벤트 처리 메소드
public class ChatClientApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextArea jTextArea;//출력 컴퍼넌트
	private JTextField jTextField;//입력 컴퍼넌트
	
	//서버와 연결된 Socket 객체를 저장하기 위한 필드
	private Socket socket;
	
	public ChatClientApp(String title) {
		super(title);
		
		jTextArea=new JTextArea();
		jTextField=new JTextField();
		
		jTextArea.setFont(new Font("굴림체", Font.BOLD, 20));
		jTextField.setFont(new Font("굴림체", Font.BOLD, 20));
		
		jTextArea.setFocusable(false);
		
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		getContentPane().add(jTextField, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatClientApp("자바채팅");
	}
}
