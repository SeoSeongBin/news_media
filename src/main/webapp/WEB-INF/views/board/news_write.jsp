<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/board.css">
    <script type="text/javascript" src="/assets/plugin/ckeditor/ckeditor.js"></script>
    <script src="/assets/js/board/news_write.js"></script>
</head>
<body>
    <section>
        <div class="section_wrap">
            <div class="title_area">
                <h2>제목</h2>
                <input type="text">
            </div>
            <textarea class="form-control" id="ckedit"></textarea>
            <button class="add">등록</button>
        </div>
    </section>
</body>
</html>