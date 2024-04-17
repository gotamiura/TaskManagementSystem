<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更結果画面</title>
<style >
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<h1>タスク情報-変更結果画面</h1>
	<hr>
	<h2><%= session.getAttribute("message") %></h2>
	<table>
		<tr>
			<th>タスク名</th>
			<td width = "650"><%= session.getAttribute("TaskName") %></td>
		</tr>
		<tr>
			<th>カテゴリ名</th>
			<td><%= session.getAttribute("CategoryName") %></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%= session.getAttribute("LimitDate")%></td>
		</tr>
		<tr>
			<th>ユーザ名</th>
			<td><%= session.getAttribute("UserName")%></td>
		</tr>
		<tr>
			<th>ステータス名</th>
			<td><%= session.getAttribute("StatusCode")%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%= session.getAttribute("memo")%></td>
		</tr>
	</table>
	<br><a href = "menu.jsp"><input type = "submit" value ="メニュー画面へ"></a>
</body>
</html>