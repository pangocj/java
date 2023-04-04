package basic;

//2차원 배열 : 1차원 배열의 모임
public class DoubleArrayApp {
	public static void main(String[] args) {
		//형식) 자료형[][] 참조변수 = new 자료형[행갯수][열갯수];
		// => 행갯수 : 2차원 배열에 생성되는 1차원 배열의 갯수
		// => 열갯수 : 1차원 배열에 생성되는 요소의 갯수
		int[][] num=new int[2][3];
		
		System.out.println("num = "+num);
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1] = "+num[1]);
		System.out.println("==============================================================");
		//2차원 배열에서는 값이 저장된 요소에 접근하기 위해 첨자를 2개 사용
		System.out.println("num[0][0] = "+num[0][0]);
		System.out.println("num[0][1] = "+num[0][1]);
		System.out.println("num[0][2] = "+num[0][2]);

		System.out.println("num[1][0] = "+num[1][0]);
		System.out.println("num[1][1] = "+num[1][1]);
		System.out.println("num[1][2] = "+num[1][2]);
		System.out.println("==============================================================");
		System.out.println("num.length = "+num.length);
		System.out.println("num[0].length = "+num[0].length);
		System.out.println("num[1].length = "+num[1].length);
		System.out.println("==============================================================");
		for(int i=0;i<num.length;i++) {//1차원 배열(행)을 일괄처리 하기 위한 반복문
			for(int j=0;j<num[i].length;j++) {//요소(열)를 일괄처리 하기 위한 반복문
				System.out.print(num[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
		//int[][] su=new int[][] {{10,20,30},{40,50,60},{70,80,90}};
		int[][] su={{10,20,30},{40,50,60},{70,80,90}};
		
		for(int[] array : su) {
			for(int temp : array) {
				System.out.print(temp+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
		//1차원 배열의 요소의 갯수가 정해져 있지 않은 2차원 배열 선언
		// => 1차원 배열의 메모리 주소를 저장하는 참조요소만 생성되고 1차원 배열은 미생성
		// => 2차원 배열의 참조요소는 null 저장
		int[][] value=new int[3][];
		
		System.out.println("value = "+value);
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
		System.out.println("==============================================================");
		//2차원 배열의 참조요소에 1차원 배열을 생성하여 메모리 주소 저장
		// => 1차원 배열의 요소의 갯수를 다르게 생성하여 저장 가능 - 가변배열
		value[0]=new int[3];
		value[1]=new int[2];
		value[2]=new int[4];
		
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
		System.out.println("==============================================================");
		//Java는 다차원 배열을 가변배열로 선언 가능
		int[][] array={{10,20,30},{40,50},{60,70,80,90}};
		
		for(int[] arr : array) {
			for(int temp : arr) {
				System.out.print(temp+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
	}
}