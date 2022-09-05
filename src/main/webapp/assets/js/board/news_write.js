$("document").ready(function(){
    editMethod();

    $(".add").click(function(){
        let edit_txt = CKEDITOR.instances.ckedit.getData().replace("\\n", "")
        alert(edit_txt);
    })
})

function editMethod() {
    CKEDITOR.replace(
        'ckedit' ,{
            height:500,
            filebrowserImageUploadUrl:'/image/upload?temp=true',
            // filebrowserUploadUrl:"/Student/computer"
        }
        );

    CKEDITOR.on('dialogDefinnition', function(e){
        var dialogName = e.data.name;
        var dialogDefinnition = e.data.definition;

        switch(dialogName) {
            case 'image':
                // dialogDefinnition.removeContents('info');
                dialogDefinnition.removeContents('Link');
                dialogDefinnition.removeContents('advanced');
            break;
        }
    })
}