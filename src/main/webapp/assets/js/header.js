$("document").ready(function(){
    selectCateList();
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