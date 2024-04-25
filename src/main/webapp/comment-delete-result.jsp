<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EnterCommentsBean, java.util.List, java.lang.Iterable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント-削除結果画面</title>
</head>
<body>
	<h1>コメント-削除結果画面</h1>
	<hr>

	<%
	EnterCommentsBean confirmComments = (EnterCommentsBean) session.getAttribute("confirmComments");
	
	int processingNumber = (int) request.getAttribute("processingNumber");
	if (processingNumber > 0) {
	%>
	<h2>次のデータを削除しました。</h2>
	<%
	} else {
	%>
	<h2>次のデータを削除できませんでした。</h2>
	<%
	}
	%>
	<br>
	<form action="ViewCommentServlet" method="GET">
	<input type="hidden" name="taskId" value="<%=confirmComments.getTaskId()%>">
		<input type="submit" value="コメント入力画面">
	</form>

</body>
</html>