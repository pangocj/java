package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileController {
	@RequestMapping(value = "/upload1", method = RequestMethod.GET)
	public String uploadOne() {
		return "file/form_one";
	}
	
	//요청 처리 메소드에 MultipartHttpServletRequest 인터페이스로 매개변수를 선언하면 Front
	//Controller에게 MultipartHttpServletRequest 객체를 제공받아 사용 가능
	//MultipartHttpServletRequest 객체 : [multipart/form-data] 형태로 전달된 값 또는 파일을 처리하기 위한 객체
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(MultipartHttpServletRequest request) throws IOException {
		//MultipartHttpServletRequest.getParameter(String name) : 전달값을 문자열(String 객체)로 반환하는 메소드
		String uploaderName=request.getParameter("uploaderName");
		
		//MultipartHttpServletRequest.getFile(String name) : 전달파일을 MultipartFile 객체로 반환하는 메소드
		// => MultipartFile 객체 : 사용자로부터 입력되어 전달된 파일정보를 저장하기 위한 객체
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		//전달받은 파일에 대한 검증 작성
		//MultipartFile.isEmpty() : MultipartFile 객체에 저장된 파일정보가 없는 경우 [false]를
		//반환하고 파일정보가 있는 경우 [true]를 반환하는 메소드
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//MultipartFile.getContentType() : MultipartFile 객체에 저장된 파일형태(MimeType)를 반환하는 메소드
		System.out.println("파일 형식 = "+uploadFile.getContentType());
		//MultipartFile.getBytes() : MultipartFile 객체에 저장된 전달파일을 원시데이타(byte 배열)로 반환하는 메소드
		System.out.println("파일 크기 = "+uploadFile.getBytes().length);
		
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=request.getServletContext().getRealPath("/resources/images/upload");
		System.out.println("uploadDirectory = "+uploadDirectory);
		
		//전달파일을 서버 디렉토리에 저장될 업로드 파일정보가 저장된 File 객체 생성
		//File 객체 : 시스템(서버)에 존재하는 파일정보를 저장하기 위한 객체
		//MultipartFile.getOriginalFilename() : MultipartFile 객체에 저장된 전달파일의 이름을 반환하는 메소드
		String uploadFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirectory, uploadFilename);
		
		//MultipartFile..transferTo(File file) : MultipartFile 객체에 저장된 전달파일을 File
		//객체의 시스템 파일(업로드 파일)로 전달하여 저장하는 메소드
		uploadFile.transferTo(file);//전달파일을 서버 디렉토리에 저장 - 업로드 처리
		
		request.setAttribute("uploaderName", uploaderName);
		request.setAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success";
	}
}











