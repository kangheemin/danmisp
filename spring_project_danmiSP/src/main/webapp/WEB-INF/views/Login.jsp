<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
	String joinroot = (String)session.getAttribute("joinroot");
%>
	<center>
		<form action="LoginProc" method="post">
			<table width="300">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray"><strong>로그인</strong></font></td>
				</tr>

				<tr height="40">
					<td width="120" align="center">아이디</td>
					<td width="180"><input type="text" name="id">
				</tr>
				<tr height="40">
					<td width="120" align="center">패스워드</td>
					<td width="180"><input type="password" name="pass">
				</tr>
				<tr height="40" align="center">
					<td colspan="2"><input type="submit" value="로그인">&nbsp;&nbsp;
						<button type="button" onclick="location.href='MemberJoin'">회원가입</button></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>