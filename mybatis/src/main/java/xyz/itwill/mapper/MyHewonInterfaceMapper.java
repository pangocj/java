package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import xyz.itwill.dto.MyHewon;

//mybatis 프레임워크는 Interface 기반의 매퍼 파일만 사용하여 매퍼 등록 가능
// => 인터페이스의 추상메소드에 매퍼 어노테이션을 사용하여 SQL 명령 등록
public interface MyHewonInterfaceMapper {
	//추상메소드에 등록된 SELECT 명령은 기본적으로 검색행을 자동 매핑하여 객체로 제공
	// => 자동 매핑 기능을 사용하여 검색행을 객체로 생성하기 위해 검색행의 컬럼명과 객체를
	//생성할 클래스의 필드명을 동일하게 작성
	// => 검색행의 컬럼명과 클래스의 필드명이 하나도 같지 않은 경우 객체 대신 NULL 제공
	//@Results : 검색행을 객체로 생성하여 제공하기 위한 매핑 정보를 설정하는 어노테이션
	// => XML 기반의 매퍼 파일에서 resultMap 엘리먼트와 유사한 기능 제공
	//value 속성 : 검색행의 컬럼값을 객체 필드에 저장하기 위한 매핑정보를 제공하는 Result
	//어노테이션에 여러개 저장된 배열을 속성값 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@Results(value = {
		//@Result : 검색행의 컬럼값을 객체 필드에 저장하기 위한 정보를 제공하는 어노테이션
		// => XML 기반의 매퍼 파일에서 id 엘리먼트(result 엘리먼트)와 유사한 기능 제공
		//column 속성 : 검색행의 컬럼명(컬럼값)을 속성값으로 설정
		//property 속성 : 검색행의 컬럼값이 저장될 객체의 필드명을 속성값으로 설정	
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	@Select(value = "select * from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();

	//@Results 어노테이션의 매핑 정보를 다른 추상메소드에서 재사용 불가능 - 유지보수의 효율성 감소
	@Results(value = {
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	@Select("select * from myhewon where hewon_name=#{name} order by hewon_id")
	List<MyHewon> selectNameHewonList(String name);

	/*
	@Results(value = {
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	//@SelectProvider : SQL 명령을 생성하여 반환하는 클래스(SQL Builder 클래스)의 메소드를  
	//호출하여 SELECT 명령을 반환받아 등록하는 어노테이션
	// => Interface 기반의 매퍼 파일에서 동적 SQL 기능을 구현하기 위해 사용하는 어노테이션
	//SQL Builder 클래스 : SQL 객체의 메소드를 호출하여 SQL 명령을 작성하고 SQL 객체에 저장된
	//SQL 명령을 반환하는 기능을 제공하는 클래스
	//type 속성 : SQL Builder 클래스(Class 객체)를 속성값으로 설정
	//method 속성 : SQL Builder 클래스의 SQL 명령을 생성하는 반환하는 메소드를 속성값으로 설정
	@SelectProvider(type = MyHewonProvider.class, method = "selectDynamicName")
	List<MyHewon> selectDynamicHewonList(String name);
	*/
	
	@Results(value = {
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	//@SELECT 어노테이션의 value 속성값으로 script 엘리먼트를 사용하면 SQL 명령 작성시 Interface
	//매퍼 파일에서 동적 SQL 관련 엘리먼트 사용 가능
	// => value 속성값으로 배열을 설정하여 SQL 명령을 순차적으로 작성 가능 
	@Select({"<script>select hewon_id, hewon_name, hewon_phone, hewon_email, hewon_status from myhewon"
			,"<if test=\"name != null and name != ''\">where hewon_name = #{name}</if>" 
			,"order by hewon_id</script>"})
	List<MyHewon> selectDynamicHewonList(String name);
}
