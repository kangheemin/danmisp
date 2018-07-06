<%@page import="com.jjh.spring.dto.ReserveView"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>예약확인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String memid = (String) request.getAttribute("memid");
		String img = null;
		if (memid == null || memid.equals("GUEST")) {
	%>
	<script>
		alert("로그인 후 사용하세요");
		history.go(-1);
	</script>
	<%
		}
	%>
	<center>
		<font size="6" color="gray">${memid}님 예약리스트(${list.size()}건)
		</font>
		<table border="1">
			<tr align="center" bgcolor="lightgray">
				<td>예약번호</td>
				<td>차량이미지</td>
				<td>차종</td>
				<td>예약일</td>
				<td>대여일수</td>
				<td>대여수량</td>
				<td>보험</td>
				<td>WIFI</td>
				<td>NAVI</td>
				<td>BBST</td>
				<td>대여금액내역</td>
				<td>수정</td>
				<td>예약취소</td>
			</tr>
			<c:forEach items="${list}" var="dto">
				<jsp:useBean id="reserveView" class="com.jjh.spring.dto.ReserveView" />
				<c:choose>
					<c:when test="${dto.res eq -1}">
						<c:set var="color" value="#F2F2F2" />
					</c:when>
					<c:otherwise>
						<c:set var="color" value="white" />
					</c:otherwise>
				</c:choose>
				<tr align='center' bgcolor='${color}'>
					<td height='50' width='5%'>${dto.regno}</td>
					<td height='50' width='10%'><img width='150' height='70'
						alt='' src='resources/img/${dto.img}'></td>
					<td height='50' width='4%'>${dto.name}</td>
					<td height='50' width='10%'>${dto.rday}</td>
					<td height='50' width='4%'>${dto.dday}</td>
					<td height='50' width='4%'>${dto.qty}</td>
					<td height='50' width='4%'>${dto.insurance}</td>
					<td height='50' width='4%'>${dto.wifi}</td>
					<td height='50' width='4%'>${dto.navigation}</td>
					<td height='50' width='4%'>${dto.babyseat}</td>
					<td height='50'>${dto.fee}</td>
					<td><button
							onclick="location.href='Adjust?regno=${dto.regno}&img=${dto.img}'">수정</button>
					</td>
					<td><button
							onclick="location.href='Delete?regno=${dto.regno}'">예취</button></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>