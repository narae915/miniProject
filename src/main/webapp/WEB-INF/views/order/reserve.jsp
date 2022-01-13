<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약</title>
	<script type = "text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		function reserve(userId) 
		{
			var resIndate = document.querySelector("input[type='date']").value;
			var resIntime = document.getElementById("resIntime").value;
			var desNumS = $("input[name='desNum']:checked").val();
			var hairType = $("#hairType1").val(); 
			var priceS = $("#hairType1").find("option:selected").data("price");

			if(confirm("예약을 확정하시겠습니까?") == true)
			{
				$.ajax
				({
					url: "/order/reserve",
					type: "post",
					data:
					{
						resIndate: resIndate,
						resIntime: resIntime,
						desNumS: desNumS,
						hairType: hairType,
						priceS: priceS
					}
				})
				
				location.href = "/order/resList?userId=${order.userId }";
			}
			else
			{
				return;
			}
		}
	</script>
</head>
<body>
	<h1>[ 예약 ]</h1>

	<form action = "/updateRes" method = "post">
		<table>
			<tr>
				<td>
					<label>
						<input type = "radio" name = "desNum" value = "1" checked = "checked">
						<img src = "/resources/image/image1.jpg" alt = "디자이너1" height = "490" width = "490">
					</label>
				</td>
				<td>
					<label>
						<input type = "radio" name = "desNum" value = "2">
						<img src = "/resources/image/image2.jpg" alt = "디자이너2" height = "490" width = "490">
					</label>
				</td>
			</tr>
			<tr>
				<td>카나다 원장</td>
				<td>오키나와 디자이너</td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "date" id = "resIndate" name = "resIndate" value = "">
					<select id = "resIntime" name = "resIntime">
						<option selected>예약 시간</option>
						<option value = "10:00">10:00</option>
						<option value = "10:30">10:30</option>
						<option value = "11:00">11:00</option>
						<option value = "11:30">11:30</option>
						<option value = "12:00">12:00</option>
						<option value = "12:30">12:30</option>
						<option value = "13:00">13:00</option>
						<option value = "13:30">13:30</option>
						<option value = "14:30">14:30</option>
						<option value = "15:00">15:00</option>
						<option value = "15:30">15:30</option>
						<option value = "16:00">16:00</option>
						<option value = "16:30">16:30</option>
						<option value = "17:00">17:00</option>
						<option value = "17:30">17:30</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>시술메뉴선택
					<select id = "hairType1" name = "hairType1">
						<option selected>컷</option>
						<option value = "남성컷" data-price = "15000">남성컷</option>
						<option value = "레이어드" data-price = "19000">레이어드</option>
						<option value = "태슬컷" data-price = "20000">태슬컷</option>
						<option value = "페이스라인컷" data-price = "5000">페이스라인컷</option>
						<option value = "허쉬컷" data-price = "18000">허쉬컷</option>
					</select>
					<select id = "hairType2" name = "hairType2">
						<option selected>펌</option>
						<option value = "그레이스펌">그레이스펌</option>
						<option value = "매직" data-price = "80000">매직</option>
						<option value = "볼륨매직" data-price = "100000">볼륨매직</option>
						<option value = "빌드펌" data-price = "100000">빌드펌</option>
						<option value = "웨이브펌" data-price = "150000">웨이브펌</option>
						<option value = "허쉬펌" data-price = "160000">허쉬펌</option>
						<option value = "히피펌" data-price = "150000">히피펌</option>
					</select>
					<select id = "hairType3" name = "hairType3">
						<option selected>컬러</option>
						<option value = "뿌리염색" data-price = "60000">뿌리염색</option>
						<option value = "전체염색" data-price = "80000">전체염색</option>
						<option value = "탈색" data-price = "80000">탈색</option>
						<option value = "하이라이트" data-price = "100000">하이라이트</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<div align = "right">
						<input type = "button" value = "예약하기" onclick = "reserve(${order.userId });">
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>