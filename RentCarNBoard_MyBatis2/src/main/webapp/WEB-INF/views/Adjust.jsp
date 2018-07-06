<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<center>
		<form action="AdjustProc" method="post">
			<table width="500">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">[${dto.memid}님${dto.regno}번
							예약수정]</font></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><img src="resources/img/${img}"
						width="300" height="150" /></td>
				</tr>
				<tr bgcolor="lightgray">
					<td width="133" align="center">항목</td>
					<td width="133" align="center">당초</td>
					<td width="134" align="center">수정</td>
				</tr>
				<tr>
					<td align="center">예약일</td>
					<td>${dto.rday}</td>
					<td align="left"><input type="date" name="rday"></td>
				</tr>

				<tr>
					<td align="center">대여기간</td>
					<td>${dto.dday}</td>
					<td align="left" width="40"><select name="dday">
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
					<td align="center">대여수량</td>
					<td>${dto.qty}</td>
					<td align="left" width="40"><select name="qty">
							<option value="1">1대</option>
							<option value="2">2대</option>
							<option value="3">3대</option>
					</select></td>
				</tr>

				<tr>
					<td align="center">보험적용</td>
					<td>${dto.insurance}</td>
					<td align="left"><select name="insurance" width="40">
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					<td align="center">WiFi적용</td>
					<td>${dto.wifi}</td>
					<td align="left"><select name="wifi" width="40">
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>

				<tr>
					<td align="center">Navigation적용</td>
					<td>${dto.navigation}</td>
					<td align="left"><select name="navigation" width="40">
							<option value="1">적용(무료)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>

				<tr>
					<td align="center">Baby seat적용</td>
					<td>${dto.babyseat}</td>
					<td align="left"><select name="babyseat" width="40">
							<option value="1">적용(5000원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					<td align="center" colspan="3"><input type="submit"
						value="수정하기"> <input type="hidden" name="memid"
						value="${dto.memid}" /> <input type="hidden" name="regno"
						value="${dto.regno}" /> <input type="hidden" name="no"
						value="${dto.no}" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>