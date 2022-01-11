<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
				function logincheck() {
					var checkId = document.getElementById("checkId").value;
					var checkPw = document.getElementById("checkPw").value;
					
					if(checkId == "" || checkId.length == 0){
						alert("ID를 입력해주세요");
						return false;
					}else if(checkId.length < 3 || checkId.length > 10){
						alert("ID는 3~10글자 사이로 입력해주세요");
						return false;
					}
					
					if(checkPw == "" || checkPw.length == 0){
						alert("비밀번호를 입력해주세요");
						return false;
					}else if(checkPw.length < 4 || checkPw.length > 12){
						alert("비밀번호는 4~12글자 사이로 입력해주세요");
						return false;
					}
			
					return true;
				}
		</script>
</head>
<body>
 <h1> [로그인]</h1>
<form action="/user/login" method="post" onsubmit="logincheck();">
	<table>
		<tr>
			<td class="bold">ID</td>
			<td><input type="text" name="userId" id="checkId"/></td>
		</tr>
		<tr>
			<td class="bold">비밀번호</td>
			<td><input type="password" name="userPw" id="checkPw"/></td>
		</tr>
		<tr>
			<td colspan="2" class="center white">
				<input type="submit" value="로그인" />
			</td>
		</tr>
	</table>
	
	<p>회원이 아니신가요?</p>
	<input type="button" value="회원가입 후 로그인 " onclick="location.href='/user/join';">
</form>
</body>
</html>