<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.BoardDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${board.number}<br>
${board.subject}<br>
<hr>
${board.contents}<br>
${board.created}
<hr>
<a href="delete.do?number=${board.number}">삭제</a>
<a href="updateform.do?number=${board.number}">편집</a>
</body>
</html>