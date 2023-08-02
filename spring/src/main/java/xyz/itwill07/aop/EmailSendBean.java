package xyz.itwill07.aop;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//JavaMail 기능을 구현하기 위해 spring-context-support 라이브러리와 javax.mail 라이브러리가
//프로젝트에 빌드되도록 처리 - 메이븐 이용 : pom.xml

//메일 전송 기능을 제공하기 위한 클래스 - 메일 서버의 SMTP 서비스를 사용하여 메일 전송
// => 메일 서버(Mail Server) : 메일을 송수신하는 서비스를 제공하는 컴퓨터
// => SMTP(Simple Message Transfer Protocol - 25) 서비스로 메일을 보내고 POP3(Post Office Protocol 3 - 110)
//서비스나 IMAP(Internet Message Access Protocol - 143) 서비스로 메일을 받아 사용자에 전달
public class EmailSendBean {
	//JavaMailSender 객체를 저장하기 위한 필드 선언
	// => JavaMailSender 객체 : SMTP 서비스를 제공하는 서버의 정보를 저장하기 위한 객체
	@Setter
	private JavaMailSender javaMailSender;
	
	//메일을 전송하는 메소드
	// => 메일을 받는 사람의 이메일 주소, 제목, 내용을 매개변수로 전달받아 저장
	// => 메일을 받는 사람의 이메일 주소를 반환
	public String sendEmail(String email, String subject, String content) throws Exception {
		//JavaMailSender.createMimeMessage() : MimeMessage 객체를 생성하여 반환하는 메소드
		//MimeMessage 객체 : 메일 전송 관련 정보를 저장하기 위한 객체
		MimeMessage message=javaMailSender.createMimeMessage();
		
		//MimeMessage.setSubject(String subject) : MimeMessage 객체의 메일 제목을 변경하는 메소드
		message.setSubject(subject);
		
		//MimeMessage.setText(String content) : MimeMessage 객체의 메일 내용(일반문서)을 변경하는 메소드
		//message.setText(content);
		
		//MimeMessage.setContent(Object o, String type) : MimeMessage 객체의 메일 내용을 변경하는 메소드
		// => type 매개변수에 메일로 전달할 문서의 형식(MimeType)을 전달하여 저장
		message.setContent(content, "text/html; charset=utf-8");//HTML 문서로 전달
		
		//MimeMessage.setRecipient(RecipientType type, Address address) : MimeMessage 객체의 
		//메일을 받는 사람의 이메일 주소 관련 정보를 변경하는 메소드
		// => RecipientType : 메일 수신 사용자를 구분하기 위한 상수를 전달
		// => Address : 이메일 주소가 저장된 Address 객체를 전달
		//InternetAddress 객체 : 이메일 주소를 저장하기 위한 객체 
		//MimeMessage.setRecipients(RecipientType type, Address[] address) : MimeMessage 객체의
		//메일을 받는 사람들의 이메일 주소 관련 정보를 변경하는 메소드 - 다수의 사람에게 메일 전송
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		
		//JavaMailSender.send(MimeMessage message) : SMTP 서비스를 사용하여 메일을 전송하는 메소드
		javaMailSender.send(message);
		
		return email;
	}
}
