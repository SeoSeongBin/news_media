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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/user/join.js"></script>
    <script src="/assets/js/util.js"></script>
    <title>Document</title>
</head>
<body>
    <section>
        <div class="section_wrap">
            <div class="join_box">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input class="id" type="text"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input class="pwd" type="password" placeholder="6자리 이상입력해주세요"></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input class="name" type="text"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input class="phone" type="text"></td>
                    </tr>
                    <tr>
                        <td>생년월일</td>
                        <td><input class="birth" type="text"></td>
                    </tr>
                </table>
                <button id="join">가입하기</button>
            </div>
        </div>
    </section>
</body>
</html>