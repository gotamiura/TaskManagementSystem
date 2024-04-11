<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.TaskBean, model.entity.CategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>
	<% List<CategoryBean> category = (List<CategoryBean>)session.getAttribute("TaskCategory");%>
	<form action="TaskRegisterServlet" method="post">
	<h1>タスク登録画面</h1>
	<hr>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><input type="text" name="taskName" maxlength= "50" required></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><select name= "categoryName">
			<%for(CategoryBean categoryName : category){ %>
				<option value = <%=categoryName.getCategory_id()%>><%=categoryName.getCategory_name()%></option>
			<%} %>	
			</select></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><input type="date" name="deadline"></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><input type="text" name="userName" maxlength= "24" required></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><select name= "StatusCode">
				<option value=00>未着手</option>
				<option value=50>着手</option>
				<option value=99>完了</option>
			</select>
		</tr>
		<tr>
			<th>メモ</th>
			<td><input type="text" name="memo" maxlength= "100"></td>
		</tr>
	</table><br>
	<input type="submit" value="登録実行">
	</form>
	<br><a href="menu.jsp"><input type="submit" value="メニュー画面へ"></a>
</body>
</html>