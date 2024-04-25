<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.entity.EnterCommentsBean, java.util.List, java.lang.Iterable,java.text.SimpleDateFormat, java.util.Date,java.sql.Timestamp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント入力画面</title>
</head>
<body>
	<%
	EnterCommentsBean newComments = (EnterCommentsBean) session.getAttribute("NewComments");
	%>
	<h1>コメント入力画面</h1>
	<form action="CommentsResultServlet" method="GET">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td>
					<%if (newComments.getTaskName() != null) {%>
						<%=newComments.getTaskName()%> 
					<%}%>
				</td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td>
					<%if (newComments.getUserName() != null) {%> 
						<%=newComments.getUserName()%> 
					<%}%>
				</td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><textarea name="comments" rows="4" cols="50"
						maxlength="100" required></textarea></td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="taskId" value="<%=newComments.getTaskId()%>"> 
		<input type="hidden" name="userId" value="<%=newComments.getUserId()%>"> 
		<input type="submit" value="コメントする">
	<br>

	<%
	List<EnterCommentsBean> pastComments = (List<EnterCommentsBean>) session.getAttribute("OldComments");
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (EnterCommentsBean viewComments : pastComments) {
		%>
		<tr>
			<td><%=viewComments.getTaskName()%></td>
			<td><%=viewComments.getUserName()%></td>
			<td><%=viewComments.getComment()%></td>
			<td>
				<%
				Timestamp timestamp = viewComments.getUpdateDatetime();
				Date date = new Date(timestamp.getTime());
				String formattedDate = dateFormat.format(date);
				out.print(formattedDate);
				%>
			</td>
			<td class="action-buttons">
				<form action="DeleteCommentServlet" method="POST">
					<input type="hidden" name="commentId"
						value="<%=viewComments.getCommentId()%>"> <input
						type="submit" value="削除">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%><br>
	</form>
	<form action="task-list.jsp" method="POST">
		<input type="submit" value="タスク一覧へ">
	</form>
</body>
</html>