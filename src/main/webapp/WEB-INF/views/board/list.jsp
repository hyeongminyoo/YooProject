<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	
	<div class="container">
	<h3>QNA LIST</h3>
		<div class="row">
			<form action="./list">
				<div class="col-4">
					<label class="visually-hidden" for="kind">검색</label>
					<select name="kind" class="form-select">
						<option class="kinds" value="contents">내용</option>
						<option class="kinds" value="title">제목</option>
						<option class="kinds" value="writer">작성자</option>
					</select>
				</div>
				<div class="col-4">
					<label class="visually-hidden" for="search">검색어 입력</label>
					<div class="input-group">
						<input type="text" name="search" class="form-control">
					</div>
				</div>
				<div class="col-4">
					<button type="submit" class="btn btn-outline-danger">검색</button>
				</div>
				
			</form>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.num}</td>
						<td><a href="/qna/detail?num=${vo.num}" style="text-decoration: none;">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.regDate}</td>
						<td>${vo.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item ${pager.pre?'':'disabled'}">
					<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">《</a>
				</li>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item">
					<a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
				</li>	
			</c:forEach>
				<li>
					<a class="page-link ${pager.next?'':'disabled'}" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">》</a>
				</li>
			</ul>
		</nav>
		<a href="/qna/add" class="btn btn-primary">글쓰기</a>
	</div>
</body>
</html>