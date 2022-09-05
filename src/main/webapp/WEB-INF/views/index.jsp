<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/index.js"></script>
    <script src="/assets/js/util.js"></script>
</head>
<body>
    <section>
        <div class="login_box">
            <div class="input_box">
                <input type="text" placeholder="아이디">
                <input type="password" placeholder="비밀번호">
            </div>
            <div class="btn_area">
                <button id="login">로그인</button>
                <button id="join">회원가입</button>
            </div>
            <div class="serch_area">
                <a href="">아이디 찾기</a>
                <span> / </span>
                <a href="">비밀번호 찾기</a>
            </div>
        </div>
    </section>
</body>
</html>