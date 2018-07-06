<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<center>
	<!-- 옷 카테고리 메인화면 -->
		<!-- 데이타베이스에서 최신순 3대만 가져오기 -->

		<table width="1000">
			<tr>
				<td align="center" colspan="3"><font size="6" color="gray">최신등록차량</font>
				</td>
			</tr>
			<tr height="240">
				<c:forEach items="${list}" var="Clothes">
					<td width="333" align="center"><a
						href="ClothesOptionSelect?ccode=${clothes.ccode}"> <img alt=""
							src="resources/img/${clothes.mimg}" width="300" height="200">
					</a>
						<p>옷이름 : ${rentcar.cname}</td>
				</c:forEach>
			</tr>
		</table>
	</center>
</body>
</html>