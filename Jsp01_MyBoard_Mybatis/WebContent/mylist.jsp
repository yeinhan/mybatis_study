<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.dao.MyBoardDao" %>
<%@ page import="com.dto.MyBoardDto" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MyBoardDao dao = new MyBoardDao();
		List<MyBoardDto> list = dao.selectall();
		
	%>
	

	<table border=1>
		<tr>
			<th>번호</th> 
			<th>이름</th> 
			<th>제목</th> 
			<th>내용</th> 
			<th>날짜</th>
			<th>수정</th>
			<th>삭제</th> 
		</tr>
		
		<%
			for(int i=0; i<list.size();i++){
		%>
		<tr>
			<td><%=list.get(i).getMyno() %></td>
			<td><%=list.get(i).getMyname() %></td>
			<td><%=list.get(i).getMytitle() %></td>
			<td><a href="selectone.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMycontent() %></a></td>
			<td><%=list.get(i).getMydate() %></td>
			<td><a href="myupdate.jsp?myno=<%=list.get(i).getMyno()%>">수정</a></td>
			<td><a href="mydelete.jsp?myno=<%=list.get(i).getMyno() %>">삭제</a></td>
		</tr>	
		<%
			}
		%>
		<tr>
			<td colspan="7" align="center"> <input type="button" onclick="location.href='myinsert.jsp'" value="항목추가">  </td>
		</tr>
		
		
	</table>






</body>
</html>