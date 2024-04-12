<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, model.entity.TaskCategoryBean, java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧画面</title>
</head>
<body>
    <%
        List<TaskCategoryBean> taskList = (List<TaskCategoryBean>) request.getAttribute("taskList");
		// 日付フォーマットの設定
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd"); 
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
            <td><a
                href="task-alter-form.jsp?task_name=<%=task.getTaskName()%>"><%=task.getTaskName()%></a>
            </td>
            <td><%=task.getCategoryName()%></td>
            <td><%=task.getLimitDate()%></td> 
            <td><%=task.getUserName()%></td>
            <td><%=task.getStatusName()%></td>
            <td><%=task.getMemo()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <br>
    <div>
        <form action="menu.jsp" method="POST">
            <input type="submit" value="メニュー画面へ">
        </form>
    </div>
</body>
</html>
