package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//프레임의 폭과 높이를 지정한 상수
	private static final int JFRAME_WIDTH=646;
	private static final int JFRAME_HEIGHT=461;
	
	//펭귄의 폭과 높이를 지정한 상수
	private static final int PENGUIN_SIZE=60;
	
	//배경이미지를 저장하기 위한 필드
	//Image 클래스 : 이미지의 정보를 저장하기 위한 클래스
	private Image backImage; 
	
	//펭귄이미지를 저장하기 위한 필드 - 배열
	private Image[] penguins; 
	
	//펭귄이미지를 선택하기 위한 필드 - 배열 첨자
	private int penguinNo;
	
	//펭귄이미지가 출력될 좌표값을 저장하기 위한 필드
	private int penguinX, penguinY;
	
	public PenguinMoveApp(String title) {
		super(title);
		
		//ImageIcon 클래스 : 그림파일을 정보를 저장하기 위한 클래스
		// => ImageIcon(URL location) : 그림파일의 URL 주소를 제공받아 ImageIcon 객체 생성
		//URL 클래스 : 리소스 파일(그림 파일, 소리 파일, 동영상 파일 등)의 경로를 저장하기 위한 클래스
		//Object.getClass() : 메모리에 저장된 현재 실행 클래스의 Class 객체를 반환하는 메소드
		//Class.getResource(String name) : 현재 실행 클래스를 기준으로 리소스 파일을 읽어
		//URL 객체를 반환하는 메소드
		//ImageIcon.getImage() : ImageIcon 객체에 저장된 그림파일의 Image 객체를 반환하는 메소드
		//배경이미지 파일을 읽어 배경 이미지를 필드에 저장 
		backImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
		//펭귄이미지 파일을 읽어 필드(배열) 요소에 저장
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
		//penguinNo=0;
		
		//펭귄이미지가 출력될 좌표값을 계산하여 저장
		penguinX=JFRAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFRAME_HEIGHT-PENGUIN_SIZE;
		
		setResizable(false);
		
		//프레임에서 키보드 관련 이벤트가 발생될 경우 이벤트 처리 객체를 사용하여 이벤트 처리
		addKeyListener(new PenguinMoveHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBounds(700, 200, 646, 461);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("펭귄 이동");
	}
	
	@Override
	public void paint(Graphics g) {
		//Graphics.drawImage(Image image, int x, int y, int width, int height, ImageObserver observer)
		// => 이미지를 출력하는 메소드
		g.drawImage(backImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);

		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
	}
	
	public class PenguinMoveHandle extends KeyAdapter {
		//키보드를 누르고 있는 경우 호출되는 메소드
		@Override
		public void keyPressed(KeyEvent e) {
			//KeyEvent.getKeyCode() : 이벤트가 발생된 키보드의 고유값을 반환하는 메소드
			int keyCode=e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_LEFT:
				penguinX-=10;
				if(penguinX<=0) {
					penguinX=0;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				penguinX+=10;
				if(penguinX>=JFRAME_WIDTH-PENGUIN_SIZE) {
					penguinX=JFRAME_WIDTH-PENGUIN_SIZE;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			}
		}
	}
}
