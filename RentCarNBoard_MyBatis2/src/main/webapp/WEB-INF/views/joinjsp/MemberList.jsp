<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입자명단</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String joinroot = (String) session.getAttribute("joinroot");

		int currentPage = (int) request.getAttribute("currentPage");
		int currentBlock = (int) request.getAttribute("currentBlock");
		// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);
	%>
	<center>
		<h1>${id}님모든회원의 등록 정보입니다.(${currentPage}/${pageCount})</h1>
		<table border="1" width="800">
			<tr height="50" align="center" bgcolor="#cccccc">
				<td width="100">아이디</td>
				<td width="150">이메일</td>
				<td width="200">전화</td>
				<td width="100">직업</td>
				<td width="250">취미</td>
			</tr>
			<c:forEach items="${list}" var="dto" varStatus="status">
				<tr height="50">
					<td width="100"><a
						href="MemberInfo?id=${dto.id}"> ${dto.id}</a></td>
					<td width="150">${dto.email}</td>
					<td width="200">${dto.tel}</td>
					<td width="100">${dto.job}</td>
					<td width="250">${dto.hobby}</td>
				</tr>
			</c:forEach>
		</table>
		아이디를 누르면 상세보기가 출력됩니다.(<a href="MemberJoin">회원가입</a>)
	</center>
	<p>${pagenation}</p>
	
</body>
</html>