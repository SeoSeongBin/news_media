$("document").ready(function(){
    let query = window.location.search;
    let param = new URLSearchParams(query);
    let seq = param.get('seq');

    $(".mod").click(function(){
        $(".change_pwd")
        if(!confirm("수정하시겠습니까?")) return;

        if(isEmpty($(".change_pwd").val())) {
            alert("비밀번호를 입력해주세요")
            return;
        }
        if(isEmpty($(".change_pwd_check").val())) {
            alert("비밀번호 확인을 입력해주세요")
            return;
        }
        if($(".change_pwd").val() !== $(".change_pwd_check").val()) {
            alert("변경할 비밀번호와 비밀번호 확인이 일치하지않습니다.")
            return;
        }else {
            updateUserPwd(seq, $(".change_pwd").val())
        }
    })
})

function updateUserPwd(seq, pwd) {
    $.ajax({
        url:"/api/account/update/pwd?seq="+seq+"&pwd="+pwd,
        type:"patch",
        success:function(r) {
            alert(r.msg);
            location.href="/";
        },
        error:function(r) {
            alert(r.responseJSON.msg);
        }
    })
}