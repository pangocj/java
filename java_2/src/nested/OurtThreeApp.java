package nested;

public class OurtThreeApp {
	public static void main(String[] args) {
		OuterThree outerThree=new OuterThree(100);
		
		outerThree.outerDisplay();
		outerThree.local();
	}
}
