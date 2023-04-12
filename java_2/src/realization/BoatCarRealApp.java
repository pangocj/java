package realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
		//BoatCarReal boatCarReal=new BoatCarReal();
		
		//자식클래스가 상속받은 모든 부모인터페이스로 참조변수를 생성하여 자식클래스의 객체 저장 가능
		// => 묵시적 객체 형변환에 의해 오버라이드 선언된 자식클래스의 메소드 호출
		// => 인터페이스에 따라 호출 가능한 메소드가 다른 경우 발생
		BoatCar boatCar=new BoatCarReal();
		//Car boatCar=new BoatCarReal();
		//Boat boatCar=new BoatCarReal();
		
		boatCar.run();
		boatCar.navigate();
		boatCar.floating();
	}
}
