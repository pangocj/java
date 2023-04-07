package oop;

//학생정보(학번,이름,국어,영어,총점)를 저장하기 위한 클래스 - VO 클래스
public class Student {
	//필드(Field)
	private int num;
	private String name;
	private int kor, eng, tot;
	
	//생성자(Constructor)
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
}






