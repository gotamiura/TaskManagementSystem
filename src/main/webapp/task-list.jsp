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
			<td><%=task.getTaskName()%></td>
			<td><%=task.getCategoryName()%></td>

			<td>
				<%
				if (task.getLimitDate() != null) {
				%> <%=task.getLimitDate()%> 
				<%
 				}
				%>
			</td>


			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>

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
