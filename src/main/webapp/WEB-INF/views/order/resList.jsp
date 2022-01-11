<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 예약 리스트</title>
<script type ="text/javascript" src ="/resources/js/jquery-3.6.0.min.js">
</script>
</head>
<body>
<h1>나의 예약 리스트</h1>
<h3>(예약 완료)</h3>

<table border ="1">
	<tr>
		<th colspan="2">예약 내용확인</th>
	</tr>
	<tr>
		<th colspan= "2">디자이너</th>
	</tr>
	<tr>
		<th colspan="2">날짜 및 시간</th>
	</tr>
	<tr>
		<th colspan="2">위치</th>
	</tr>
	<tr>
		<td><input type="button" value="예약 취소"></td>
		<td><input type="button" value="수정"></td>
	</tr>
</table>
</body>
</html>