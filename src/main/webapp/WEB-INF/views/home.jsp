<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>메인화면</title>
	<script src="resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<p>[메인 화면]</p>
<c:if test="${loginName != null}">
	<h2>
	${sessionScope.loginName}(${sessionScope.loginId})님 환영합니다 !!!<br>
	</h2>
</c:if>



<c:if test="${loginName == null}">
	<a href="/user/login">로그인</a>
</c:if>
<c:if test="${loginName != null}">
	<a href="/user/logout">로그아웃</a>
</c:if>

<form>
	<h1>미용실 소개</h1>
	<p>   쟈끄데샹쥬 강남구청점은 건강하고 좋은 재료로 사용하기 위해 항상연구하고 고민합니다.
좋은 재료는 거짓말하지 않습니다.

디지털펌, 볼륨매직, 매직세팅, 염색, 컷트 전문브랜드 / 유기농 클린펌 / 유기농 클린컬러 / 크리닉모발두피 케어전문 / 모든 미용기기 살균소독 / 일회용 얼굴솜 사용 / 브런치 서비스 / 음료서비스 / 발렛가능 / 무선인터넷</p>
	<input type="button" value="예약버튼" onclick="location.href='/order/reserve';">
</form>


</body>
</html>
