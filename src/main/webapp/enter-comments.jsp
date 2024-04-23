<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.entity.EnterCommentsBean, java.util.List, java.lang.Iterable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント入力画面</title>
</head>
<body>
	<%
	EnterCommentsBean comments = (EnterCommentsBean) session.getAttribute("comments");
	%>
	<h1>コメント入力画面</h1>
	<form action="CommentsResultServlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td>
					<%
					if (comments.getTaskName() != null) {
					%> <%=comments.getTaskName()%> <%
 }
 %>
				</td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td>
					<%
					if (comments.getUserName() != null) {
					%> <%=comments.getUserName()%> <%
 }
 %>
				</td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><input type="text" name="comments"></td>
			</tr>
		</table>
		<br> <input type="hidden" name="taskId"
			value="<%=comments.getTaskId()%>"> <input type="hidden"
			name="userId" value="<%=comments.getUserId()%>"> <input
			type="submit" value="コメントする">
	</form>
	<br>

	<%
	List<EnterCommentsBean> pastComments = (List<EnterCommentsBean>) session.getAttribute("Comments");
	%>

	<%
	if (pastComments != null && !pastComments.isEmpty()) {
	%>
	<table border="1">
		<tr>
			<th>対象のタスク情報</th>
			<th>コメント投稿者情報</th>
			<th>コメント内容</th>
			<th>コメント投稿者日時</th>
		</tr>
		<%
		for (EnterCommentsBean viewComments : pastComments) {
		%>
		<tr>
			<td><%=viewComments.getCommentId()%></td>
			<td><%=viewComments.getTaskName()%></td>
			<td><%=viewComments.getUserName()%></td>
			<td><%=viewComments.getComment()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%><br>
	<form action="task-list.jsp" method="POST">
		<input type="submit" value="タスク一覧へ">
	</form>
</body>
</html>