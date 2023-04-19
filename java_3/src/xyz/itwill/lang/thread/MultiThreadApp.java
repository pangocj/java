package xyz.itwill.lang.thread;

//다중 스레드 프로그램
// => 프로그램 개발자가 직접 스레드를 생성하여 다수의 명령을 동시에 실행되도록 만든 프로그램
// => 프로그램의 모든 스레드가 소멸돼야만 프로그램 종료
// => GUI 프로그램 및 Web 프로그램 등은 다중 스레드 프로그램으로 작성

//프로그램 개발자가 스레드를 생성하여 명령을 실행하는 방법-1 : Thread 클래스 이용
//1.Thread 클래스를 상속받은 자식클래스 작성
//2.Thread 클래스를 상속받은 자식클래스에서 run() 메소드를 오버라이드 선언
// => run() 메소드에는 프로그램 개발자에 의해 생성된 스레드가 실행하기 위한 명령 작성
//3.Thread 클래스를 상속받은 자식클래스로 객체 생성 - Thread(부모클래스) 객체 생성
//4.Thread 객체로 start() 메소드 호출 - Thread 객체를 이용하여 새로운 스레드 생성
// => 생성된 스레드는 자동으로 Thread 객체의 run() 메소드를 호출하여 run() 메소드의 명령 실행

//프로그램 개발자가 스레드를 생성하여 명령을 실행하는 방법-2 : Runnable 인터페이스 이용
// => 클래스가 이미 다른 클래스를 상속받아 Thread 클래스를 상속받지 못하는 경우 Runnable 
//인터페이스를 상속받아 새로운 스레드를 생성하기 위한 방법
//1.Runnable 인터페이스를 상속받은 자식클래스 작성
//2.Runnable 인터페이스를 상속받은 자식클래스에서 run() 메소드를 오버라이드 선언
// => run() 메소드에는 프로그램 개발자에 의해 생성된 스레드가 실행하기 위한 명령 작성
//3.Thread 클래스로 Thread 객체를 생성 - Thread 클래스의 생성자 중 매개변수에 Runnable 
//인터페이스를 상속받은 자식클래스의 객체를 전달하여 Thread 객체를 생성하는 생성자 이용
//4.Thread 객체로 start() 메소드 호출

public class MultiThreadApp {
	//JVM에 의해 main 스레드가 자동으로 생성되어 main() 메소드를 호출해 main() 메소드의 명령 실행
	// => main()에 의해 전달된 예외는 JVM에 의해 자동으로 예외 처리
	public static void main(String[] args) throws InterruptedException {
		/*
		//Thread 클래스로 직접 객체를 생성하여 start() 메소드 호출
		// => 새롭게 생성된 스레드는 Thread 객체의 명령이 없는 run() 메소드 호출 - 무의미
		Thread thread=new Thread();
		thread.start();
		*/
		
		/*
		MultiThreadOne one=new MultiThreadOne();
		//Thread.start() : Thread 객체로 새로운 스레드를 생성하기 위한 메소드
		// => 생성된 스레드는 자동으로 Thread 객체의 run() 메소드(숨겨진 메소드)를 호출
		// => 자식클래스의 오버라이드 선언된 run() 메소드가 호출되어 명령 실행
		one.start();
		//하나의 Thread 객체는 하나의 스레드 생성만 가능
		// => Thread 객체를 사용하여 start() 메소드를 여러번 호출할 경우 IllegalThreadStateException 발생
		// => 다중 스레드 프로그램에서 예외가 발생된 경우 예외가 발생된 스레드만 소멸
		one.start();//예외가 발생되면 main 스레드 소멸
		*/
		
		//Thread 객체를 사용하여 start() 메소드외에 다른 메소드를 호출하지 않을 경우 참조변수에
		//객체를 저장하지 않고 객체를 생성하여 직접 메소드 호출
		new MultiThreadOne().start();
		new MultiThreadOne().start();
		
		new Thread(new MultiThreadTwo()).start();
		
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
			//Thread.sleep(long ms) : 매개변수로 전달된 시간(ms)동안 스레드를 일시중지하는 메소드
			// => 메소드에서 InterruptedException 전달 - 일반 예외이므로 예외처리를 하지 않으면 에러 발생
			Thread.sleep(500);
		}
	}
}
