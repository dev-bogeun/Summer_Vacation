$(document).ready(function() {
    $("#saveBtn").click(function() {
        // 현재 비밀번호, 새 비밀번호, 새 비밀번호 확인 값을 가져옴
        const oldPassword = $("#oldPassword").val();
        const newPassword = $("#newPassword").val();
        const newPasswordConfirm = $("#newPasswordConfirm").val();

        // 현재 비밀번호와 새 비밀번호가 일치하는지 확인
        if (oldPassword !== '1234') {
            $("#oldPasswordError").show();
            $("#oldPassword").css("borderColor", "#f66")
            return;
        } else {
            $("#oldPasswordError").hide();
            $("#oldPassword").css("borderColor", "")
        }

        // 새 비밀번호와 새 비밀번호 확인이 일치하는지 확인
        if (newPassword !== newPasswordConfirm) {
            $(".error-text:last-of-type").show();
            $("#newPassword").css("borderColor", "#f66")
            $("#newPasswordConfirm").css("borderColor", "#f66")
            $("#passwordError").css("color", "red")
            return;
        } else {
            $(".error-text:last-of-type").hide();
            $("#newPassword").css("borderColor", "")
            $("#newPasswordConfirm").css("borderColor", "")
            $("#passwordError").css("color", "")
        }
        // 새 비밀번호가 영문, 숫자, 특수문자 조합의 8자 이상인지 확인
        const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*+=-]).{8,}$/;
        if (!passwordRegex.test(newPassword)) {
            $("#passwordError").css("color", "red")
            $("#newPassword").css("borderColor", "#f66")
            $("#newPasswordConfirm").css("borderColor", "#f66")
            return;
        } else {
            $("#newPassword").css("borderColor",     "")
            $("#newPasswordConfirm").css("borderColor", "")
        }
    });
});


