<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, model.entity.TaskBean, model.entity.CategoryBean,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
<script>
	function setMinDate() {
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2); // 月を2桁にする
		var day = ('0' + today.getDate()).slice(-2); // 日を2桁にする
		var minDate = year + '-' + month + '-' + day;

		document.getElementById('deadLine').setAttribute('min', minDate);
	}
	// ページ読み込み時に実行
	window.onload = function() {
		setMinDate();
	};
</script>
</head>
<body>
	<%
	List<CategoryBean> category = (List<CategoryBean>) session.getAttribute("TaskCategory");
	%>
	<%
	List<UserBean> userName = (List<UserBean>) session.getAttribute("PersoninCharge");
	%>
	<form action="TaskRegisterServlet" method="post">
		<h1>タスク登録画面</h1>
		<hr>
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="taskName" required></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><select name="categoryCode">
						<%
						for (CategoryBean categoryName : category) {
						%>
						<option value=<%=categoryName.getCategoryId()%>><%=categoryName.getCategoryName()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="date" name="deadLine" id="deadLine"></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><select name="personIncharge">
						<%
						for (UserBean personIncharge : userName) {
						%>
						<option value=<%=personIncharge.getUserId()%>><%=personIncharge.getUserName()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td><select name="statusCode">
						<option value=00>未着手</option>
						<option value=50>着手</option>
						<option value=99>完了</option>
				</select></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><input type="text" name="memo"></td>
			</tr>
		</table>
		<br> <input type="submit" value="登録実行">
	</form>
	<br>
	<a href="menu.jsp"><input type="submit" value="メニュー画面へ"></a>
</body>
</html>
