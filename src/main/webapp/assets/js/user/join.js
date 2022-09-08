$("document").ready(function(){
    $("#join").click(function(){
        if(!confirm("회원가입하시겠습니까?"))return;

        if(isEmpty($(".id").val())) {
            alert("아이디를 입력해주세요");
            return;
        }else if(isEmpty($(".pwd").val())) {
            alert("비밀번호를 입력해주세요");
            return;
        }else if(isEmpty($(".name").val())) {
            alert("이름을 입력해주세요");
            return;
        }else if(isEmpty($(".phone").val())) {
            alert("전화번호를 입력해주세요");
            return;
        }else if(isEmpty($(".birth").val())) {
            alert("생년월일을 입력해주세요")
            return;
        }
        data = {
            ai_id:$(".id").val(),
            ai_pwd:$(".pwd").val(),
            ai_name:$(".name").val(),
            ai_phone:$(".phone").val(),
            ai_birth:$(".birth").val()
        }
        putAccountAdd(data);
    })
})

function putAccountAdd(data) {

    $.ajax({
        url:"/api/account/add",
        type:"put",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(r) {
            if (r.status == true) {
                location.href = "/";
                alert(r.msg);
            } else {
                alert(r.msg);
            }
        }
    })
}