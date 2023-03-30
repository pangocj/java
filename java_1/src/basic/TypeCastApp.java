package basic;

//자료형 변환(TypeCast) : 값의 자료형을 일시적으로 변환하여 사용하는 방법
// => 자동 형변환(JVM), 강제 형변환(프로그래머)
public class TypeCastApp {
	public static void main(String[] args) {
		//자동 형변환 : 자료형이 다른 값을 연산하기 위한 JVM(Java Virtual Machine : Java 
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
	}
}















