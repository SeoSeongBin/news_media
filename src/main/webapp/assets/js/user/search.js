$("document").ready(function(){

    $(".id_search").click(function(){
        data = {
            ai_name:$(".id_serch_name").val(),
            ai_phone:$(".id_serch_phone").val()
        }
        selectSearchAccount(data);
    })
    $(".pwd_search").click(function(){
        data = {
            ai_id:$(".pwd_serch_id").val(),
            ai_name:$(".pwd_search_name").val(),
            ai_phone:$(".pwd_serch_phone").val()
        }
        selectSearchAccount(data);
    })

})

function selectSearchAccount(data) {
    $.ajax({
        url:"/api/account/search",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(r) {
            alert(r.msg)
        },
        error:function(r) {
            alert(r.responseJSON.msg);
        }
    })
}