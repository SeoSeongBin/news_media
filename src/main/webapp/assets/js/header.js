$("document").ready(function(){
    selectCateList();

    $(".logout").click(function(){
        selectAccountLogout();
    })
    $(".my_page").click(function(){
        location.href = "/user/my_page"
    })
})

function selectCateList() {
    $.ajax({
        url:"/api/cate/list",
        type:"get",
        success:function(r) {
            console.log(r);
            $("header nav ul").html("");
            for(let i = 0; i < r.cateList.length; i++){
                let tag = 
                    '<li><a href="/news?cate='+r.cateList[i].cai_seq+'">'+r.cateList[i].cai_name+'</a></li>'
                $("header nav ul").append(tag)
            }

        }
    })
}

function selectAccountLogout() {
    $.ajax({
        url:"/api/account/logout",
        type:"get",
        success:function(r) {
            alert("로그아웃하였습니다.");
            location.href = "/";
        }
    })
}