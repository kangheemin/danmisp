
<%@page import="java.util.ArrayList"%>
<%@page import="com.jjh.spring.dto.JSPBoard"%>
<%@page import="com.jjh.spring.common.PageManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" />
<title>보드리스트</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String root = (String) session.getAttribute("root");
		
		int currentPage = (int)request.getAttribute("currentPage");
		int currentBlock = (int)request.getAttribute("currentBlock");
		// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);
	%>
	<center>

		<h2>전체글보기(${currentPage}/${pageCount})</h2>
		<table width="1000">
			<tr height="40" align="center" style="font-size: 80%;">
				<td colspan="2" align="left">
					<button onclick="location.href='BoardWriteForm'">글쓰기</button>
				</td>
			</tr>
			<tr height="2" bgcolor="lightgray">
				<td colspan="5"></td>
			</tr>
			<tr style="font-size: 120%;" align="center" bgcolor="lightgray">
				<td width="50"><strong>번호</strong></td>
				<td width="350"><strong>제목</strong></td>
				<td width="100"><strong>작성자</strong></td>
				<td width="150"><strong>날짜</strong></td>
				<td width="50"><strong>조회수</strong></td>
			</tr>
			<tr height="2" bgcolor="lightgray">
				<td colspan="5"></td>
			</tr>
			<c:forEach items="${list}" var="dto" varStatus="status">
				<tr>
				<c:set value="${(number - status.index) - ((currentPage - 1) * displayNum)}" var="no"/>
					<td align="center">${no} </td>
					<td><c:forEach begin="1" end="${dto.re_step-1}">[re]</c:forEach> 
						<a href="BoardInfo?num=${dto.num}&no=${no}">${dto.subject}</a></td>
					<td align="center" >${dto.writer}</td>
					<td align="center" >${dto.reg_date}</td>
					<td align="center">${dto.readcount}</td>
				</tr>
				
			</c:forEach>
			<tr height="2" bgcolor="lightgray">
				<td colspan="5"></td>
			</tr>
		</table>
		<p>${pagenation}</p>
	</center>

</body>
</html>