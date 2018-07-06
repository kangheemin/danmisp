<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>저장하기</title>
</head>
<body>
	<%
		int res = (int) request.getAttribute("res");

		if (res == 1) {
	%>
	<script>
		alert('패스워드가 틀렸습니다. 다시입력하세요.');
		history.go(-1);
	</script>
	<%
		} else if (res == 2) {
	%>
	<script>
		alert('회원정보수정이 완료되었습니다.');
		location.href = 'MemberList';
	</script>
	<%
		} else {
	%>
	<script>
		alert('빈 공란을 놓을 수 없습니다.');
		history.go(-1);
	</script>
	<%
		}
	%>

</body>
</html>