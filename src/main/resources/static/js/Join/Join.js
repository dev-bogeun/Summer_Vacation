let modal = $('.ReactModalPortal');
let BtnModalView = $('.btn_check_modal_view');
let BtnModalClose = $('.btn_modal_close');
$(modal).hide();

//   전체동의 모달 열기
$(BtnModalView).on('click', function () {
    $(modal).show();
});

//   전체동의 모달 닫기
$(BtnModalClose).on('click', function () {
    $(modal).hide();
});


// 체크박스 활성화
const chkList = $('input[type=checkbox]');
const chk = $('.chk');
const essentialChk = $('.essential_chk');
const agreeAll = $('#termsUpdateRequestCheckBox');
const btn_modal_agree = $('#btn_modal_agree');
const fullAgreement = $('input[name=fullAgreement]');

// madal btn 비활성화
btn_modal_agree.attr('disabled', true);

// checkbox => agreeAll
agreeAll.click(function () {
    console.log('agreeAll');
    if ($(this).is(':checked')) {
        chkList.prop('checked', true);
        btn_modal_agree.attr('disabled', false);
        chkboxCheck = true;
        flagCheck();
    } else {
        chkList.prop('checked', false);
        btn_modal_agree.attr('disabled', true);
        chkboxCheck = false;
        flagCheck();
    }
});

// modal checkbox => fullAgreement
fullAgreement.click(function () {
    console.log('fullAgreement');
    if ($(this).is(':checked')) {
        chkList.prop('checked', true);
        btn_modal_agree.attr('disabled', false);
        chkboxCheck = true;
        flagCheck();

    } else {
        chkList.prop('checked', false);
        btn_modal_agree.attr('disabled', true);
        chkboxCheck = false;
        flagCheck();
    }
});

// check list => select
$('.chk').change(function () {
    if ($('.chk:checked').length >= $('.chk').length) {
        agreeAll.prop('checked', true);
        fullAgreement.prop('checked', true);
        btn_modal_agree.attr('disabled', false);
    } else {
        agreeAll.prop('checked', false);
        fullAgreement.prop('checked', false);
        btn_modal_agree.attr('disabled', true);

    }
});

// essential check list => select
essentialChk.change(function () {
    if ($('.essential_chk:checked').length >= essentialChk.length) {
        btn_modal_agree.attr('disabled', false);
        chkboxCheck = true;
        flagCheck();
    } else {
        btn_modal_agree.attr('disabled', true);
        chkboxCheck = false;
        flagCheck();
    }
});

// madal btn
btn_modal_agree.click(function () {
    $(modal).hide();
});


/* 비밀번호 확인*/
let firstsvg = $('.firstsvg');
let secondsvg = $('.secondsvg');
let checkfirstsvg = $('.checkfirstsvg');
let checksecondsvg = $('.checksecondsvg');

$(secondsvg).hide();
$(checksecondsvg).hide();

$(firstsvg).on('click', function () {
    $(firstsvg).hide();
    $(secondsvg).show();
    $('#password').prop("type", "text");

});

$(secondsvg).on('click', function () {
    $(firstsvg).show();
    $(secondsvg).hide();
    $('#password').prop("type", "password");
});

$(checkfirstsvg).on('click', function () {
    $(checkfirstsvg).hide();
    $(checksecondsvg).show();
    $('#passwordcheck').prop("type", "text");
});

$(checksecondsvg).on('click', function () {
    $(checkfirstsvg).show();
    $(checksecondsvg).hide();
    $('#passwordcheck').prop("type", "password");
});
/*인증하기*/
$(".return").hide()
$(".checkEmail").hide()

$("#checkEmail").on("click", function () {
    $(".return").show()
    $(".checkEmail").show()
    $("#checkEmail").hide()
})
// flag
let emailCheck = false;
let nameCheck = false;
let pwdCheck = false;
let rePwdCheck = false;
let chkboxCheck = false;
let emconfirmchk = false;


// 유효성 검사
var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

$("#email").on("keyup", function () {
    if ($("#email").val() == "") {
        $("#pemail").html("이메일을 입력해주세요.")
        $("#email").css("borderColor", "red")
        $("#email").focus();
        $("#checkEmail").css("opacity", ".45")
        $('#checkEmail').css("pointer-events", "none")
        emailCheck = false;
        flagCheck();
        return false;

    } else if (!getMail.test($("#email").val())) {
        $("#pemail").html("이메일에 형식에 맞게 입력해주세요.")
        $("#email").css("borderColor", "#f66")
        $("#pemail").css("color", "#f66")
        $("#checkEmail").css("opacity", ".45")
        $('#checkEmail').css("pointer-events", "none")
        emailCheck = false;
        flagCheck();
        return false;

    } else {
        $("#pemail").html("")
        $("#email").css("borderColor", "rgba(0, 0, 0, 0.08)")
        $('#checkEmail').css("opacity", "1")
        $('#checkEmail').css("pointer-events", "auto")
            // 아이디 중복검사
            $.ajax({
                url: `/join/check-id/${$(this).val()}`,
                success:function (result) {
                    if (result) {
                        $joinHelp.text("사용중인 아이디입니다.");
                        $joinHelp.css('color', 'red')
                        $("#checkEmail").css("opacity", ".45")
                        $('#checkEmail').css("pointer-events", "none")
                    } else {
                        $joinHelp.text("멋진 아이디네요!");
                        $joinHelp.css('color', '#0D6EFD')
                        $('#checkEmail').css("opacity", "1")
                        $('#checkEmail').css("pointer-events", "auto")

                    }
                }
            });
        emailCheck = true;
        flagCheck();
        return false;
    }
});

$("#name").on("keyup", function () {
    if ($("#name").val() == "") {
        $("#pname").html("이름을 입력해주세요.")
        $("#name").css("borderColor", "red")
        $("#name").focus();
        nameCheck = false;
        flagCheck();
        return false;

    } else {
        $("#pname").html("")
        $("#name").css("borderColor", "rgba(0, 0, 0, 0.08)")
        nameCheck = true;
        console.log(nameCheck);
        flagCheck();
        return false;

    }

});

$("#password").on("keyup", function () {
    if ($("#password").val() == "") {
        $("#password").html("비밀번호를 입력해주세요.")
        $("#password").css("borderColor", "#f66")
        $("#password").focus();
        pwdCheck = false;
        flagCheck();
        return false;

    } else if ($("#password").val().length < 10 || $("#password").val().length > 20) {
        $("#ppassword").html("10자리 이상 20자리 이하로 입력해주세요.")
        $("#password").css("borderColor", "#f66")
        $("#password").focus();
        pwdCheck = false;
        flagCheck();
        return false;

    } else {
        $("#ppassword").html("")
        $("#password").css("borderColor", "rgba(0, 0, 0, 0.08)")
        pwdCheck = true;
        console.log(pwdCheck);
        flagCheck();
        return false;
    }


});

$("#passwordcheck").on("keyup", function () {

    if ($("#passwordcheck").val() == "") {
        $("#ppasswordcheck").html("비밀번호를 입력해주세요.")
        $("#passwordcheck").css("borderColor", "#f66")
        $("#passwordcheck").focus();
        rePwdCheck = false;
        flagCheck();
        return false;

    } else if ($("#passwordcheck").val() != $("#password").val()) {
        $("#ppasswordcheck").html("비밀번호가 다릅니다.")
        $("#passwordcheck").css("borderColor", "#f66")
        $("#passwordcheck").focus();
        rePwdCheck = false;
        flagCheck();
        return false;

    } else {
        $("#ppasswordcheck").html("")
        $("#passwordcheck").css("borderColor", "rgba(0, 0, 0, 0.08)")
        rePwdCheck = true;
        console.log(rePwdCheck);
        flagCheck();
        return false;
    }


});

$(".checkEmail").on("keyup", function () {
    if ($(".checkEmail").val().length == 6) {
        $('.checkEmailbtn').css("opacity", "1")
        $('.checkEmailbtn').css("pointer-events", "auto")
        return false;
    }
    else {
        $('.checkEmailbtn').css("opacity", ".45")
        $('.checkEmailbtn').css("pointer-events", "none")
        return false;
    }
});

// flag check
function flagCheck() {
    if (emailCheck &&  nameCheck && pwdCheck && rePwdCheck && chkboxCheck &&emconfirmchk) {
        console.log(emailCheck);
        console.log(nameCheck);
        console.log(pwdCheck);
        console.log(rePwdCheck);
        $(".submitButton").css("opacity", "1");
        $(".submitButton").css("pointer-events", "auto");
        $(".submitButton").attr('disabled', false);
    } else {
        $(".submitButton").css("opacity", ".45");
        $(".submitButton").css("pointer-events", "none");
        $(".submitButton").attr('disabled', true);
    }
}



let $memail = $("#email");
let $memailconfirmTxt = $("#memailconfirmTxt");
let $memailconfirm = $("#memailconfirm");
let $joinHelp = $("#pemail");

// 이메일 인증번호 발송 함수
$("#checkEmail").click(function() {
    $.ajax({
        type : "POST",
        url : "mailConfirm",
        data:{
            "email" : $memail.val()
        },
        success : function(data){
            showWarnModal("해당 이메일로 인증번호 발송이 완료되었습니다. \n 확인부탁드립니다.")
            console.log("data : "+data);
            chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt);
        }
    })
})

// 이메일 인증번호 체크 함수
function chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt){
    $memailconfirm.on("keyup", function(){
        if (data != $memailconfirm.val()) { //
            emconfirmchk = false;
            $memailconfirmTxt.html("<span id='emconfirmchk'>인증번호가 잘못되었습니다</span>")
            $("#emconfirmchk").css({
                "color" : "#FA3E3E",
                "font-size" : "13px"

            })
        } else { // 아니면 중복아님
            emconfirmchk = true;
            $memailconfirmTxt.html("<span id='emconfirmchk'>인증번호 확인 완료</span>")
            $("#emconfirmchk").css({
                "color" : "#0D6EFD",
                "font-size" : "13px"
            })

        }
    })
}
