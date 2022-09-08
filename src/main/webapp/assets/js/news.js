$("document").ready(function(){
    let query = window.location.search;
    let param = new URLSearchParams(query);
    let cate = param.get('cate');
    selectNewsList(cate);
    if(user_info == null || user_info == "" || user_info == undefined) {
        alert("로그인시 확인가능합니다.");
        location.href = "/";
    }
})

function selectNewsList(seq) {
    $.ajax({
        url:"/api/news/list?cate="+seq,
        type:"get",
        success:function(r) {
            console.log(r.NewsList);
            let tag = '';
            $(".for_news").html("");
            for(let i=0; i<r.NewsList.length; i++) {
                tag 
                '<div class="new_area_wrap">'+
                '<div class="main_news">'+
                    '<div class="news_img">'+
                        '<img src="'+r.NewsList[i].ni_img+'" alt="">'+
                    '</div>'+
                    '<div class="text_area">'+
                    '<h4><a href="">'+r.NewsList[i].ni_title+'</a></h4>'+
                    '<div class="summary_area">'+
                        r.NewsList[i].ni_summary+
                    '</div>'+
                        '<div class="media_area">'+
                            '<p>'+r.NewsList[i].mi_name+' | <a href=""><i class="fa-regular fa-comment"></i> 120</a></p>'+
                        '</div>'+
                    '</div>'+
                '</div>'+
                '<div class="sub_news">'+
                    '<h4><a href="">'+r.NewsList[i].ni_title+'</a> <span>'+r.NewsList[i].mi_name+'</span></h4>'+
                    '<h4><a href="">'+r.NewsList[i].ni_title+'</a> <span>'+r.NewsList[i].mi_name+'</span></h4>'+
                    '<h4><a href="">'+r.NewsList[i].ni_title+'</a> <span>'+r.NewsList[i].mi_name+'</span></h4>'+
                '</div>'+
            '</div>';
            $(".for_news").appen(tag);
            }
        }
    })
}