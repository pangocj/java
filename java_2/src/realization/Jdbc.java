package realization;

//학생 관리 클래스가 반드시 상속받아야 되는 인터페이스
// => 학생 관리 클래스에 메소드 작성 규칙 제공 - 작업지시서 역활
public interface Jdbc {
	void insert();
	void update();
	void delete();
	void select();
}