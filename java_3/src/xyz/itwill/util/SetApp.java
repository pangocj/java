package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//콜렉션 클래스(Collection Class) : 자료구조(Data Structure)를 사용하여 다수의 객체를 효율적으로
//관리(추가,삭제,검색)하기 위한 기능을 제공하는 데이타 수집 클래스들을 표현
// => Collection 인터페이스(Set 인터페이스, List 인터페이스), Map 인터페이스 중 하나를 
//상속받아 작성된 클래스

//Set 인터페이스를 상속받은 콜렉션 클래스 - HashSet, TreeSet 등
// => 객체의 저장 순서가 없으며 메모리 주소와 객체에 저장된 값이 동일한 객체의 중복 저장 불가
public class SetApp {
	public static void main(String[] args) {
		//제네릭을 사용하지 않고 HashSet 클래스로 객체 생성 - 비권장
		// => HashSet 객체에는 모든 클래스의 객체를 Object 타입으로 저장 가능
		// => HashSet 객체에 저장된 객체를 반환받아 사용할 경우 반드시 명시적 객체 형변환 사용
		//HashSet set=new HashSet();
		
		//제네릭을 사용하여 HashSet 클래스로 객체 생성 - 권장
		// => HashSet 클래스의 제네릭 타입에 전달된 클래스의 객체만 저장 가능
		// => HashSet 객체에 저장된 객체는 명시적 객체 형변환 없이 사용 가능
		//HashSet<String> set=new HashSet<String>();
		
		//참조변수는 클래스가 상속받은 인터페이스(부모)를 이용하여 선언하는 것을 권장
		// => 참조변수에는 인터페이스를 상속받은 모든 자식클래스의 객체 저장 가능
		// => 클래스간의 결합도를 낮춰 유지보수의 효율성 증가
		Set<String> set=new HashSet<String>();
		
		//Set.add(E element) : Set 객체에 요소를 추가하는 메소드 - 저장 순서 미제공
		//요소(Element) : 콜렉션 클래스의 객체에 제네릭 타입으로 전달되어 저장된 객체
		set.add("홍길동");
		//set.add(12.34);//Set 객체에 String 객체를 제외한 객체를 요소를 추가할 경우 에러 발생
		set.add("임꺽정");
		set.add("전우치");
		
		//Set.toString() : Set 객체에 저장된 모든 요소값(객체)를 문자열로 변환하여 반환하는 메소드
		//System.out.println("set.toString() = "+set.toString());
		System.out.println("set = "+set);
		System.out.println("===============================================================");
		//Set 객체는 동일한 객체가 요소로 중복 저장되지 않는 기능 제공
		set.add("홍길동");
		System.out.println("set = "+set);
		System.out.println("===============================================================");
		//Set.size() : Set 객체에 저장된 요소의 객체를 반환하는 메소드
		System.out.println("요소의 갯수 = "+set.size());
		System.out.println("===============================================================");
		//Set.remove(E element) : 매개변수로 전달받은 객체와 동일한 요소를 Set 객체에서 삭제하는 메소드
		set.remove("임꺽정");
		System.out.println("set = "+set);
		System.out.println("===============================================================");
		//Set.iterator() : Set 객체에 저장된 요소를 반복 처리할 수 있는 Iterator 객체를 반환하는 메소드
		//Iterator 객체 : 콜렉션 클래스의 객체에 저장된 요소를 반복 처리 위한 기능을 제공하는 객체
		// => 반복 지시자 : 커서(Cursor)를 사용하여 콜렉션 객체의 요소를 반복 처리
		Iterator<String> iterator=set.iterator();
		
		//Iterator 객체를 사용하여 Set 객체에 저장된 모든 요소에 대한 일괄처리
		//Iterator.hasNext() : Iterator 객체로 처리 가능한 요소의 존재 유무를 반환하는 메소드
		// => false : 처리 요소 미존재, true : 처리 요소 존재
		while(iterator.hasNext()) {
			//Iterator.next() : 커서 위치의 요소(객체)를 반환하는 메소드
			// => 커서 위치의 요소를 반환하고 커서는 다음 요소의 위치로 자동 이동
			String str=iterator.next();
			System.out.print(str+" ");
		}
		System.out.println();
		System.out.println("===============================================================");
		//향상된 for 구문을 사용하여 Set 객체에 저장된 모든 요소에 대한 일괄처리 가능
		// => 향상된 for 구문을 사용하면 내부적으로 Iterator 객체를 사용하여 반복 처리
		for(String str : set) {
			System.out.print(str+" ");
		}
		System.out.println();
		System.out.println("===============================================================");
	}
}