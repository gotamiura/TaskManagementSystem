<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskCategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク情報-削除確認画面</title>
</head>
<body>
    <%
    TaskCategoryBean taskDetail = (TaskCategoryBean) session.getAttribute("taskDetail");
    %>

    <h1>タスク情報-削除確認画面</h1>
    <hr>
    <h2>タスク情報を削除します。よろしいですか？</h2>
    <br>
    <table border="1">
        <tr>
            <th>タスク名</th>
            <td>
				<%
				if (taskDetail.getTaskName() != null) {
				%> <%=taskDetail.getTaskName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>カテゴリ情報</th>     
             <td>
				<%
				if (taskDetail.getCategoryName() != null) {
				%> <%=taskDetail.getCategoryName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>期限</th>
            <td>
				<%
				if (taskDetail.getLimitDate() != null) {
				%> <%=taskDetail.getLimitDate()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>担当者情報</th>          
             <td>
				<%
				if (taskDetail.getUserName() != null) {
				%> <%=taskDetail.getUserName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>ステータス情報</th>
            <td>
				<%
				if (taskDetail.getStatusName() != null) {
				%> <%=taskDetail.getStatusName()%> 
				<%
 				}
				%>
			</td>
        </tr>
        <tr>
            <th>メモ</th>
             <td>
				<%
				if (taskDetail.getMemo() != null) {
				%> <%=taskDetail.getMemo()%> 
				<%
 				}
				%>
			</td>
        </tr>
    </table>
    <br>
    <form action="TaskDeleteResultServlet" method="POST">
        <input type="hidden" name="taskId"
            value="<%=taskDetail.getTaskId()%>"> <input type="submit"
            value="削除する">
    </form>
    <br>
    <form action="task-list.jsp" method="POST">
        <input type="submit" value="タスク一覧へ">
    </form>
</body>
</html>
