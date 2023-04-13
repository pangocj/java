package enumerate;

//클래스 또는 인터페이스에 상수필드를 선언한 경우 발생될 수 있는 문제점
// => 상수필드를 값을 대표하는 단어로 사용하기 부적절한 경우 발생
// => 상수필드가 선언된 클래스 또는 인터페이스는 아무런 의미 없이 접근 용도로만 사용
//Java에서는 클래스 또는 인터페이스에 상수필드를 선언해서 발생될 수 있는 문제점을 해결하기
//위해 열거형(EnumerateType)이라는 자료형(참조형)을 제공
public class InterfaceApp {
	public static void main(String[] args) {
		//인터페이스에 선언된 상수필드값 출력 - 필드에 저장된 값을 제공받아 출력
		System.out.println("삽입 = "+InterfaceOne.INSERT);
		System.out.println("변경 = "+InterfaceOne.UPDATE);
		System.out.println("삭제 = "+InterfaceOne.DELETE);
		System.out.println("검색 = "+InterfaceOne.SELECT);
		System.out.println("=============================================================");
		System.out.println("삽입 = "+InterfaceTwo.ADD);
		System.out.println("변경 = "+InterfaceTwo.MODIFY);
		System.out.println("삭제 = "+InterfaceTwo.REMOVE);
		System.out.println("검색 = "+InterfaceTwo.SEARCH);
		System.out.println("=============================================================");
		//상수필드의 자료형과 동일한 자료형의 변수를 생성하여 상수 저장 가능
		int choice=InterfaceOne.INSERT;//int choice=1;
		System.out.println("choice = "+choice);
		System.out.println("=============================================================");
		switch(choice) {
		//case InterfaceOne.INSERT:
		case InterfaceTwo.ADD:
			System.out.println("# 학생정보를 삽입합니다.");
			break;
		case InterfaceOne.UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case InterfaceOne.DELETE:
			System.out.println("# 학생정보를 삭제합니다.");
			break;
		case InterfaceOne.SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;	
		}
		System.out.println("=============================================================");
	}
}
