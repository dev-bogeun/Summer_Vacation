var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

$("#email").on("keyup",function() {
    if ($("#email").val() == "") {
        $("#pemail").html("이메일을 입력해주세요.")
        $("#email").css("borderColor", "red")
        $("#pemail").css("Color", "#red")

        $("#email").focus();
        return false;
    }
    else if(!getMail.test($("#email").val())){
        $("#pemail").html("이메일에 형식에 맞게 입력해주세요.")
        $("#email").css("borderColor", "#f66")
        $("#pemail").css("Color", "#f66")

        $("#mail").val("");
        $("#mail").focus();
        return false;

    }
    else {
        $("#pemail").html("")
        $("#email").css("borderColor", "rgba(0, 0, 0, 0.08)")

        return false;
    }
})
let $email= $("#email");
$("#chkidbtn").on("click",function () {
    $(".text.body1").html("");
    $(".text.headline2").html("");
    $.ajax({
        url: `/join/check-id/${$email.val()}`,
        success:
            function (result) {
                if (result) {
                    $(".text.body1").html("회원으로 등록된 이메일 아이디입니다. <br> 해당 이메일로 로그인하고 티끌을 이용하세요!");
                    $(".text.headline2").html($email.val());

                } else {
                    $(".text.headline2").html($email.val());
                    $(".text.body1").html("는 티끌에 등록되어 있지 않은 계정입니다.");
                }
            }
    });
})