<%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<form action="CarOptionSelect" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">${dto.name}
							차량 선택</font></td>
				</tr>
				<tr>
					<td rowspan="6" width="50%" align="center"><img alt=""
							src="resources/img/${dto.img}" width="450"></td>
					<td width="10%" align="center" bgcolor="lightgray">차량이름</td>
					<td width="25%" align="center">${dto.name}</td>

				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">대여수량</td>
					<td width="25%" align="center"><select name="qty">
							<option value="1">1대</option>
							<option value="2">2대</option>
							<option value="3">3대</option>
							<option value="4">4대</option>
							<option value="5">5대</option>
					</select></td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">차량분류</td>
					<td width="25%" align="center">${section}</td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">대여가격</td>
					<td width="25%" align="center">${dto.price}</td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">제조회사</td>
					<td width="25%" align="center">${dto.company}</td>
				</tr>
				<tr>
					<td colspan="2" width="50%" align="center">
					<input type="hidden" name="no" value="${dto.no}">
					<input type="hidden" name="img" value="${dto.img}">
					<input type="submit" value="옵션선택후구매하기"></td>
				</tr>

			</table>
		</form>

		<p>
			<font size="5" color="gray">차량정보보기</font>
		<p>${dto.info}
	</center>
</body>

</html>