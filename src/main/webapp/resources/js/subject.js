

function moreInfoSubject(idSubject){
    $.ajax({
       url:'subjectMoreInfo' ,
        data:'idSubject='+idSubject,
        dataType:'html',
        type:'GET',
        success:function (response){
$("#more").html(response)
        },
        error:function (){

        },
    });
}