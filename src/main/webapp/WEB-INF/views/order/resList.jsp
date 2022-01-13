<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 예약 리스트</title>
<script type ="text/javascript" src ="/resources/js/jquery-3.6.0.min.js"></script>
<script type = "text/javascript">

	
function deleteOrder(){ // 예약 번호를 받아서 취소
	var result = confirm("정말 취소하겠습니까");
	
	if(result){
		location.href = "/order/reserve?resNum=${order.resNum}";
	}
}

function updateOrder(){  //  userNm가 같으면 수정 페이지로
	location.href = "/order/updateRes?userNm=${order.userNm}";
}

</script>
</head>
<body>
<h1>나의 예약 리스트</h1>
<h3>(예약 완료)</h3>

<%-- <c:if test = "${empty orderList }">
	예약된 리스트가 없습니다.<c:if test="${not empty orderList }"></c:if>
</c:if> --%>


<form>
<table border ="1">
		<tr>
			<th>예약 체크박스</th>
			<th>예약리스트</th>
		</tr>
		
		<tr>
			<td><label>
			<input type="checkbox" name ="resNum" value="resNum" >
			<td></td>
			</label></td>
		</tr>
</table>
</form>		


	function deleteOrder(){ // 예약 번호를 받아서 취소
		var result = confirm("정말 취소하겠습니까?");
		
		if(result){
			location.href = "/order/reserve?resNum=${order.resNum }";
		}
	}
	
	function updateOrder(){  //  userNm가 같으면 수정 페이지로
		location.href = "/order/updateRes?userNm=${order.userNm }";
	}
</script>
</head>
<body>
	<h1>나의 예약 리스트</h1>
	<h3>(예약 완료)</h3>
	
	<c:if test = "${empty orderList }">
		예약된 리스트가 없습니다.
	</c:if>
	
	<c:if test="${not empty orderList }">
		<c:forEach items ="${orderList }" var="order">
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
<%-- 				<tr>
					<td><input type="button" value="예약 취소" onclick="deleteOrder(${order.resNum});"></td>
					<td><input type="button" value="수정" onclick ="updateOrder(${order.userNm });"></td>
				</tr>  만일 orderList의 데이터가 2개이상 들어있다면 이 input태그도 2번 반복되서 나타납니다. 예약마다 수정삭제를 만들것인지, 하나의 수정삭제를 만들것인지--%>
			</table>
		</c:forEach>
	</c:if>

</body>
</html>