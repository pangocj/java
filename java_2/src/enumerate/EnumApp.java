package enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//열거형에 선언된 상수필드값 출력 - 상수필드의 이름이 제공되어 출력
		// => 프로그램에서 상수가 값을 대표하는 이름으로 사용 가능
		System.out.println("삽입 = "+EnumOne.INSERT);
		System.out.println("변경 = "+EnumOne.UPDATE);
		System.out.println("삭제 = "+EnumOne.DELETE);
		System.out.println("검색 = "+EnumOne.SELECT);
		System.out.println("==============================================================");
		System.out.println("삽입 = "+EnumTwo.ADD);
		System.out.println("변경 = "+EnumTwo.MODIFY);
		System.out.println("삭제 = "+EnumTwo.REMOVE);
		System.out.println("검색 = "+EnumTwo.SEARCH);
		System.out.println("==============================================================");
		//열거형에 선언된 상수를 저장하기 위해서는 반드시 열거형(참조형)을 이용하여 변수 선언
		// => 상수필드가 선언된 열거형을 하나의 자료형으로 사용 가능
		//int choice=EnumOne.INSERT;//에러 발생
		//choice 변수에는 EnumOne 자료형에 선언된 상수만 저장 가능
		EnumOne choice=EnumOne.INSERT;
		System.out.println("choice = "+choice);
		System.out.println("==============================================================");
		//나열형으로 선언된 변수에 비교값은 같은 나열형에 선언된 상수만 사용하여 비교 가능
		switch(choice) {
		case INSERT:
		//case ADD;
			System.out.println("# 학생정보를 삽입합니다.");
			break;
		case UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case DELETE:
			System.out.println("# 학생정보를 삭제합니다.");
			break;
		case SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;	
		}
		System.out.println("==============================================================");
	}
}
