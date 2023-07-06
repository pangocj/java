<?xml version="1.0" encoding="UTF-8"?>
<!-- XSL 문서 : XSLT 데이타를 저장한 XML 문서 -->
<!-- XSLT(eXtensible Stylesheet Language Template) : XML 기반의 언어로 작성된 파서(Parser) -->
<!-- => XML 문서를 전달받아 HTML 문서 또는 XML 문서로 변환하기 위한 정보 제공 -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- output : XML 문서를 전달받아 변환하여 제공되는 문서의 형식을 설정하는 엘리먼트 -->
	<!-- method 속성 : 변환되어 제공되는 문서의 형식을 속성값으로 설정 - 기본값 : xml -->
	<!-- encoding 속성 : 문서에서 사용하는 문자형태(캐릭터셋)을 속성값으로 설정 - 기본값 : iso-8859-1 -->
	<xsl:output method="html" encoding="utf-8"/>
	<!-- template : XML 문서를 변환하기 위한 정보를 제공하는 엘리먼트 -->
	<!-- match 속성 : XML 문서의 루트 엘리먼트를 속성값으로 설정 -->
	<xsl:template match="books">
		<ol>
			<!-- for-each : XML 문서의 엘리먼트(태그)를 반복 처리하기 위한 엘리먼트 -->
			<!-- select 속성 : 반복 처리하기 위한 엘리먼트의 이름(태그명)을 속성값으로 설정 -->
			<xsl:for-each select="book">
				<!-- value-of : XML 문서의 엘리먼트 내용(태그내용)을 제공하기 위한 엘리먼트 -->
				<!-- select 속성 : 값을 얻어오기 위한 엘리먼트의 이름(태그명)을 속성값으로 설정 -->
				<li><b><xsl:value-of select="title"/></b><xsl:value-of select="author"/></li>
			</xsl:for-each>
		</ol>
	</xsl:template>
</xsl:stylesheet>