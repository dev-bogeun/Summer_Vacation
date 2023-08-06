$('#delete-button').click(function(){
    if($("input:checkbox[name='table-row']:checked").length === 0){
        alert("삭제할 항목을 골라주세요");
        return;
    }

    $("input:checkbox[name='table-row']:checked").each(function(k,kVal){
        console.log("kVal ::", kVal.parentElement.parentElement);
        let remove = kVal.parentElement.parentElement;
        $(remove).remove();
    })
})