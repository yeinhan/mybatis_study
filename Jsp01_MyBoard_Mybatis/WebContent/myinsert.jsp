<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.dao.MyBoardDao" %>
<%@ page import="com.dto.MyBoardDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="myinsert_res.jsp" method="post">

	<table>
		<tr>
			<td colspan="2"> ** MyBoard 데이터 추가 ** </td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td> <input type="text" name="myname" value=""></td> 
		</tr>
		<tr>
			<th> 제목 </th>
			<td> <input type="text" name="mytitle" value=""></td>
		</tr>
		<tr>
			<th> 내용 </th>
			<td> <textarea rows="10" cols="30" name="mycontent"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="추가">
				<input type="reset" value="취소" onclick="location.href='mylist.jsp'">
			</td>
		</tr>
	</table>
</form>


</body>
</html>