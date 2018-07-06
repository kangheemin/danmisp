<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<center>
		<form action="CarReserveResult" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">[옵션선택]</font></td>
				</tr>
				<tr>
					<!-- 아래는 주 이미지 첨부 구간 -->
					<td rowspan="5" width="40%" align="center"><img alt=""
							src="resources/img/${dto.mimg}" width="450"></td>
					<!-- 상품 정보 구간(사진의 우측부분 해당)  -->
					<td width="10%" align="center" bgcolor="lightgray">${dto.cname}</td>
				</tr>
				
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">판매가</td>
					<td width="10%" align="center" bgcolor="lightgray">${dto.cprice}</td>
				</tr>

				<tr>
					<td width="20%" align="center" bgcolor="lightgray">적립금</td>
					<td width="20%" align="center" bgcolor="lightgray">${dto.point} (1%적립)</td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">배송비</td>
					<td width="10%" align="center" bgcolor="lightgray">${dto.cbprice}</td>
				</tr>

				<tr>
					<td width="25%" align="center" colspan="2"><input
						type="hidden" name="qty" value="${qty}"> <input
						type="hidden" name="no" value="${dto.no}"> <input
						type="submit" value="차량예약하기"></td>
				</tr>

			</table>
		</form>
		<p>
			<font size="5" color="gray">차량정보보기</font>
		<p>
			${dto.info}
	</center>
</body>
</html>