package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//원본파일에 저장된 값을 문자데이타로 읽어 타겟파일에 전달하여 저장하는 프로그램 작성 - 파일 복사 프로그램
// => 텍스트 형식의 원본파일(문서파일)을 복사하여 타겟파일로 전달하여 저장 가능
// => 텍스트 형식의 파일을 제외한 원본파일(이진파일 - Binary File)은 값이 대한 인코딩 처리에
//의해 타겟파일에 변경된 값이 전달되어 저장
public class FileCopyCharApp {
	public static void main(String[] args) throws IOException {
		//BufferedReader 클래스 : Reader 객체를 전달받아 대량의 문자데이타를 읽기 위한 
		//입력스트림을 생성하기 위한 클래스
		BufferedReader in=null;
		
		//BufferedWriter 클래스 : Writer 객체를 전달받아 대량의 문자데이타를 전달하기 위한 
		//출력스트림을 생성하기 위한 클래스
		BufferedWriter out=null;
		
		try {
			in=new BufferedReader(new FileReader("c:/data/bandizip.exe"));
			
			out=new BufferedWriter(new FileWriter("c:/data/bandizip_char.exe"));
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일을 찾을 수 없습니다.");
		} finally {
			in.close();
			out.close();
		}
	}
}
