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
		request.setCharacterEncoding("utf-8");

		String root = (String) session.getAttribute("root");

		int res = (int) request.getAttribute("res");
		if (res == 1) {

			int backPage = Integer.parseInt(session.getAttribute("currentPage") + "");
			int backBlock = Integer.parseInt(session.getAttribute("currentBlock") + "");
	%>
	<script>
		alert('게시글 수정이 완료되었습니다.');
		location.href='BoardList?pageNum=<%=backPage%>&pageBlock=<%=backBlock%>';
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("패스워드가 일치하지 않습니다. 패스워드를 확인해주세요.");
		history.go(-1);
	</script>
	<%
		}
	%>

</body>
</html>