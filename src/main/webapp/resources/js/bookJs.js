

$(document).ready(function () {
$("#advSearchBtnId2").click(function (){
    advSearchBook();
});


});
function advSearchBook(){
    let title=$("#titleId1").val();
    let isbn=$("#isbnId1").val();
    let author=$("#authorId1").val();
    let publisher=$("#publisherId1").val();
   let publisherDate=$("#publisherDateId1").val();
   let subject=$("#subjectId1").val();
    // let subject = [];
    // $('#subjectId1 :selected').each(function (i, sel) {
    //     subject[i] = $(sel).val();
    // });
    let  data={
        title:title,
        subject:subject,
        isbn:isbn,
        author:author,
        publisher:publisher,
     publisherDate:publisherDate,
    }
    $.ajax({
       url:"advSearchBookForParams",
      data:data,
       dataType:'html',
       type:'Get',
       success:function (response){
           $("#aa").html(response);
       } ,
        error:function (){

        }
    });
}

