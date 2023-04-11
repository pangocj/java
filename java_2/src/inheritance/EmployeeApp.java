package inheritance;

//사원 급여 관리 프로그램
public class EmployeeApp {
	public static void main(String[] args) {
		//추상클래스로 객체를 생성할 경우 에러 발생
		// => 추상클래스로 참조변수 생성 가능
		//Employee employee=new Employee();
		
		/*
		//부모클래스로 참조변수를 생성하여 자식클래스로 객체를 생성하여 저장 가능
		Employee employee1=new EmployeeRegular();
		Employee employee2=new EmployeeTime();
		Employee employee3=new EmployeeContract();
		*/
		
		Employee[] empArray=new Employee[5];
		
		empArray[0]=new EmployeeRegular(1000, "홍길동", 96000000);
		empArray[1]=new EmployeeTime(2000, "임꺽정", 50000, 150);
		empArray[2]=new EmployeeContract(3000, "전우치", 7000000);
		empArray[3]=new EmployeeTime(4000, "일지매", 20000, 100);
		empArray[4]=new EmployeeRegular(5000, "장길산", 60000000);
		
		for(Employee employee : empArray) {
			System.out.println("사원번호 = "+employee.getEmpNo());
			System.out.println("사원이름 = "+employee.getEmpName());
	
			/*
			//사원급여를 반환받아 출력
			// => 참조변수는 부모클래스의 개겣만 참조 가능하므로 자식클래스의 메소드 호출 불가능
			// => 명시적 객체 형변환을 이용하여 참조변수로 자식클래스의 객체를 참조하여 메소드 호출 가능
			// => instanceof 연산자를 사용하여 자식클래스를 구분하여 객체 형변환 - ClassCastException 방지
			if(employee instanceof EmployeeRegular) {
				System.out.println("사원급여 = "+((EmployeeRegular)employee).computeSalary());
			} else if(employee instanceof EmployeeTime) {
				System.out.println("사원급여 = "+((EmployeeTime)employee).computeTimePay());
			} else if(employee instanceof EmployeeContract) {
				System.out.println("사원급여 = "+((EmployeeContract)employee).computeContract());
			}
			*/

			//자식클래스에서 부모클래스의 메소드를 오버라이드 선언하면 묵시적 객체 형변환에
			//의해 자동으로 참조변수가 자식클래스로 형변환되어 자식클래스의 메소드 호출 가능
			System.out.println("사원급여 = "+employee.computePay());
			
			//사원의 인센티브를 반환받아 출력
			System.out.println("인센티브 = "+employee.computeIncentive());
			System.out.println("==========================================================");
		}
	}
}
