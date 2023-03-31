package basic;

//자료형 변환(TypeCast) : 값의 자료형을 일시적으로 변환하여 사용하는 방법
// => 자동 형변환(JVM), 강제 형변환(프로그래머)
public class TypeCastApp {
	public static void main(String[] args) {
		//자동 형변환 : 자료형이 다른 값을 연산하기 위해 JVM(Java Virtual Machine : Java 
		//프로그램을 실행하기 위한 가상의 플렛폼)이 자료형을 일시적으로 변환
		// => 표현의 범위가 작은 자료형의 값이 큰 자료형의 값으로 형변환되어 연산 처리
		// => byte >> short >> char >> int >> long >> float >> double
		System.out.println("결과 = "+(3+1.5));//3(int)+1.5(double) >> 3.0(double)+1.5(double) >> 4.5(double)
		
		double su=10;//10 >> 10.0
		System.out.println("su = "+su);
		
		System.out.println("결과 = "+(95/10));//int/int >> int
		System.out.println("결과 = "+(95.0/10.0));//double/double >> double
		System.out.println("결과 = "+(95.0/10));//double/int >> double/double(자동 형변환) >> double
		System.out.println("결과 = "+(95/10.));//int/double >> double(자동 형변환)/double >> double
		
		int kor=95, eng=90;//점수 입력
		int tot=kor+eng;//총점 계산
		//double ave=tot/2;//평균 계산 - 연산 결과값 : 정수값(92) >> 실수값(92.0)으로 변환되어 변수에 저장
		double ave=tot/2.;//평균 계산 - 연산 결과값 : 실수값(92.5)
		System.out.println("총점 = "+tot+", 평균 = "+ave);
		
		//int 자료형보다 작은 자료형의 값은 무조건 int 자료형으로 형변환되어 연산 처리
		byte su1=10, su2=20;
		//byte su3=su1+su2;//byte+byte >> int+int >> int : byte 변수에 저장 불가능
		int su3=su1+su2;		
		System.out.println("su3 = "+su3);
		System.out.println("==============================================================");
		//강제 형변환 : 프로그래머가 Cast 연산자를 사용하여 원하는 자료형의 값으로 일시적으로
		//변환하여 명령을 작성하는 방법 - (자료형)값
		int num=(int)12.3;//(int)12.3 >> 12
		System.out.println("num = "+num);
		
		int num1=95, num2=10;
		//double num3=num1/num2;//연산결과 : 9.0
		double num3=(double)num1/num2;//연산결과 : 9.5
		System.out.println("num3 = "+num3);
		
		//큰 정수값은 _ 기호를 사용하여 표현 가능
		int num4=100_000_000, num5=30;
		//정수값에 대한 연산 결과값은 4Byte(-2148483648~2147483647)로만 표현 가능
		//문제점)정수값에 대한 연산 결과값이 4Byte로 표현 가능한 범위를 벗어난 경우 쓰레기값 발생
		// => 변수에 쓰레기값이 저장되어 잘못된 결과값 출력 - 실행 오류
		//int num6=num4*num5;
		//해결법)정수값에 대한 연산 결과값이 8Byte(LongType)로 표현될 수 있도록 강제 형변환
		// => 8Byte의 연산 결과값을 저장하기 위해 변수를 long 자료형으로 선언
		long num6=(long)num4*num5;
		System.out.println("num6 = "+num6);
		
		double number=1.23456789;
		System.out.println("number = "+number);
		
		//소숫점 2자리 위치까지만 출력되도록 명령 작성
		System.out.println("number(내림) = "+(int)(number*100)/100.0);
		System.out.println("number(반올림) = "+(int)(number*100+0.5)/100.0);
		System.out.println("number(올림) = "+(int)(number*100+0.9)/100.0);
	}
}
