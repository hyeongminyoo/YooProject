<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<script defer src="http://localhost:83/socket.io/socket.io.js"></script>
</head>
<body>
	<h3>HOME</h3>
	<a href="/qna/list">QNA 목록</a>
	
	<sec:authorize access="isAuthenticated()">
		<a href="/member/logout">로그아웃</a>
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="/member/login">로그인</a>
		<a href="/member/join">회원가입</a>
	</sec:authorize>
	
	<script type="text/javascript">
		$(document).ready(function(){
			let socket = io("http://localhost:83");
		})
	</script>
</body>
</html>