$("document").ready(function(){

    $(".mod").click(function(){
        if(!confirm("수정하시겠습니까?")) return;
        if(isEmpty($(".pwd").val())) {
            alert("비밀번호를 입력해주세요")
            return;
        }
        if(isEmpty($(".pwd_check").val())) {
            alert("비밀번호 확인을 입력해주세요")
            return;
        }
        if($(".pwd").val() !== $(".pwd_check").val()) {
            alert("변경할 비밀번호와 비밀번호 확인이 일치하지않습니다.")
            return
        }
        data = {
            ai_pwd:$(".pwd").val(),
            ai_name:$(".name").val(),
            ai_phone:$(".phone").val(),
            ai_birth:$(".birth").val(),
            ai_seq:$(".mod").attr("data-seq")
        }
        updateUserInfo(data)
    })


})

function updateUserInfo(data) {
    $.ajax({
        url:"/api/account/update/info",
        type:"patch",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(r) {
            alert(r.msg);
            location.href = "/";
        },
        error:function(r) {
            alert(r.responseJSON.msg);
        }  
    })
}