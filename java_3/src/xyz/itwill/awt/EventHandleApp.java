package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//컴퍼넌트에서는 다양한 이벤트가 발생되며 컴퍼넌트에서 이벤트가 발생될 경우 원하는 기능을
//구현하여 실행되도록 프로그램 작성 - 이벤트 처리 프로그램 

//이벤트 처리 프로그램 작성 방법
//1.컴퍼넌트와 컨테이너 관련 클래스를 사용하여 디자인 클래스 작성 - UI 구현
// => Frame 클래스를 상속받아 디자인 클래스 작성
// => 컴퍼넌트 또는 컨테이너에서 다양한 이벤트 발생 - 이벤트 소스(Event Source)
// => 이벤트와 관련된 XXXEvent 클래스(이벤트 정보를 저장하기 위한 클래스)로 객체가 자동 생성
// ex) Button 컴퍼넌트를 누른 경우 ActionEvent 클래스로 객체 생성 - ActionEvent 발생
//2.이벤트 소스에서 발생된 이벤트를 처리하기 위한 클래스 작성
// => 이벤트를 처리하기 위해 XXXListener 인터페이스를 상속받아 이벤트 처리 클래스 작성
// ex) ActionEvent >> ActionListener 인터페이스를 상속받아 이벤트 처리 클래스 작성
// => Listener 인터페이스에서 컴퍼넌트에서 발생된 이벤트를 처리하기 위해 추상메소드 제공
// => Listener 인터페이스를 상속받은 자식클래스에서 추상메소드를 오버라이드 선언하여
//오버라이드 선언된 메소드에 이벤트 처리 명령 작성 
//3.이벤트 소스에서 이벤트가 발생되면 이벤트 처리 클래스의 객체를 제공받아 이벤트 처리 명령이
//실행되도록 설정 - Component.addXXXListener(Listener l) 메소드 호출
// => Component.addXXXListener(Listener l) : 컴퍼넌트의 이벤트를 처리하기 위한 이벤트 처리 
//객체를 매개변수로 제공받아 등록(추가)하기 위한 메소드
// => JVM은 컴퍼넌트에서 이벤트가 발생되면 등록된 이벤트 처리 객체를 사용하여 자동으로 
//이벤트 처리 메소드를 호출하여 이벤트 처리

//[EXIT] 버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
// => 이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트 사용 불가능
public class EventHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");//이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		//컴퍼넌트에 이벤트 처리 객체 등록
		// => Button 컴퍼넌트에서 ActionEvent가 발생될 경우 EventHandle 클래스의 객체를
		//제공받아 이벤트 처리 메소드를 자동 호출하여 이벤트 처리
		exit.addActionListener(new EventHandle());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandleApp("이벤트처리");
	}
}

//이벤트 처리 기능을 제공하기 위한 클래스 - Listener 인터페이스를 상속받아 작성
// => Button 컴퍼넌트에서 발생된 ActionEvent를 처리하기 위한 클래스
class EventHandle implements ActionListener {
	//이벤트 처리 명령을 작성하기 위한 메소드 - 이벤트 처리 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
