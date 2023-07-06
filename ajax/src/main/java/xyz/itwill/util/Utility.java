package xyz.itwill.util;

public class Utility {
	//JSON 데이타를 전달받아 JSON 데이타로 사용 불가능한 문자를 회피문자로 변환하여 반환하는 메소드
	public static String toJSON(String source) {
		return source.replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "\\n").replace("\r\n", "\\n");
	}
	
	//문자열을 전달받아 태그 관련 문자를 회피문자로 변경하여 반환하는 메소드
	public static String escapeTag(String source) {
		return source.replace("<", "&lt;").replace(">", "&gt;");
	}
}
