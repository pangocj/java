<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학생정보를 전달받아 STUDENT 테이블의 행으로 삽입하고 [displayStudent.jsp] 문서를 요청할
수 있는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>    
<%
	//JSP 문서를 GET 방식으로 요청한 경우 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
		response.sendRedirect("insertFormStudent.jsp");//클라이언트에게 URL 주소 전달
		return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");

	//전달값을 반환받아 변수에 저장
	int no=Integer.parseInt(request.getParameter("no"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	String birthday=request.getParameter("birthday");

	//DTO 클래스로 객체를 생성하여 전달값으로 필드값 변경
	StudentDTO student=new StudentDTO();
	student.setNo(no);	
	student.setName(name);	
	student.setPhone(phone);	
	student.setAddress(address);	
	student.setBirthday(birthday);	
	
	//사용자로부터 입력받아 전달된 학생번호가 STUDENT 테이블에 저장된 기존 학생정보의 학생번호와
	//중복될 경우 [insertFormStudent.jsp] 문서로 이동할 수 있는 URL 주소를 클라이언트에게 전달
	//학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	// => null 반환 : 학생정보 미검색 - 학생번호 미중복, StudentDTO 객체 반환 : 학생정보 검색 - 학생번호 중복
	if(StudentDAO.getDAO().selectStudent(no)!=null) {//학생번호가 중복된 경우
		session.setAttribute("message", "이미 사용중인 학생번호를 입력 하였습니다. 다시 입력해 주세요.");
		session.setAttribute("student", student);
		response.sendRedirect("insertFormStudent.jsp");//클라이언트에게 URL 주소 전달
		return;
	}
	
	//학생정보를 전달받아 STUDENT 테이블의 행으로 삽입하는 DAO 클래스의 메소드 호출
	StudentDAO.getDAO().insertStudent(student);
	
	//클라이언트에게 URL 주소 전달
	response.sendRedirect("displayStudent.jsp");
%>
