<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<form action="TaskRegisterServlet" method="post">
		<h1>メニュー画面</h1>
		<hr>
		<%
		String userName = (String) session.getAttribute("UserName");
		%>
		<b>ようこそ！<%=userName%>さん
		</b><br> <br> <input type="submit" value="タスク登録"><br>
		<br>
	</form>
	<a href="TaskListServlet"><input type="submit" value="タスク一覧"></a>
	<br>
	<br>
	<a href="logout.jsp"> <input type="submit" value="ログアウト"></a>
</body>
</html>