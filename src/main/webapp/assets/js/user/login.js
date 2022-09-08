$("document").ready(function(){
    $("#login").click(function(){
        let data = {
            ai_id:$(".id_input").val(),
            ai_pwd:$(".pwd_input").val()
        }
        selectLoginAccount(data)
    })
    $("#join").click(function(){
        location.href = "/user/join"
    })
});

function selectLoginAccount(data) {
    $.ajax({
        url:"/api/account/login",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(r) {
            alert(r.msg);
            location.href = "/news?cate=1";
            // console.log(r);
        },
        error:function(r) {
            // console.log(r);
            alert(r.responseJSON.msg);
        }
    })
}