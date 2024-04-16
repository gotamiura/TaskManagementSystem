<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.TaskBean, model.entity.CategoryBean,model.entity.UserBean
    ,model.entity.TMSBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集画面</title>
</head>
<body>
	<% List<CategoryBean> category = (List<CategoryBean>)session.getAttribute("TaskCategory");%>
	<% List<UserBean> userName = (List<UserBean>)session.getAttribute("PersoninCharge"); %>
	<%
    List<TMSBean> taskList = (List<TMSBean>) session.getAttribute("TaskDetail");
    %>
	<form action="TaskRegisterServlet" method="post">
	<h1>タスク編集画面</h1>
	<hr>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><input type="text" name="taskName" maxlength= "50" value = "<%=taskList.get(0).getTask_name() %>"required></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><input type="text" name="categoryName" maxlength= "20" value = "<%=taskList.get(0).getCategory_name() %>"required></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><input type="date" name="deadLine" value = "<%=taskList.get(0).getLimit_date() %>"></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><select name= "personIncharge">
			<%for(UserBean personIncharge : userName){ %>
				<option value = <%=personIncharge.getUser_id()%>><%=personIncharge.getUser_name()%></option>
			<%} %>	
			</select></td>
			<% %>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><select name= "statusCode">
				<option value=00>未着手</option>
				<option value=50>着手</option>
				<option value=99>完了</option>
			</select>
		</tr>
		<tr>
			<th>メモ</th>
			<td><input type="text" name="memo" maxlength= "100" value = "<%=taskList.get(0).getMemo() %>"></td>
		</tr>
	</table><br>
	<input type="submit" value="編集実行">
	</form>
		
		
		
</body>
</html>