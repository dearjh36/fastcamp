<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Yoil</title>
</head>
<body>
<h1>
	year=<%=request.getParameter("year")%><br>
	<!--  ${year}년 ${month}월 ${day}일은 ${yoil}입니다-->
	${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}입니다
</h1>
</body>
</html>
