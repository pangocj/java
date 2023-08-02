package xyz.itwill08.dao;

import lombok.Data;

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE   
*/

//학생정보를 저장하기 위한 클래스 - DTO 클래스
@Data
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
