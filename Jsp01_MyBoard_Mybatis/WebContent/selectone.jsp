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


	<table border="1">
		<tr>
			<th> 이름 </th>
			<td> <%= dto.getMyname() %></td>			
		</tr>
		<tr>
			<th> 제목 </th>
			<td> <%= dto.getMytitle() %></td>
		</tr>
		<tr>
			<th> 내용 </th>
			<td> <textarea rows="10" cols="40" readonly="readonly"><%= dto.getMycontent() %></textarea> </td>
		</tr>
	</table>
	<span><button onclick="location.href='myupdate.jsp?myno=<%=dto.getMyno() %>'"> 수정 </button></span>&nbsp;&nbsp;
	<span><button onclick="location.href='mydelete.jsp?myno=<%=dto.getMyno() %>'"> 삭제 </button></span>&nbsp;&nbsp;
	<span><button onclick="location.href='mylist.jsp'"> 목록 </button></span>&nbsp;&nbsp;



</body>
</html>