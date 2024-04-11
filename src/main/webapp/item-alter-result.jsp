<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskCategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更登録結果画面</title>
</head>
<body>
	<h1>商品情報-変更登録結果画面</h1>
	<hr>
	<%
	TaskCategoryBean alterItem = (TaskCategoryBean) request.getAttribute("alterItem");
			int processingNumber = (Integer) request.getAttribute("processingNumber");
	%>
	<%	if (processingNumber > 0) { %>
	<h2>次のデータを変更登録しました。</h2>
	<%  } else {%>
	<h2>次のデータを変更登録できませんでした。</h2>
	<%  }%>
	<br>
	<br>
	<table border="1">
		<tr>
			<th align="left">商品コード</th>
			<td width="600"><%=alterItem.getItemCode()%></td>
		</tr>
		<tr>
			<th align="left">商品分類</th>
			<td><%=alterItem.getCategoryName()%></td>
		</tr>
		<tr>
			<th align="left">商品名</th>
			<td><%=alterItem.getItemName()%></td>
		</tr>
		<tr>
			<th align="left">価格</th>
			<td><%=alterItem.getPrice()%>円</td>
		</tr>
	</table>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>

</body>
</html>