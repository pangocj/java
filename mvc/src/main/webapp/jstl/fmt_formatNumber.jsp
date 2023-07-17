<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Formatter - 숫자 변환 태그</h1>
	<hr>
	<c:set var="price" value="1000000000"/>
	<p>가격 = ${price }원</p>
	
	<%-- formatNumber 태그 : 숫자값을 원하는 패턴의 문자열로 변환하여 제공하는 태그 --%>
	<%-- => DecimalFormat 클래스의 format() 메소드와 유사한 기능 제공 --%>
	<%-- value 속성 : 숫자값을 속성값으로 설정 -  EL를 사용하여 숫자값을 제공받아 속성값으로 사용 --%>
	<%-- => 속성값으로 제공받은 값이 숫자값이 아닌 경우 NumberFormatException 발생 --%>
	<%-- type 속성 : number(숫자) 또는 currency(화폐) 중 하나를 속성값으로 설정 --%>
	<%-- => type 속성을 생략한 경우 [number] 속성값을 기본값으로 사용 --%>
	<%-- => type 속성값을 [number]로 설정한 경우 숫자 3자리마다 [,]기호를 삽입한 문자열로 변환하여 제공 --%>	
	<%-- => type 속성값을 [currency]로 설정한 경우 앞부부분에 화폐단위를 출력하고 숫자 3자리
	마다 [,]기호를 삽입한 문자열로 변환하여 제공 --%>	
	<p>가격 = <fmt:formatNumber value="${price}" type="number"/>원</p>
	<p>가격 = <fmt:formatNumber value="${price}" type="currency"/></p>
	
	<%-- setLocale : 장소를 변경하는 태그 - 나라별로 날짜와 시간 또는 화폐단위를 변경  --%>
	<%-- value 속성 : 장소(언어_나라)를 속성값으로 설정 --%>
	<fmt:setLocale value="en_us"/>
	<p>가격 = <fmt:formatNumber value="${price}" type="currency"/></p>

	<fmt:setLocale value="ja_jp"/>
	<p>가격 = <fmt:formatNumber value="${price}" type="currency"/></p>
	
	<fmt:setLocale value="ko_kr"/>
	<p>가격 = <fmt:formatNumber value="${price}" type="currency"/></p>
	
	<c:set var="pi" value="3.141592"/>
	<p>원주율 = ${pi }</p>
	<%-- pattern 속성 : 숫자값을 변환하기 위한 패턴정보를 속성값으로 설정 --%>
	<%-- => 반올림하여 원하는 소숫점 자릿수만큼 출력 처리 --%>
	<p>원주율 = <fmt:formatNumber value="${pi } " pattern="#.##"/></p>
	<p>원주율 = <fmt:formatNumber value="${pi } " pattern="#.###"/></p>
	
	<c:set var="avg" value="70.5"/>
	<%-- [#] 패턴문자를 사용하면 소숫점 자릿수의 값이 없으면 공백으로 표현 --%>
	<p>평균 = <fmt:formatNumber value="${avg } " pattern="#.##"/></p>
	<%-- [0] 패턴문자를 사용하면 소숫점 자릿수의 값이 없어도 0으로 표현 --%>
	<p>평균 = <fmt:formatNumber value="${avg } " pattern="##.00"/></p>
	<%-- [#] 패턴문자과 [0] 패턴문자를 소숫점 자릿수로 동시에 표현하면 에러 발생 --%>
	<%-- <p>평균 = <fmt:formatNumber value="${avg } " pattern="##.#0"/></p> --%>
</body>
</html>
