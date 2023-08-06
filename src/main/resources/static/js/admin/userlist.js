$(document).ready(function() {
    const $tr = $(".table-content table");
    let text ="";
    users.forEach(user => {
        text +=
            `
                        <tr class="tr" location.href="">
                            <td>
                            <input type="checkbox" name="check" class="userCheckbox" value="${user.id}"/>
                            </td>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.identification}</td>
                            <td>${user.address}</td>
                            <td>${user.phoneNumber}</td>
                            <td>${user.status}</td>
                        </tr>

        `
    });
    $tr.append(text);
})

function getSelectedLectureIds() {
    const userIds = [];
    $(".userCheckbox:checked").each(function() {
        userIds.push($(this).val());
    });
    return userIds;
}


function deleteLectures(userIds) {
    console.log(userIds);
    $.ajax({
        url: "/admin/user/modify",
        type: "POST",
        // method: "DELETE",
        // dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(userIds),
        success: function() {
            showWarnModal("휴먼계정으로 전환 성공 하였습니다.");
            setTimeout(() => {
                location.reload();
            }, 1000);
        },
        error: function() {
            showWarnModal("휴먼계정으로 전환 실패 하였습니다.");
        }
    });
}

function getUserIds() {
    const userIds = [];
    $(".userCheckbox:checked").each(function() {
        userIds.push($(this).val());
    });
    return userIds;
}


function ChangeUser(userIds) {
    console.log(userIds);
    $.ajax({
        url: "/admin/user/modifyNormal",
        type: "POST",
        // method: "DELETE",
        // dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(userIds),
        success: function() {
            showWarnModal("일반계정으로 전환 성공 하였습니다.");
            setTimeout(() => {
                location.reload();
            }, 1000);
        },
        error: function() {
            showWarnModal("일반계정으로 전환 실패 하였습니다.");
        }
    });
}
