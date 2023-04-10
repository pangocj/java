package oop;

//static 키워드 : 객체가 아닌 클래스로 접근하기 위한 기능을 제공하는 제한자
// => 클래스(내부 클래스), 필드, 메소드 작성시 사용
//제한자(Modifier) : 특별한 기능(제한)을 제공하기 위해 사용하는 키워드
// => Access Modifier(private, package, protected, public), static, final, abstract  

//학생정보(학번,이름,국어,영어,총점)를 저장하기 위한 클래스 - VO 클래스
public class Student {
	//인스턴스 필드(Instance Field) : 객체가 생성될 때 메모리(HeapArea)에 생성되는 필드
	private int num;
	private String name;
	private int kor, eng, tot;
	
	//정적 필드(Static Field) : 클래스를 읽어 메모리(MethodArae)에 저장될때 생성되는 필드
	// => 객체가 생성되기 전에 메모리에 하나만 생성되는 필드
	// => 생성자에서 초기화 처리하지 않고 직접 초기값을 필드에 저장
	// => 클래스로 생성된 모든 객체가 정적 필드 사용 가능 - 공유값 : 메모리 절약 및 필드값 변경 용이
	// => 클래스 외부에서는 객체가 아닌 클래스를 사용하여 접근 가능
	private static int total=0;//기본값을 초기값으로 사용할 경우 초기값 저장 생략 가능
	
	//생성자(Constructor) : 객체를 생성하면서 인스턴스 필드에 원하는 초기값을 저장하기 위해 작성
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
		//총점을 계산하여 필드에 저장하는 명령 작성 - 메소드 호출
		// => 코드의 중복성을 최소화하여 프로그램의 생산성 및 유지보수의 효율성 증가
		//tot=kor+eng;
		calcTot();
	}

	//인스턴스 메소드(Instance Method) : this 키워드가 제공되는 메소드
	// => this 키워드를 이용하여 인스턴스 필드 및 메소드 접근 가능
	// => 클래스를 사용하여 정적 필드 및 메소드 접근 가능 - 클래스 생략 가능
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calcTot();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTot();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	/*
	public void calcTot() {//총점을 계산하는 메소드
		tot=kor+eng;
	}
	*/

	//은닉화 선언된 메소드 - 클래스 내부에서만 호출하여 사용하는 메소드
	// => 코드의 중복성을 최소화하기 위한 기능을 제공하는 메소드
	private void calcTot() {//총점을 계산하는 메소드
		tot=kor+eng;
	}
	
	public void display() {
		System.out.print("["+name+"]님의 성적 >> ");
		System.out.println("국어 = "+kor+", 영어 = "+eng+", 총점 = "+tot);
	}

	//정적 메소드(Static Method) : this 키워드를 제공하지 않는 메소드
	// => this 키워드가 없으므로 인스턴스 필드 및 메소드 접근 불가능
	// => 클래스를 사용하여 정적 필드 및 메소드 접근 가능 - 클래스 생략 가능
	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Student.total = total;
	}
}
