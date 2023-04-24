package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public JTableApp(String title) {
		super(title);
		
		String[] columnName={"학번","이름","전화번호"};
		String[][] rowData={{"1000","홍길동","010-1324-5343"}
			,{"2000","임꺽정","010-1234-7611"},{"3000","전우치","010-7213-3499"}
			,{"4000","일지매","010-3247-6121"},{"5000","장길산","010-8781-0111"}};
		
		//DefaultTableModel 클래스 : 테이블 관련 정보를 저장하기 위한 클래스
		// => 테이블의 행 또는 열(셀 : Cell)을 조작할 수 있는 메소드 제공
		DefaultTableModel defaultTableModel=new DefaultTableModel(rowData, columnName);
		
		//Vector 클래스 : 다수의 객체를 저장하기 위한 콜렉션 클래스 - List 인터페이스 상속
		Vector<String> vector=new Vector<>();
		vector.add("6000");
		vector.add("홍경래");
		vector.add("010-3213-1233");
		
		//DefaultTableModel.addRow(Vector vector) : 테이블에 행을 추가하는 메소드
		defaultTableModel.addRow(vector);
		
		//JTable 클래스 : 값을 행과 열로 구성된 표 형식으로 출력하기 위한 컴퍼넌트
		//JTable jTable=new JTable(rowData, columnName);
		JTable jTable=new JTable(defaultTableModel);
		
		JScrollPane jScrollPane=new JScrollPane(jTable);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableApp("JTable 컴퍼넌트");
	}
}
