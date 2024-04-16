<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.TaskBean, model.entity.CategoryBean,model.entity.UserBean
    ,model.entity.TaskCategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集画面</title>
</head>
<body>
	<% List<CategoryBean> categoryList = (List<CategoryBean>)session.getAttribute("TaskCategory");%>
	<% List<UserBean> userNameList = (List<UserBean>)session.getAttribute("PersoninCharge"); %>
	<%
	TaskCategoryBean taskList = (TaskCategoryBean)session.getAttribute("TaskDetail");
    %>
	<form action="TaskRegisterServlet" method="post">
	<h1>タスク編集画面</h1>
	<hr>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><input type = "text" name ="taskName" value ="<%=taskList.getTaskName() %>"></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><select name="categoryName">
				<option value ="<%=categoryList.get(0).getCategory_id()%>"><%=categoryList.get(0).getCategory_name()%></option>
				<%for (CategoryBean category : categoryList){ %>
						<%if(!category.getCategory_name().equals(categoryList.get(0).getCategory_name())) {%>
							<option value="<%=category.getCategory_id()%>"><%=category.getCategory_name()%></option>
						<%} %>
				<%} %>
			</select></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><input type="date" name="deadLine" value = "<%=taskList.getLimitDate() %>"></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><select name="userName">
				<option value ="<%=taskList.getUserId()%>"><%=taskList.getUserName() %></option>
				<%for (UserBean users : userNameList){ %>
						<%if(!users.getUser_name().equals(taskList.getUserName())) {%>
							<option value="<%=users.getUser_id()%>"><%=users.getUser_name()%></option>
						<%} %>
				<%} %>
			</select></td>
			
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><select name="categoryName">
					<option value="<%=taskList.getStatusCode()%>"><%=taskList.getStatusName()%></option>
					<%String[] type= {"未着手","着手","完了"};%>
					<%for (int i = 0; i< type.length; i++){ %>
						<%if(!type[i].equals(taskList.getStatusName())){%>
							<option value="<%=type[i]%>"><%=type[i]%></option>
						<%} %>
					<%} %>
				</select></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><input type="text" name="memo" maxlength= "100" value = "<%=taskList.getMemo() %>"></td>
		</tr>
	</table><br>
	<input type="submit" value="編集実行">
	</form>
		
		
		
</body>
</html>