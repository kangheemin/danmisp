<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<table>
			<tr>
				<td align="center" colspan="3"><font size="6" color="gray">전체렌트카보기(${currentPage}/${pageCount})</font>
				</td>
			</tr>
			<c:forEach items="${list}" var="dto" varStatus="status">
				<c:if test="${status.index % 3 == 0}">
					<tr height="220">
				</c:if>
				<td width="33%" align="center"><a
					href="CarReserveInfo?no=${dto.no}&fromPage=CarAllList"> <img
						alt="" src="resources/img/${dto.img}" width="300" height="200">
				</a>
					<p>
						<font size="3" color="gray"><b>차량명 : ${dto.name}</b></font></td>
				<c:if
					test="${status.index % 3 == 2 || status.index == (rowCount -1)}">
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<p>${pagenation}
	</center>


</body>
</html>