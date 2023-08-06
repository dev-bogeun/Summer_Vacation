$(document).ready(function() {
    const $tr = $(".table-content table");
    let text ="";
    inquirys.forEach(inquiry => {
        text +=
            `
                       <tr onclick="location.href='/admin/inquiry/read?id=${inquiry.id}'" class="tr">
                            <td onclick="event.cancelBubble=true" style="cursor: default">
                            <input type="checkbox" name="check" class="inquiryCheckbox" value="${inquiry.id}"/>
                            </td>
                            <td>${inquiry.id}</td>
                            <td>${inquiry.name}</td>
                            <td>${inquiry.identification}</td>
                            <td>${inquiry.inquireContent}</td>
                            <td>${inquiry.inquireDate}</td>
                            <td>${inquiry.status}</td>
                       </tr>


        `
    });
    $tr.append(text);
})

function getSelectedLectureIds() {
    const inquiryIds = [];
    $(".inquiryCheckbox:checked").each(function() {
        inquiryIds.push($(this).val());
    });
    return inquiryIds;
}


function deleteLectures(inquiryIds) {
    console.log(inquiryIds);
    $.ajax({
        url: "/admin/inquiry/delete",
        type: "POST",
        // method: "DELETE",
        // dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(inquiryIds),
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


