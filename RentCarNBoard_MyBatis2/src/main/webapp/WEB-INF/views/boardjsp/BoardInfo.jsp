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
		String root = (String) session.getAttribute("root");
	%>
	<center>
		<h2>게시글보기</h2>
		<table width="600" border="1">
			<tr height="40">
				<td align="center" width="120" bgcolor="lightgray">글번호</td>
				<td align="center" width="180">${no}</td>
				<td align="center" width="120" bgcolor="lightgray">조회수</td>
				<td align="center" width="180">${contentView.readcount}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="lightgray">작성자</td>
				<td align="center" width="180">${contentView.writer}</td>
				<td align="center" width="120" bgcolor="lightgray">작성일</td>
				<td align="center" width="180">${contentView.reg_date}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="lightgray">제목</td>
				<td align="center" colspan="3">${contentView.subject}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="lightgray">글내용</td>
				<td align="center" colspan="3">${contentView.content}</td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4"><input type="button"
					value="답글쓰기"
					onclick="location.href='BoardReWriteForm?num=${contentView.num}'">
					<input type="button" value="수정하기"
					onclick="location.href='BoardUpdateForm?num=${contentView.num}'">
					<input type="button" value="삭제하기"
					onclick="location.href='BoardDeleteForm?num=${contentView.num}'">
					<input type="button" value="목록보기"
					onclick="location.href='BoardList?pageNum=${backPage}&pageBlock=${backBlock}'">
				</td>
			</tr>


		</table>
	</center>
</body>
</html>