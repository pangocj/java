package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

//문서파일 편집기 프로그램 작성 - 메모장
public class NotepadApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextArea jTextArea;
	JMenuItem init, open, save, exit;
	
	//JFileChooser 클래스 : 파일을 선택하기 위한 다이얼로그를 생성하기 위한 컴퍼넌트 클래스
	JFileChooser openDialog, saveDialog;
	
	//현재 작업중인 문서파일의 경로를 저장하기 위한 필드
	private File file;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar jMenuBar=new JMenuBar();
		
		JMenu jMenu=new JMenu("파일(F)");
		jMenu.setMnemonic('F');
		
		//메뉴아이템을 선택할 경우 ActionEvent 발생
		init=new JMenuItem("새로 만들기(N)", 'N');
		open=new JMenuItem("열기(O)", 'O');
		save=new JMenuItem("저장(S)", 'S');
		exit=new JMenuItem("끝내기(X)", 'X');
		
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O
				, InputEvent.ALT_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S
				, InputEvent.ALT_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		
		jMenu.add(init);
		jMenu.add(open);
		jMenu.add(save);
		jMenu.addSeparator();
		jMenu.add(exit);
		
		jMenuBar.add(jMenu);
		
		setJMenuBar(jMenuBar);
				
		jTextArea=new JTextArea();
		jTextArea.setFont(new Font("굴림체", Font.PLAIN, 20));
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		openDialog=new JFileChooser();
		//JFileChooser.setCurrentDirectory(File file) : 파일 다이얼로그의 기본 작업 
		//디렉토리를 변경하는 메소드 
		openDialog.setCurrentDirectory(new File("c:/"));
		//JFileChooser.addChoosableFileFilter(FileFilter filter) : 파일 선택에 대한 필터 기능을 추가하는 메소드 
		openDialog.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)", "txt"));
		saveDialog=new JFileChooser();
		saveDialog.setCurrentDirectory(new File("c:/"));
		saveDialog.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)", "txt"));

		init.addActionListener(new NodepadEventHandle());
		open.addActionListener(new NodepadEventHandle());
		save.addActionListener(new NodepadEventHandle());
		exit.addActionListener(new NodepadEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 150, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - Java 메모장");
	}
	
	public class NodepadEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource==init) {
				jTextArea.setText("");//JTextArea 컴퍼넌트 초기화
				file=null;//필드 초기화
				setTitle("제목 없음 - Java 메모장");//프레임 제목 초기화
			} else if(eventSource==open) {
				//JFileChooser.showOpenDialog(Component parent) : 열기 관련 파일 다이얼로그를
				//화면에 출력하는 메소드 - 버튼 선택에 따른 정수값 반환
				int option=openDialog.showOpenDialog(NotepadApp.this);
				
				if(option==JFileChooser.APPROVE_OPTION) {//파일 선택 버튼을 누른 경우
					//JFileChooser.getSelectedFile() : 선택된 파일의 경로가 저장된 File 
					//객체를 반환하는 메소드
					file=openDialog.getSelectedFile();
					
					setTitle(file.toString()+" - Java 메모장");
					
					try {
						//파일의 절대경로를 제공받아 파일 입력스트림 생성
						BufferedReader in=new BufferedReader(new FileReader(file.getAbsoluteFile()));
						
						jTextArea.setText("");//JTextArea 컴퍼넌트 초기화
						
						while(true) {
							//파일에 저장된 값을 한줄씩 읽어 문자열로 반환받아 저장
							String text=in.readLine();
							if(text==null) break;//파일내용이 없는 경우 반복문 종료
							//변수에 저장된 문자열을 JTextArea 컴퍼넌트에 추가하여 출력
							jTextArea.append(text+"\n");
						}
						
						in.close();
					} catch (FileNotFoundException exception) {
						JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다.");
					} catch (IOException exception) {
						JOptionPane.showMessageDialog(null, "프로그램에 문제가 발생 하였습니다.");
					}
				} else if(option==JFileChooser.CANCEL_OPTION) {//취소 버튼을 누른 경우
					return;
				}
			} else if(eventSource==save) {
				if(file==null) {
					int option=saveDialog.showSaveDialog(NotepadApp.this);
					
					if(option==JFileChooser.APPROVE_OPTION) {
						file=saveDialog.getSelectedFile();
						
						setTitle(file.toString()+" - Java 메모장");
						
						try {
							//파일의 경로를 제공받아 파일 출력스트림 생성
							BufferedWriter out=new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
							
							//JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
							String text=jTextArea.getText();
							
							//반환받은 문자열을 파일 출력스트림으로 전달하여 저장
							out.write(text);
							
							out.close();
						} catch (IOException exception) {
							JOptionPane.showMessageDialog(null, "프로그램에 문제가 발생 하였습니다.");
						}
					} else if(option==JFileChooser.CANCEL_OPTION) {
						return;
					}
				}
			} else if(eventSource==exit) {
				System.exit(0);
			}
		}
	}
}
