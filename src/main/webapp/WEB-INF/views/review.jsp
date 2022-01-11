<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기</title>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function formChk(){
		var result = confirm("정말로 등록하시겠습니까?");
		
		if(result) {
			alert("작성해주셔서 감사합니다. 후기 내용은 메인에서 확인가능합니다.");
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<h2>후기 작성</h2>
	<form action="/review" method="post" onsubmit="return formChk();">
		<p>미용실에서 받은 시술</p>
		<p>평점</p>
		<textarea rows="10" cols="50"></textarea>
		<input type="submit" value="등록">
	</form>
</body>
</html>