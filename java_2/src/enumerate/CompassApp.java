package enumerate;

public class CompassApp {
	public static void main(String[] args) {
		//열거형에 선언된 상수필드값 출력 - 상수필드명을 제공받아 출력
		System.out.println("동쪽 = "+Compass.EAST);
		System.out.println("서쪽 = "+Compass.WEST);
		System.out.println("남쪽 = "+Compass.SOUTH);
		System.out.println("북쪽 = "+Compass.NORTH);
		System.out.println("==============================================================");
		System.out.println("동쪽 = "+Compass.EAST.getValue());
		System.out.println("서쪽 = "+Compass.WEST.getValue());
		System.out.println("남쪽 = "+Compass.SOUTH.getValue());
		System.out.println("북쪽 = "+Compass.NORTH.getValue());
		System.out.println("==============================================================");
		//EnumType.values() : 열거형에 선언된 모든 상수필드를 배열로 변환하여 반환하는 메소드
		for(Compass compass : Compass.values()) {
			//EnumType.ordinal() : 상수필드를 구분하기 위한 첨자(Index)를 반환하는 메소드
			System.out.println(compass+" = "+compass.getValue()+" >> "+compass.ordinal());
		}
		System.out.println("==============================================================");
	}
}
