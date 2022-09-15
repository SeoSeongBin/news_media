<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/user/my_page.js"></script>
</head>
<body>
    <section>
        <div class="section_wrap">
            <h2>MY PAGE</h2>
            <div class="my_info">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td>${sessionInfo.ai_id}</td>
                    </tr>
                    <tr>
                        <td>변경 할 비밀번호</td>
                        <td><input class="pwd" type="password"></td>
                    </tr>
                    <tr>
                        <td>변경 할 비밀번호확인</td>
                        <td><input class="pwd_check" type="password"></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input type="text" class="name" value="${sessionInfo.ai_name}"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" class="phone" value="${sessionInfo.ai_phone}"></td>
                    </tr>
                    <tr>
                        <td>생년월일</td>
                        <td><input type="date" class="birth" value="<fmt:formatDate value="${sessionInfo.ai_birth}" pattern="yyyy-MM-dd"></fmt:formatDate>" pattern="yyyy-MM-dd"></td>
                    </tr>
                </table>
            </div>
            <button class="mod" data-seq="${sessionInfo.ai_seq}">수정하기</button>
        </div>
    </section>
</body>
</html>