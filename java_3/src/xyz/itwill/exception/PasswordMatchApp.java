package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값을 입력받아 저장된 비밀번호와 비교하여 비교결과를 출력하는 프로그램
public class PasswordMatchApp {
	public static void main(String[] args) {
		/*
		int password=123456;
	
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("비밀번호 입력 >> ");
		int number=scanner.nextInt();
		
		if(number==password) {
			System.out.println("[결과]입력된 비밀번호가 맞습니다.");
		} else {
			System.out.println("[결과]입력된 비밀번호가 틀림니다.");
		}
		
		scanner.close();
		*/
		
		int password=123456;
		
		Scanner scanner=new Scanner(System.in);
		
		try {
			System.out.print("비밀번호 입력 >> ");
			int number=scanner.nextInt();
			
			if(number!=password) {
				//인위적으로 예외 객체를 생성하여 예외를 발생시키는 명령
				//형식) throw new 예외클래스(String message);
				//throw new Exception();
				//PasswordMismatchException 클래스는 개발자가 직접 생성한 예외클래스로 
				//예외처리를 하지 않을 경우 에러 발생 - 일반 예외
				// => 예외가 발생되면 catch 구문으로 프로그램의 흐름이 이동
				throw new PasswordMismatchException("[결과]입력된 비밀번호가 틀림니다.");
			}
			
			//예외가 발생되지 않은 경우 실행될 명령
			System.out.println("[결과]입력된 비밀번호가 맞습니다.");

		} catch (InputMismatchException e) {
			System.out.println("[에러]숫자만 입력 가능합니다.");
		} catch (PasswordMismatchException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		} finally {
			scanner.close();
		}
	}
}
