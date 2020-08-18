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
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = new MyBoardDto(myname,mytitle,mycontent);
	int res = dao.insert(dto);
	
	if(res>0){
%>
	<script type="text/javascript">
		alert("데이터 추가 성공");
		location.href="mylist.jsp";
	</script>
<%
	}else{
%>
	<script type="text/javascript">
		alert("데이터 추가 실패");
		location.href="mylist.jsp";
	</script>
<%
	}
%>
</body>
</html>