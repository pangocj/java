package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//시스템 현재 날짜와 시간을 1초마다 제공받아 출력하는 GUI 프로그램 작성
// => 새로운 스레드를 생성하여 날짜와 시간을 1초마자 제공받아 컴퍼넌트 변경
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//날짜와 시간을 출력할 JLabel 컴퍼넌트를 저장하기 위한 필드
	JLabel clockLabel;
	JButton startButton, stopButton;
	
	//날짜와 시간을 변경하는 스레드의 실행상태를 저장하기 위한 필드
	// => false : 스레드 중지 상태, true : 스레드 동작 상태
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);
		
		isRun=true;
		
		/*
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String printDate=dateFormat.format(now);
		*/
		
		//clockLabel=new JLabel(printDate, JLabel.CENTER);
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림체", Font.BOLD, 30));
		clockLabel.setForeground(Color.DARK_GRAY);

		startButton=new JButton("다시 실행");
		stopButton=new JButton("일시 중지");
		startButton.setFont(new Font("굴림체", Font.BOLD, 20));
		stopButton.setFont(new Font("굴림체", Font.BOLD, 20));
		
		JPanel jPanel=new JPanel();
		jPanel.add(startButton);
		jPanel.add(stopButton);
		
		startButton.setEnabled(false);
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		getContentPane().add(jPanel, BorderLayout.SOUTH);
		
		//스레드 객체로 새로운 스레드를 생성해 run() 메소드를 호출하여 명령 실행
		new ClockThread().start();
		
		//컴퍼넌트에서 이벤트가 발생될 경우 이벤트 처리 객체를 제공받아 이벤트 처리
		// => JVM에 의해 Event-Queue 스레드를 생성하여 이벤트가 발생되면 이벤트 처리
		startButton.addActionListener(new ClockEventHandle());
		stopButton.addActionListener(new ClockEventHandle());
		
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
				if(isRun) {
					/*
					Date now=new Date();
					String printDate=dateFormat.format(now);
					
					//JLabel.setText(String text) : JLabel 컴퍼넌트의 문자열을 변경하는 메소드
					clockLabel.setText(printDate);
					*/
					
					//시스템의 현재 날짜와 시간을 제공받아 JLabel 컴퍼넌트의 문자열 변경
					clockLabel.setText(dateFormat.format(new Date()));
				}
				
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
	
	//버튼을 누른 경우 실행될 이벤트 처리 클래스
	public class ClockEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource==startButton) {
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				
				isRun=true;
			} else if(eventSource==stopButton) {
				startButton.setEnabled(true);
				stopButton.setEnabled(false);

				isRun=false;
			}
		}
	}
}
