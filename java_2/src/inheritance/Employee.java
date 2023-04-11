package inheritance;

//static 제한자 : 클래스(내부클래스), 메소드, 필드에 사용하는 제한자
// => 객체가 아닌 클래스로 접근하여 사용하기 위한 제한자


//사원정보(사원번호, 사원이름)를 저장하기 위한 클래스
// => 모든 사원 관련 클래스가 상속받아야 되는 부모클래스
// => 객체 생성이 목적이 아닌 상속을 목적으로 작성된 클래스 - 추상클래스로 선언하는 것을 권장
//추상클래스(Abstract Class) : abstract 제한자를 사용하여 선언된 클래스
// => 객체 생성 불가능 - 상속 전용 클래스
//형식) public abstract class 클래스명 { }
// => abstract 제한자 : 클래스, 메소드에 사용하는 제한자
public abstract class Employee {
	private int empNo;
	private String empName;
		
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/*
	//급여를 계산하여 반환하는 메소드
	// => 자식클래스에서 부모클래스의 메소드를 오버라이드 선언하지 않아도 에러 미발생
	// => 자식클래스에서 부모클래스의 메소드를 오버라이드 선언하지 않으면 부모클래스의 
	//메소드 호출 - 비정상적인 결과 제공
	public int computePay() {
		return 0;
	}
	*/

	//자식클래스에서 부모클래스의 메소드를 무조건 오버라이드 선언하도록 설정하기 위해
	//abstract 제한자를 사용하여 추상메소드로 선언
	//추상메소드(Abstract Method) : abstract 제한자를 사용하여 선언된 메소드
	// => 메소드의 머릿부만 작성하고 몸체부는 작성하지 않는 미완성된 메소드
	//형식) 접근제한자 abstract 반환형 메소드명(자료형 매개변수명, ...);
	// => 추상메소드가 선언된 클래스는 반드시 추상클래스로 선언
	//추상메소드가 선언된 클래스를 상속받은 자식클래스는 무조건 모든 추상메소드를 오버라이드 선언 
	// => 자식클래스에서 추상메소드를 오버라이드 선언하지 않으면 자식클래스도 추상클래스로 
	//설정되어 객체를 생성할 경우 에러 발생
	public abstract int computePay();
	
	//인센티브를 계산하여 반환하는 메소드
	// => 모든 사원에게 급여의 150%를 인센티브로 제공되도록 계산
	public int computeIncentive() {
		//추상메소드를 호출한 경우 묵시적 객체 형변환에 의해 자식클래스의 메소드 호출
		return (int)(computePay()*1.5);
	}
}
















