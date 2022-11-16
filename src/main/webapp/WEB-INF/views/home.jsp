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
<script defer src="http://localhost:3000/socket.io/socket.io.js"></script>
<script defer src="/static/js/live.js"></script>
<style>
#chat_box {
    width: 800px;
    min-width: 800px;
    height: 500px;
    min-height: 500px;
    border: 1px solid black;
}
#msg {
    width: 700px;
}
#msg_process {
    width: 90px;
}
</style>
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
	
	<div>
		<video id="localVideo" autoplay width="480px"></video>
	</div>
	
	
	<div id="chat_box"></div>
	<input type="text" id="msg">
	<button id="msg_process">전송</button>
	
	
</body>
</html>