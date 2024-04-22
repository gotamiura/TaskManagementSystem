<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.TaskBean, model.entity.CategoryBean,model.entity.UserBean
    ,model.entity.TaskCategoryBean, model.entity.TMSBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集画面</title>
<script>
	function setMinDate() {
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2); // 月を2桁にする
		var day = ('0' + today.getDate()).slice(-2); // 日を2桁にする
		var minDate = year + '-' + month + '-' + day;

		document.getElementById('deadLine').setAttribute('min', minDate);
	}
	// ページ読み込み時に実行
	window.onload = function() {
		setMinDate();
	};
</script>
</head>
<body>
	<% List<CategoryBean> categorysList = (List<CategoryBean>)session.getAttribute("AlterTaskCategory");%>
	<% List<UserBean> userNameList = (List<UserBean>)session.getAttribute("AlterPersoninCharge"); %>
	<% List<TMSBean> statusList = (List<TMSBean>)session.getAttribute("AlterStatus"); %>
	<%
	TaskCategoryBean taskList = (TaskCategoryBean)session.getAttribute("TaskDetail");
    %>
	<form action="TaskAlterServlet" method="post">
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
				<option value ="<%=taskList.getCategoryId()%>"><%=taskList.getCategoryName()%></option>
				<%for (CategoryBean category : categorysList){ %>
						<%if(!category.getCategoryName().equals(taskList.getCategoryName())) {%>
							<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
						<%} %>
				<%} %>
			</select></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><input type="date" name="deadLine" value = "<%=taskList.getLimitDate() %>" id = "deadLine"></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><select name="userName">
				<option value ="<%=taskList.getUserId() %>"><%=taskList.getUserName() %></option>
				<%for (UserBean users : userNameList){ %>
						<%if(!users.getUserName().equals(taskList.getUserName())) {%>
							<option value="<%=users.getUserId()%>"><%=users.getUserName()%></option>
						<%} %>
				<%} %>
			</select></td>
			
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><select name="statusName">
					<option value="<%=taskList.getStatusCode()%>"><%=taskList.getStatusName()%></option>
				
					<%for (TMSBean status : statusList){ %>
						<%if(!status.getStatusName().equals(taskList.getStatusName())){%>
							<option value="<%=status.getStatusCode() %>"><%=status.getStatusName()%></option>
						<%} %>
					<%} %>
				</select></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><input type="text" name="memo" maxlength= "100" value = "<%=taskList.getMemo() %>"></td>
		</tr>
	</table><br>
	<input type="submit" value="編集実行"><br><br>
	<a href="menu.jsp"> <input type="submit" value="メニュー画面へ"></a>
	</form>	
</body>
</html>