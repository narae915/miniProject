<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>예약</title>
	<script type = "text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		function reserve(/* userId */) 
		{
			
			if(confirm("예약을 확정하시겠습니까?") == true)
			{
				location.href = "/resList";
				// location.href = "resList?userId=${user.userId }";
			}
			else
			{
				return;
			}
		}
	</script>
=======
<title>Reservation</title>
>>>>>>> main
</head>
<body>
	<h1>[ 예약 ]</h1>

	<form>
		<table>
			<tr>
				<td>
					<label>
						<input type = "radio" name = "photo"  value = "1" checked = "checked">
						<img src = "/resources/image/image1.jpg" alt = "디자이너1" height = "490" width = "490">
					</label>
				</td>
				<td>
					<label>
						<input type = "radio" name = "photo"  value = "2">
						<img src = "/resources/image/image2.jpg" alt = "디자이너2" height = "490" width = "490">
					</label>
				</td>
			</tr>
			<tr>
				<td>카나다 원장</td>
				<td>오키나와</td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "date" max = "2022-12-30" min = "2022-01-10" name = "resDate">
					<select id = "resTime" name = "resTime">
						<option selected>예약 시간</option>
						<option value = "1000">10:00</option>
						<option value = "1030">10:30</option>
						<option value = "1100">11:00</option>
						<option value = "1130">11:30</option>
						<option value = "1200">12:00</option>
						<option value = "1230">12:30</option>
						<option value = "1300">13:00</option>
						<option value = "1330">13:30</option>
						<option value = "1430">14:30</option>
						<option value = "1500">15:00</option>
						<option value = "1530">15:30</option>
						<option value = "1600">16:00</option>
						<option value = "1630">16:30</option>
						<option value = "1700">17:00</option>
						<option value = "1730">17:30</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>시술메뉴선택
					<select id = "hairType1" name = "hairType1">
						<option selected>컷</option>
						<option value = "남성컷">남성컷</option>
						<option value = "레이어드">레이어드</option>
						<option value = "허쉬컷">허쉬컷</option>
						<option value = "페이스라인컷">페이스라인컷</option>
						<option value = "태슬컷">태슬컷</option>
					</select>
					<select id = "hairType2" name = "hairType2">
						<option selected>펌</option>
						<option value = "매직">매직</option>
						<option value = "볼륨매직">볼륨매직</option>
						<option value = "허쉬펌">허쉬펌</option>
						<option value = "웨이브펌">웨이브펌</option>
						<option value = "빌드펌">빌드펌</option>
						<option value = "그레이스펌">그레이스펌</option>
						<option value = "히피펌">히피펌</option>
					</select>
					<select id = "hairType3" name = "hairType3">
						<option selected>컬러</option>
						<option value = "뿌리염색">뿌리염색</option>
						<option value = "전체염색">전체염색</option>
						<option value = "탈색">탈색</option>
						<option value = "하이라이트">하이라이트</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<div align = "right">
						<input type = "button" value = "예약하기" onclick = "reserve(<%-- ${user.userId } --%>);">
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>