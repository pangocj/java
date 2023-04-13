package nested;

import nested.OuterOne.InnerOne;

public class OuterOneApp {
	public static void main(String[] args) {
		OuterOne outerOne=new OuterOne(100);
		outerOne.outerDisplay();
		System.out.println("==============================================================");
		//객체 내부클래스의 생성자를 직접 호출하여 객체 생성 불가능 
		//InnerOne innerOne=new InnerOne(200);
		
		//외부클래스의 객체를 사용하여 객체 내부클래스의 생성자를 호출하여 객체 생성 가능
		InnerOne innerOne=outerOne.new InnerOne(200);
		innerOne.innerDisplay();
		System.out.println("==============================================================");
	}
}
