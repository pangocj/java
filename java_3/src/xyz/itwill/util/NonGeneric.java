package xyz.itwill.util;

//표현대상을 추상화하여 클래스로 선언할 경우 필드의 자료형이 추상적인 경우 필드의 자료형에
//의해 여러개의 클래스를 선언하여 사용하는 경우 발생
// => 필드의 자료형을 Object 클래스로 선언하면 필드에는 모든 클래스로 생성된 객체 저장
public class NonGeneric {
	private Object field;
	
	public NonGeneric() {
		// TODO Auto-generated constructor stub
	}

	public NonGeneric(Object field) {
		super();
		this.field = field;
	}

	public Object getField() {
		return field;
	}

	public void setField(Object field) {
		this.field = field;
	}
}
