function getSelectedProgramIds() {
    const programIds = [];
    $(".programCheckbox:checked").each(function() {
        programIds.push($(this).val());
    });
    return programIds;
}


function deletePrograms(programIds) {
    console.log(programIds);
    $.ajax({
        url: "/admin/program/delete",
        type: "POST",
        // method: "DELETE",
        // dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(programIds),
        success: function() {
            showWarnModal("삭제에 성공 하였습니다.");
            setTimeout(() => {
                location.reload();
            }, 1000);
        },
        error: function() {
            showWarnModal("삭제에 실패 하였습니다.");
        }
    });
}