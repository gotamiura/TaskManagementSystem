<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.EnterCommentsBean, java.util.List, java.lang.Iterable,java.text.SimpleDateFormat, java.util.Date,java.sql.Timestamp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク情報-削除確認画面</title>
</head>
<body>
    <%
    EnterCommentsBean confirmComments = (EnterCommentsBean) session.getAttribute("confirmComments");
    %>

    <h1>コメント-削除確認画面</h1>
    <hr>
    <h2>コメントを削除します。よろしいですか？</h2>
    <br>
    <table border="1">
    	<%
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		%>
        <tr>
            <th>対象のタスク情報</th>
            <td>
				<%
				if (confirmComments.getTaskName() != null) {
				%> <%=confirmComments.getTaskName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>コメント投稿者情報</th>     
             <td>
				<%
				if (confirmComments.getUserName() != null) {
				%> <%=confirmComments.getUserName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>コメント内容</th>
            <td>
				<%
				if (confirmComments.getComment() != null) {
				%> <%=confirmComments.getComment()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>コメント投稿者日時</th>          
             <td>
				<%
				if (confirmComments.getUpdateDatetime() != null) {
				%> <%
				Timestamp timestamp = confirmComments.getUpdateDatetime();
				Date date = new Date(timestamp.getTime());
				String formattedDate = dateFormat.format(date);
				out.print(formattedDate);
				%>
				<%
 				}
				%>
			</td>
        </tr>
    </table>
    <br>
    <form action="DeleteCommentResultServlet" method="POST">
        <input type="submit" value="削除する">
    </form>
    <br>
    <form action="task-list.jsp" method="POST">
        <input type="submit" value="タスク一覧へ">
    </form>
</body>
</html>
