<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String) session.getAttribute("id");
	if (id == null || id.equals("GUEST")) {
%>
<script>
	alert('로그인후 예약 가능합니다.');
	location.href = "Login";
</script>
<%
	}
	int res = (int)request.getAttribute("res");
	if (res == -1) {
%>
<script>
	alert("현재 이전 날짜는 예약일로 사용할 수 없습니다.");
	history.go(-1);
</script>
<%
	}
%>

</head>
<body>
	<center>
		<table width=70%>
			<tr bgcolor="lightgreen">
				<td colspan="3" align="center"><font size="5" color="gray">예약결과</font></td>
			</tr>
			<tr>
				<td rowspan="7"><img alt="" src="resources/img/${rentCar.img}" width="450" /></td>
				<td width="30%" align="center" bgcolor="lightgray">차종</td>
				<td width="40%">${rentCar.name}</td>
			</tr>
			<tr>
				<td width="30%" align="center" bgcolor="lightgray">대여일자</td>
				<td width="40%">${rbean.rday}부터</td>
			</tr>
			<tr>
				<td width="30%" align="center" bgcolor="lightgray">대여일수</td>
				<td width="40%">${rbean.dday}일</td>
			</tr>
			<tr>
				<td width="30%" align="center" bgcolor="lightgray">대여수량</td>
				<td width="40%">${rbean.qty}대</td>
			</tr>
			<tr>
				<td width="30%" align="center" bgcolor="lightgray">대여금액</td>
				<td width="40%">${rentalFee}원</td>
			</tr>
			<tr>
				<td width="30%" align="center" bgcolor="lightgray">옵션금액</td>
				<td width="40%">${optionFee}원</td>
			</tr>
			<tr>
				<td width="30%" align="center" bgcolor="lightgray">옵션내역</td>
				<td width="40%">${option}</td>
			</tr>
			<tr>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="center"><font size="4" color="gray">합계액:${optionFee + rentalFee}원
				</font></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="left"><font size="2" color="gray">${toString}</font></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="left"><font size="2" color="gray">${toString2}</font></td>
			</tr>
		</table>
	</center>
</html>