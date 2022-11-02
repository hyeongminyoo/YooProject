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
		<h5>Detail</h5>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>작성자</th><th>제목</th><th>작성일자</th><th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${vo.writer}</td>
						<td>${vo.title}</td>
						<td>${vo.regDate}</td>
						<td>${vo.hit}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="row">
			<textarea rows="" cols="" id="contents"></textarea>
		</div>
		<div class="container text-center">
			<div class="row row-cols-3"">
				<c:forEach items="${vo.qnaFileVOs}" var="file">
					<div class="col">
						<img src="/file/qna/${file.fileName}" style="height: 200px; width: 200px;"><br>
						<a href="/fileDown/qna?fileNum=${file.fileNum}">${file.oriName} 다운로드</a>
					</div>	
				</c:forEach>
			</div>		
		</div>
	</div>

<script type="text/javascript">
$('#contents').summernote({
	height : 400,
    lang : "ko-KR",
    minHeight : null,
    maxHeight : null
});

$('#contents').summernote('pasteHTML','${vo.contents}');

$('#contents').next().find(".note-editable").attr("contenteditable", false);

const toolbar = document.getElementsByClassName("note-toolbar");
toolbar[0].setAttribute("style","display : none;");
</script>
</body>
</html>