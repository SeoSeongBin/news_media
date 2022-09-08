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
    <link rel="stylesheet" href="/assets/css/reset.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/user/search.js"></script>
    <script src="/assets/js/util.js"></script>
    <title>Document</title>
</head>
<body>
    <section>
        <div class="section_wrap">
            <div class="search_form">
                <div class="id_form">
                    <h2>아이디 찾기</h2>
                    <input type="text" class="id_serch_name" placeholder="이름">
                    <input type="text" class="id_serch_phone" placeholder="전화번호">
                    <button class="id_search">아이디 찾기</button>
                </div>
                <div class="pwd_form">
                    <h2>비밀번호 찾기</h2>
                    <input type="text" class="pwd_serch_id" placeholder="아이디">
                    <input type="text" class="pwd_search_name" placeholder="이름">
                    <input type="text" class="pwd_serch_phone" placeholder="전화번호">
                    <button class="pwd_search">비밀번호 찾기</button>
                </div>
            </div>
        </div>
    </section>
</body>
</html>