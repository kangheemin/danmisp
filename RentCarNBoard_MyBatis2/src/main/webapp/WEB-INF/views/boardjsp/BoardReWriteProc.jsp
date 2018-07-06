<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//답변글 처리 루틴입니다.
		request.setCharacterEncoding("utf-8");
		String root = (String)session.getAttribute("root");
		int backPage =Integer.parseInt(session.getAttribute("currentPage")+"");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock")+"");
		//response.sendRedirect(root+"BoardList.jsp?pageNum="+backPage+"&pageBlock="+backBlock+"");
		%>
		<script>
			alert('댓글 작성이 완료되었습니다.');
			location.href='BoardList?pageNum=<%=backPage%>&pageBlock=<%=backBlock%>';
		</script>
</body>
</html>