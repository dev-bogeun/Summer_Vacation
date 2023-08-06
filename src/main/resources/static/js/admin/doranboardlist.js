$(document).ready(function() {
    const $tr = $(".table-content table");
    let text ="";
    doranBoards.forEach(doranboard => {
        text +=
            `
                        <tr onclick="location.href='/admin/doranBoard/read?id=${doranboard.id}'" class="tr">
                            <td onclick="event.cancelBubble=true" style="cursor: default">
                                <input type="checkbox" name="check" class="doranBoardCheckbox" value="${doranboard.id}"/>
                            </td>
                            <td>${doranboard.id}</td>
                            <td>${doranboard.identification}</td>
                            <td>${doranboard.title}</td>
                            <td>${doranboard.content}</td>
                            <td>${doranboard.registerDate}</td>
                            <td>${doranboard.viewCount}</td>
                        </tr>


        `
    });
    $tr.append(text);
})

function getSelectedDoranBoardIds() {
    const doranBoardIds = [];
    $(".doranBoardCheckbox:checked").each(function() {
        doranBoardIds.push($(this).val());
    });
    return doranBoardIds;
}


function deleteDoranBoards(doranBoardIds) {
    console.log(doranBoardIds);
    $.ajax({
        url: "/admin/doranBoard/delete",
        type: "POST",
        // method: "DELETE",
        // dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(doranBoardIds),
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
