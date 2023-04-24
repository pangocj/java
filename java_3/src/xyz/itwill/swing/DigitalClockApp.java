package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

//시스템 현재 날짜와 시간을 1초마다 제공받아 출력하는 GUI 프로그램 작성
// => 새로운 스레드를 생성하여 날짜와 시간을 1초마자 제공받아 컴퍼넌트 변경
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//날짜와 시간을 출력할 JLabel 컴퍼넌트를 저장하기 위한 필드
	JLabel clockLabel;
	
	public DigitalClockApp(String title) {
		super(title);
		
		/*
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String printDate=dateFormat.format(now);
		*/
		
		//clockLabel=new JLabel(printDate, JLabel.CENTER);
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림체", Font.BOLD, 30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		
		//스레드 객체로 새로운 스레드를 생성해 run() 메소드를 호출하여 명령 실행
		new ClockThread().start();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 600, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("디지털 시계");
	}
	
	//시스템의 현재 날짜와 시간을 1초마다 제공받아 JLabel 컴퍼넌트를 변경하는 기능을 제공하는
	//스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

			while(true) {
				Date now=new Date();
				String printDate=dateFormat.format(now);
				
				//JLabel.setText(String text) : JLabel 컴퍼넌트의 문자열을 변경하는 메소드
				clockLabel.setText(printDate);
				
				try {
					//스레드를 1초동안 일시중지
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}









