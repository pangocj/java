package xyz.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//클라이언트의 요청정보와 요청 처리 클래스의 객체를 Map 객체의 엔트리로 저장하여 제공하는 기능의 클래스
public class HandlerMapping {
	//Map 객체를 저장하기 위한 필드
	// => 엔트리의 제네릭으로 맵키는 요청정보를 저장하기 위해 String 클래스로 설정하고
	//맵값은 요청 처리 클래스의 객체를 저장하기 위해 Controller 인터페이스로 설정
	private Map<String, Controller> mappings;
	
	//생성자로 Map 객체를 생성하여 필드에 저장하고 요청정보와 요청 처리 클래스의 객체를	엔트리로 추가
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/list.itwill", new ListController());
		mappings.put("/view.itwill", new ViewController());
	}
	
	//매개변수로 클라이언트의 요청정보를 전달받아 요청을 처리하기 위한 객체를 Map 객체에서 
	//검색하여 반환하는 메소드
	public Controller getController(String command) {
		return mappings.get(command);
	}
}
