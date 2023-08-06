var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

$("#email").on("keyup",function() {
    if ($("#email").val() == "") {
        $("#pemail").html("이메일을 입력해주세요.")
        $("#email").css("borderColor", "red")
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
});
$("#password").on("keyup",function() {
    if ($("#password").val() == "") {
        $("#ppassword").html("비밀번호를 입력해주세요.")
        $("#password").css("borderColor", "red")
        $("#password").focus();
        return false;
    }
    else if ($("#password").val().length < 10 || $("#password").val().length > 20) {
        $("#ppassword").html("10자리 이상 20자리 이하로 입력해주세요.")
        $("#password").css("borderColor", "#f66")
        $("#password").focus();
        return false;
    }

    else {
        $("#ppassword").html("")
        $("#password").css("borderColor", "rgba(0, 0, 0, 0.08)")
        return false;
    }
})


let $id = $("#email");
let $password = $("#password");

function send(){
    if(!$id.val()){
        showWarnModal("아이디를 입력해주세요!");
        return;
    }
    if(!$password.val()){
        showWarnModal("비밀번호를 입력해주세요!");
        return;
    }
    document.login.submit();
}
