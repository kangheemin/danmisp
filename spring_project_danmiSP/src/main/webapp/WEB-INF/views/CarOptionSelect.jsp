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
					<td align="center" colspan="3"><font size="6" color="gray">[${dto.name}
							옵션선택]</font></td>
				</tr>
				<tr>
					<td rowspan="7" width="40%" align="center"><img alt=""
							src="resources/img/${dto.img}" width="450"></td>

					<td width="10%" align="center" bgcolor="lightgray">대여기간</td>
					<td width="25%" align="left" width="40">&emsp;<select name="dday">
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
							<option value="6">6일</option>
							<option value="7">7일</option>
					</select></td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">대여일자</td>
					<td align="left">&emsp;<input type="date" name="rday"></td>
				</tr>

				<tr>
					<td width="20%" align="center" bgcolor="lightgray">보험적용</td>
					<td align="left">&emsp;<select name="insurance" width="40">
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">WiFi적용</td>
					<td align="left">&emsp;<select name="wifi" width="40">
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>

				<tr>
					<td width="10%" align="center" bgcolor="lightgray">Navigation적용</td>
					<td align="left">&emsp;<select name="navigation" width="40">
							<option value="1">적용(무료)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					<td width="10%" align="center" bgcolor="lightgray">Baby seat적용</td>
					<td align="left">&emsp;<select name="babyseat" width="40">
							<option value="1">적용(5000원)</option>
							<option value="0">비적용</option>
					</select></td>
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