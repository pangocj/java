package realization;

public class PrintableApp {
	public static void main(String[] args) {
		//기본메소드를 사용하기 위해서는 참조변수를 인터페이스로 선언
		Printable printOne=new PrintSingle();
		
		printOne.print();
		printOne.scan();//인터페이스의 기본 메소드 호출
		System.out.println("=============================================================");
		Printable printTwo=new PrintMulti();
		
		printTwo.print();
		printTwo.scan();//자식클래스의 메소드 호출
		System.out.println("=============================================================");
	}
}
