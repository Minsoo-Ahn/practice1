<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVO.title }&nbsp내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<th>${boardVO.title }</th>
		</tr>
		<tr>
			<th>내용</th>
			<th>${boardVO.content }</th>
		</tr>
		<tr>
			<th>작성자</th>
			<th>${boardVO.writer }</th>
		</tr>
		<tr>
			<th>작성일</th>
			<th>${boardVO.regDate }</th>
		</tr>
		<tr>
			<th>조회수</th>
			<th>${boardVO.cnt }</th>
		</tr>
	</table>
	<div>
		<a href="<c:url value="/board/edit/${boardVO.seq }"/>">수정</a>
		<a href="<c:url value="/board/delete/${boardVO.seq }"/>">삭제</a>
		<a href="<c:url value="/board/list"/>">목록</a>
	</div>
</body>
</html>