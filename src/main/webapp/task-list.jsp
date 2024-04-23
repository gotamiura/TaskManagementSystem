<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, model.entity.TaskCategoryBean, java.time.format.DateTimeFormatter,java.sql.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧画面</title>
<style>
.action-buttons {
	display: inline-block;
	margin-right: 5px;
}
</style>
</head>
<body>
	<%
	List<TaskCategoryBean> taskList = (List<TaskCategoryBean>) session.getAttribute("taskList");
	%>
	<h1>タスク一覧画面</h1>
	<hr>

	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
		<%
		if (taskList != null) {
			for (TaskCategoryBean task : taskList) {
		%>
		<tr>
			<td>
				<%
				if (task.getTaskName() != null) {
				%> <%=task.getTaskName()%> 
				<%
 				}
				%>
			</td>
			
			<td>
				<%
				if (task.getCategoryName() != null) {
				%> <%=task.getCategoryName()%> 
				<%
 				}
				%>
			</td>

			<td>
				<%
				if (task.getLimitDate() != null) {
				%> <%=task.getLimitDate()%> 
				<%
 				}
				%>
			</td>
			
			<td>
				<%
				if (task.getUserName() != null) {
				%> <%=task.getUserName()%> 
				<%
 				}
				%>
			</td>

			<td>
				<%
				if (task.getStatusName() != null) {
				%> <%=task.getStatusName()%> 
				<%
 				}
				%>
			</td>
			
			<td>
				<%
				if (task.getMemo() != null) {
				%> <%=task.getMemo()%> 
				<%
 				}
				%>
			</td>
			
			<td class="action-buttons">
				<form action="TaskAlterServlet" method="GET">
					<input type="hidden" name="task_id" value="<%=task.getTaskId()%>">
					<input type="submit" value="変更">
				</form>
			</td>

			<td class="action-buttons">
				<form action="TaskDeleteServlet" method="POST">
					<input type="hidden" name="taskId" value="<%=task.getTaskId()%>">
					<input type="submit" value="削除">
				</form>
			</td>
			
			<td class="action-buttons">
				<form action="ViewCommentServlet" method="POST">
					<input type="hidden" name="taskId" value="<%=task.getTaskId()%>">
					<input type="hidden" name="userId" value="<%=task.getUserId()%>">
					<input type="submit" value="コメント">
				</form>
			</td>
		</tr>
		<%
		}
		}
		%>
	</table>

	<br>
	<div>
		<form action="menu.jsp" method="GET">
			<input type="submit" value="メニュー画面へ">
		</form>
	</div>

</body>
</html>
