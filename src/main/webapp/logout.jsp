<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<form action="login.jsp" method="post">
		<h1>ログアウト画面</h1>
		<hr>
		<%
		String userName = (String) session.getAttribute("UserName");
		%>
		<b>お疲れ様でした！<%=userName%>さん
		</b>
		<h1>ログアウトしました。</h1>
		<%
		session.invalidate();
		%>
		<input type="submit" value="ログイン画面へ">
	</form>
</body>
</html>