<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskCategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-削除結果画面</title>
</head>
<body>
	<h1>商品情報-削除結果画面</h1>
	<hr>

	<%
	TaskCategoryBean taskDetail = (TaskCategoryBean) session.getAttribute("taskDetail");
			int processingNumber = (Integer) request.getAttribute("processingNumber");
			if (processingNumber > 0) {
	%>
	<h2>次のデータを削除しました。</h2>
	<br>
	<br>
    <table border="1">
        <tr>
            <th>タスク名</th>
            <td><%=taskDetail.getTaskName()%></td>
        </tr>
        <tr>
            <th>カテゴリ情報</th>
            <td><%=taskDetail.getCategoryName()%></td>
        </tr>
        <tr>
            <th>期限</th>
            <td><%=taskDetail.getLimitDate()%></td>
        </tr>
        <tr>
            <th>担当者情報</th>
            <td><%=taskDetail.getUserName()%></td>
        </tr>
        <tr>
            <th>ステータス情報</th>
            <td><%=taskDetail.getStatusName()%></td>
        </tr>
        <tr>
            <th>メモ</th>
            <td><%=taskDetail.getMemo()%></td>
        </tr>
    </table>

	<%
		} else {
	%>
	<h2>次のデータを削除できませんでした。</h2>
	<br>
	<br>
    <table border="1">
        <tr>
            <th>タスク名</th>
            <td><%=taskDetail.getTaskName()%></td>
        </tr>
        <tr>
            <th>カテゴリ情報</th>
            <td><%=taskDetail.getCategoryName()%></td>
        </tr>
        <tr>
            <th>期限</th>
            <td><%=taskDetail.getLimitDate()%></td>
        </tr>
        <tr>
            <th>担当者情報</th>
            <td><%=taskDetail.getUserName()%></td>
        </tr>
        <tr>
            <th>ステータス情報</th>
            <td><%=taskDetail.getStatusName()%></td>
        </tr>
        <tr>
            <th>メモ</th>
            <td><%=taskDetail.getMemo()%></td>
        </tr>
    </table>
	<%
		}
	%>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>

</body>
</html>