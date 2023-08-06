var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
$("#password").on("keyup",function() {
    if ($("#password").val() == "") {
        $("#ppassword").html("비밀번호를 입력해주세요.")
        $("#password").css("borderColor", "#f66")
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
});
$("#email").on("keyup",function() {
    if ($("#email").val() == "") {
        $("#checkEmail").attr("disabled",true);
        $("#pemail").html("이메일을 입력해주세요.")
        $("#email").css("borderColor", "red")
        $("#email").focus();
        return false;
    }
    else if(!getMail.test($("#email").val())){
        $("#checkEmail").attr("disabled",true);
        $("#pemail").html("이메일에 형식에 맞게 입력해주세요.")
        $("#email").css("borderColor", "#f66")
        $("#pemail").css("Color", "#f66")

        $("#mail").val("");
        $("#mail").focus();
        return false;

    }
    else {
        $("#checkEmail").attr("disabled",false);
        $("#pemail").html("")
        $("#email").css("borderColor", "rgba(0, 0, 0, 0.08)")
        return false;
    }
});




let $memail = $("#email");
let $memailconfirmTxt = $("#memailconfirmTxt");
let $memailconfirm = $("#memailconfirm");
let $password =$("#password");
$(".form-group").hide();
$("#changepwdiv").hide();
$("#checkEmail").click(function() {
    $.ajax({
        type : "POST",
        url : "checkemailisSocial",
        data : {
            "email" : $memail.val()
        },
        success : function(data){
            if(data== 'NORMAL'){sendemail($memail);}
            else if(data == 'KAKAO'||data == 'NAVER'){showWarnModal("소셜회원은 비밀번호를 변경할 수 없습니다")}
            else{showWarnModal("아이디를 찾을 수 없습니다.")}
        }
    })
})
function sendemail($email) {
    $.ajax({
        type : "POST",
        url : "mailConfirm",
        data : {
            "email" : $memail.val()
        },
        success : function(data){
            showWarnModal(`해당 이메일로 인증번호 발송이 완료되었습니다. 확인부탁드립니다.`)
            chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt);
            $(".form-group").show();
        }
    })
}
// 이메일 인증번호 체크 함수
function chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt){
    $memailconfirm.on("keyup", function(){
        if (data != $memailconfirm.val()) { //
            $("#emailOk").attr("disabled",true);
            $memailconfirmTxt.html("<span id='emconfirmchk'>인증번호가 잘못되었습니다</span>")
            $("#emconfirmchk").css({
                "color" : "#FA3E3E",
                "font-weight" : "bold",
                "font-size" : "12px"
            })
        } else { // 아니면 중복아님
            $("#emailOk").attr("disabled",false);
            $memailconfirmTxt.html("<span id='emconfirmchk'>인증번호 확인 완료</span>")
            $("#emconfirmchk").css({
                "color" : "#0D6EFD",
                "font-weight" : "bold",
                "font-size" : "12px"
            })
        }
    })
}
$("#passwordcheck").on("keyup",function() {
    if ($("#passwordcheck").val() == "") {
        $("#ppasswordcheck").html("비밀번호를 입력해주세요.")
        $("#passwordcheck").css("borderColor", "#f66")
        $("#passwordcheck").focus();
        return false;
    }
    else if ($("#passwordcheck").val() != $("#password").val()) {
        $("#ppasswordcheck").html("비밀번호가 다릅니다.")
        $("#passwordcheck").css("borderColor", "#f66")
        $("#passwordcheck").focus();
        return false;
    }

    else {
        $("#ppasswordcheck").html("")
        $("#passwordcheck").css("borderColor", "rgba(0, 0, 0, 0.08)")
        return false;
    }
});
$("#emailOk").click(function() {
    $(".container.id-check").hide();
    $("#changepwdiv").show();
})


$("#passwordcheck").on("keyup",function() {
    if ($("#passwordcheck").val() == "") {
        $("#ppasswordcheck").html("비밀번호를 입력해주세요.")
        $("#passwordcheck").css("borderColor", "#f66")
        $("#passwordcheck").focus();
        $("#goChangePw").attr("disabled",true);
        return false;
    }
    else if ($("#passwordcheck").val() != $("#password").val()) {
        $("#ppasswordcheck").html("비밀번호가 다릅니다.")
        $("#passwordcheck").css("borderColor", "#f66")
        $("#passwordcheck").focus();
        $("#goChangePw").attr("disabled",true);
        return false;
    }

    else {
        $("#ppasswordcheck").html("")
        $("#passwordcheck").css("borderColor", "rgba(0, 0, 0, 0.08)")
        $("#goChangePw").attr("disabled",false);
        return false;
    }
});

$("#goChangePw").on('click',function(){
    $.ajax({
        type : "POST",
        url : "gofindpw",
        data : {
            "email" : $memail.val(),
            "password" : $password.val()
        },
        success : function(result){
            if(result === $password.val()){
                showWarnModal("입력하신 비밀번호가 이전 비밀번호와 같습니다.");
            }else{
                changepw();
            }
        }
    })
});


function changepw() {
    $.ajax({
        type : "POST",
        url : "changepw",
        data : {
            "email" : $memail.val(),
            "password" : $password.val()
        },
        success : function(result){
            location.replace(result);
        }
    })
}
