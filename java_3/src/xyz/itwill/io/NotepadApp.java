package xyz.itwill.io;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

//문서파일 편집기 프로그램 작성 - 메모장
public class NotepadApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextArea jTextArea;
	JMenuItem init, open, save, exit;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar jMenuBar=new JMenuBar();
		
		JMenu jMenu=new JMenu("파일(F)");
		jMenu.setMnemonic('F');
		
		init=new JMenuItem("새로 만들기(N)", 'N');
		open=new JMenuItem("열기(O)", 'O');
		save=new JMenuItem("저장(S)", 'S');
		exit=new JMenuItem("끝내기(X)", 'X');
		
		jMenu.add(init);
		jMenu.add(open);
		jMenu.add(save);
		jMenu.addSeparator();
		jMenu.add(exit);
		
		jMenuBar.add(jMenu);
		
		setJMenuBar(jMenuBar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 150, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - Java 메모장");
	}
}
