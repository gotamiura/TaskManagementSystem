<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "model.entity.EnterCommentsBean, java.util.List, java.lang.Iterable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント入力画面</title>
</head>
<body>
<% List<EnterCommentsBean> comments = (List<EnterCommentsBean>)session.getAttribute("Comments");%> 
<table border="1">
		<%
		if (comments != null) {%>
			<tr>
			<th>タスク情報</th>
			<th>コメント情報</th>
			<th>コメント内容</th>
			<th>コメントひ</th>
		</tr>
		<%
			for (EnterCommentsBean viewComments : comments) {
		%>
		<tr>
			<td>
				<%= viewComments.getCommentId() %>	 
			</td>
			<td>
				<%=viewComments.getTaskName() %>	 
			</td>
			<td>
				<%=viewComments.getUserName() %>		
			</td>
			<td>
				<%=viewComments.getComment() %>				 
			</td>
		</tr>
		<%
		}
		} 
		%>

	</table>	
	
</body>
</html>