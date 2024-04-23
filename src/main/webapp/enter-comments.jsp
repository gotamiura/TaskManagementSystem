<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.EnterCommentsBean"%>
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

  <table border="1">
        <tr>
            <th>タスク名</th>
            <td>
				<%
				if (comments.getTaskName() != null) {
				%> <%=comments.getTaskName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>担当者情報</th>          
             <td>
				<%
				if (comments.getUserName() != null) {
				%> <%=comments.getUserName()%> 
				<%
 				}
				%>
			</td>
        </tr>

        <tr>
            <th>コメント</th>
             <td>
				<input type = "text" name ="comments">
			</td>
        </tr>
    </table>
    <br>
    <form action="CommentsResultServlet" method="POST">
        <input type="hidden" name="taskId"
            value="<%=comments.getTaskId()%>"> <input type="submit"
            value="コメントする">
    </form>
    <br>
    <form action="task-list.jsp" method="POST">
        <input type="submit" value="タスク一覧へ">
    </form>
</body>
</html>
