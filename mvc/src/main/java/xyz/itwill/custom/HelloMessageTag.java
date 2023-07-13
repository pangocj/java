package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성이 있으며 태그 내용이 없는 커스텀 태그 클래스
public class HelloMessageTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//커스텀 태그의 속성값을 저장하기 위한 필드 
	// =>커스텀 태그의 속성명과 같은 이름으로 필드 선언 
	private String name;
	
	//생성자에 객체 생성에 필요한 초기화 작업 관련 명령 작성 - 필드 초기값 설정
	public HelloMessageTag() {
		//커스텀 태그 사용시 속성을 생략할 경우 기본적으로 사용될 속성값으로 필드에 저장하기 위해 작성
		// => 커스텀 태그의 속성이 필수인 경우 필드 기본값 설정 생략
		name="홍길동";
	}

	public String getName() {
		return name;
	}

	//커스텀 태그 사용시 태그속성을 사용하여 속성값을 설정할 경우 Setter 메소드 자동 호출
	public void setName(String name) {
		this.name = name;
	}
	
	//커스텀 태그 사용시 실행될 명령을 작성할 메소드만 오버라이드 선언
	// => 오버라이드 선언하지 않은 메소드는 부모클래스의 명령이 없는 메소드 호출
	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("홍길동")) {
				pageContext.getOut().println("<h3>관리자님, 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"님, 안녕하세요.</h3>");
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}
}









