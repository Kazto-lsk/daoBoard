<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="board" items="${list}">

${board.number},
<a href="read.do?number=${board.number}">${board.subject}</a>,
${board.writer},
${board.created}
<br>

</c:forEach>


<a href="insertform.do">추가</a>
<a href="latestdocument.do">최신글 보기</a>

</body>
</html>