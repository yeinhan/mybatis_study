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
<%
	int myno = Integer.parseInt(request.getParameter("myno"));

	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectone(myno);
%>

	<form action="myupdate_res.jsp" method="post">
		<table border="1">
			<tr>
				<th> 이름 </th>
				<td> <%= dto.getMyname() %></td>			
			</tr>
			<tr>
				<th> 제목 </th>
				<td> <input type="text" name="mytitle" value="<%= dto.getMytitle() %>"></td>
			</tr>
			<tr>
				<th> 내용 </th>
				<td> <textarea rows="10" cols="40" name="mycontent"><%=dto.getMycontent()%></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정"></td>
				<input type="hidden" name="myno" value="<%=dto.getMyno()%>">
			</tr>
		</table>
		
	</form>
</body>
</html>