<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 현재 날짜와 시간 및 음원챠트를 JSON 형식의 데이타로 제공하는 JSP 문서 --%>    
<%
	String now=new SimpleDateFormat("yyyy년 MM월 dd일 HH시").format(new Date());
%> 
{
	"now":"<%=now %>",
	"songs":[
		{"title":"퀸카(Queencard)", "singer":"(여자)아이들"},{"title":"I AM", "singer":"IVE(아이브)"}
		,{"title":"Spicy", "singer":"aespa"},{"title":"이브, 프시케 그리고 푸른 수염의 아내", "singer":"LE SSERAFIM(르세라핌)"}
		,{"title":"UNFORGIVEN(feat. Nile Rodgers)", "singer":"LE SSERAFIM(르세라핌)"},{"title":"Kitsch", "singer":"IVE(아이브)"}
		,{"title":"헤어지자 말해요", "singer":"박재정"},{"title":"사랑은 늘 도망가", "singer":"임영웅"}
		,{"title":"모래 알갱이", "singer":"임영웅"},{"title":"우리들의 블루스", "singer":"임영웅"}
	]
}