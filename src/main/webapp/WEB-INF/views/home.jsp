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
	<p>미용실 소개</p>
	<input type="button" value="예약버튼" onclick="location.href='/order/reserve';">
</form>


</body>
</html>
