package realization;

//이클립스를 사용하여 클래스로 인터페이스 추출 가능
// => 클래스 >> 오른쪽 버튼 >> 메뉴 : Refactor >> Extract Interface... 
//    >> 인터페이스 이름 입력 >> 추상메소드 선택 >> Ok
public class JdbcMysql implements Jdbc {
	@Override
	public void insert() {
		System.out.println("[mysql]학생정보를 삽입하는 기능을 제공하는 메소드");
	}
	
	@Override
	public void update() {
		System.out.println("[mysql]학생정보를 변경하는 기능을 제공하는 메소드");
	}
	
	@Override
	public void delete() {
		System.out.println("[mysql]학생정보를 삭제하는 기능을 제공하는 메소드");
	}
	
	@Override
	public void select() {
		System.out.println("[mysql]학생정보를 검색하는 기능을 제공하는 메소드");
	}
}
