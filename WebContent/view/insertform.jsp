<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<H2>게시판글쓰기</H2> 
<form action="insert.do" method="post">
	작성자 : <input type=text name="writer"><br>
	제목 : <input type=text name="subject"><br>
	글내용:<textarea rows=10 cols=60 name="contents"></textarea><br>
	비밀번호 : <input type=password name="password"><br>
	<input type=submit value="글쓰기">
</form>

</body>
</html>