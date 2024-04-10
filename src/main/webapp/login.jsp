<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<form action="LoginServlet" method = "post">
	<h1>ログイン画面</h1>
	<hr><hr>
	<h3>ユーザIDとパスワードを入力してください。</h3>
	<table>
		<tr>
			<th>ユーザID</th>
			<td><input type= "text" name= "userName"></td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><input type= "password" name= "password"></td>
		</tr>		
	</table>
	<input type= "submit" name= "password">
	</form>
</body>
</html>