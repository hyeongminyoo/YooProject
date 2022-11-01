<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script type="text/javascript" defer src="/js/util.js"></script>
<script type="text/javascript" defer src="/js/fileManager.js"></script>
</head>
<body>
	<div class="container">
		<h3>글쓰기</h3>
		<form:form action="add" method="post" modelAttribute="qnaVO" enctype="multipart/form-data" id="frm">
	
			<div class="mb-3">
				  <label for="writer" class="form-label">작성자</label>
				  <form:input path="writer" id="writer" cssClass="form-control"/>
				  <form:errors path="writer"></form:errors>
				  <div id="inputWriterResult"></div>
				</div>
				<div class="mb-3">
				  <label for="title" class="form-label">제목</label>
				  <form:input path="title" id="title" cssClass="form-control"/>
				  <form:errors path="title"></form:errors>
				  <div id="inputTitleResult"></div>
				</div>
				<div class="mb-3">
			  		<label for="contents" class="form-label">내용</label>
			  		<form:textarea path="contents" id="contents" cssClass="form-control"/>
			  		<form:errors path="contents"></form:errors>
			  		<div id="inputContentsResult"></div>
				</div>
				
				<div class="mb-3" id="files">
					
				</div>
				<div class="mb-3">
					<button type="button" id="fileAdd">FileAdd</button>
				</div>
				
				
				<!-- <div class="mb-3">
			  		<label for="file" class="form-label">File</label>
			  		<input type="file" name="files">
				</div>
				
				<div class="mb-3">
			  		<label for="file" class="form-label">File</label>
			  		<input type="file" name="files">
				</div> -->
				
				<button type="submit" class="btn btn-outline-danger" id="addButton">Write</button>
		</form:form>
	</div>
</body>

</html>