package xyz.itwill.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class WindowBuilderApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton red;
	private JButton green;
	private JButton blue;
	private JTextPane textPane;
	private JTextField textField;

	JDialogApp dialog = new JDialogApp(this);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel, BorderLayout.NORTH);
		
		red = new JButton("빨간색"); 
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		red.setForeground(new Color(255, 0, 0));
		red.setFont(new Font("굴림체", Font.PLAIN, 20));
		panel.add(red);
		
		green = new JButton("초록색");
		green.setForeground(new Color(0, 255, 0));
		green.setFont(new Font("굴림체", Font.PLAIN, 20));
		panel.add(green);
		
		blue = new JButton("파란색");
		blue.setForeground(new Color(0, 0, 255));
		blue.setFont(new Font("굴림체", Font.PLAIN, 20));
		panel.add(blue);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
	}
	
	
}
