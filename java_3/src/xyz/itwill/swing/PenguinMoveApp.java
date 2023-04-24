package xyz.itwill.swing;

import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public PenguinMoveApp(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 646, 461);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("펭귄 이동");
	}
}
