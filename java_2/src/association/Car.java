package association;

//클래스와 클래스의 관계 - 객체 관계
// => UML(Unified Modeling Language)를 사용하여 클래스 다이어그램(Class Diagram)으로 표현
//1.일반화 관계(Generalization) : 상속 관계 - X is a Y
// => 클래스를 선언할 때 기존 클래스를 상속받아 작성
// => 사원 클래스와 관리자 클래스의 관계 - 관리자는 사원이다.(O), 사원은 관리자다.(X)
//2.실체화 관계(Realization) : 상속 관계
// => 클래스를 선언할 때 기존 인터페이스를 상속받아 작성
// => 인터페이스 : 현실에 존재하는 대상을 클래스 보다 추상적으로 표현하기 위한 자료형
//3.연관 관계(Association) :  포함 관계 - X has a Y
// => 직접 연관 관계(Direct Association) : 한 방향으로만 도구로써 기능을 제공하는 관계
// => 컴퓨터 << CPU + MainBoard + Memory
//4.집합 연관 관계(Aggregation) : 포함 관계로 설정된 객체들의 생명주기가 다른 포함 관계
// => 컴퓨터 << 프린터
//5.복합 연관 관계(Composition) : 포함 관계로 설정된 객체들의 생명주기가 같은 포함 관계
// => 게임 << 캐릭터
//6.의존 관계(Dependency) : 포함 관계로 설정된 객체를 변경돼도 다른 객체에 영향을 주지 않는 포함 관계
// => TV << 리모콘

//자동차 정보(모델명, 생산년도, 엔진정보)를 저장하기 위한 클래스
public class Car {
	private String modelName;
	private int productionYear;
	//엔진정보를 저장하기 위한 필드 - Engine 클래스를 자료형으로 선언된 필드
	// => 필드에는 생성자 또는 Setter 메소드를 사용하여 Engine 객체를 제공받아 저장 - 포함관계
	private Engine carEngine;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, int productionYear, Engine carEngine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Engine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(Engine carEngine) {
		this.carEngine = carEngine;
	}
	
	//자동차 정보(필드값)를 출력하는 메소드
	public void displayCar() {
		System.out.println("모델명 = "+modelName);
		System.out.println("생산년도 = "+productionYear);
		
		//System.out.println("엔진정보 = "+carEngine);//객체의 메모리 주소 출력
		//필드에 저장된 객체를 이용하여 메소드 호출
		// => 포함관계로 설정된 클래스(객체)의 메소드를 호출하여 원하는 기능 구현
		// => 포함관계가 설정되지 않은 상태에서 메소드가 호출될 경우 NullPointerException 발생
		//System.out.println("연료타입 = "+carEngine.getFualType());
		//System.out.println("배기량 = "+carEngine.getDisplacement());
		carEngine.displayEngine();//코드의 중복성 최소화
	}
}
