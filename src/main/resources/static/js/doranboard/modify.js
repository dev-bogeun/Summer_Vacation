autosize($("textarea"));
$("span.file-size").hide();

const $upload = $("input.upload");
const $thumbnail = $("img.thumbnail .attach");
let sizes = new Array(4).fill(0);
const fileIdsForDelete = new Array();

function showSize(span) {
    if (span.text() == 0) {
        span.hide();
    } else {
        span.show();
    }
}

//대표 이미지 검사
let representativeFile = files.filter(file => file.fileType == "REPRESENTATIVE");
if (representativeFile.length != 0) {
    let file = representativeFile[0];
    $("div.x").eq(0).show();
    $thumbnail.eq(0).show();

    let fileName = file.filePath + "/t_" + file.fileUuid + "_" + file.fileName;
    $thumbnail.eq(0).attr("src", `/files/display?fileName=${fileName}`);
    $thumbnail.eq(0).addClass("original");
    $thumbnail.eq(0).attr("data-id", file.id);
    sizes[0] = file.fileSize;
    $("span.file-size").eq(0).text((file.fileSize / 1024).toFixed(2) + "KB");
    showSize($("span.file-size").eq(0));
}

files.filter(file => file.fileType != "REPRESENTATIVE").forEach((file, i) => {
    let fileType = file.fileType;
    $("label.attach").eq(i + 1).find("h6").hide();
    $("div.x").eq(i + 1).show();
    $thumbnail.eq(i + 1).show();

    let fileName = file.filePath + "/t_" + file.fileUuid + "_" + file.fileName;
    $thumbnail.eq(i + 1).attr("src", `/files/display?fileName=${fileName}`);
    $thumbnail.eq(i + 1).addClass("original")
    $thumbnail.eq(i + 1).attr("data-id", file.id);
    sizes[i + 1] = file.fileSize;
    $("span.file-size").eq(i + 1).text((file.fileSize / 1024).toFixed(2) + "KB");
    showSize($("span.file-size").eq(i + 1));
});


$upload.on("change", function (e) {
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();
    $thumbnail.eq(0).removeClass('original');

    sizes[i] = files[0].size;
    $("span.file-size").eq(i).text((files[0].size / 1024).toFixed(2) + "KB");
    showSize($("span.file-size").eq(i));

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
    });


    $.ajax({
        url: "/files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (uuids) {
            $("div.x").eq(i).show();
            $("img.thumbnail").eq(i).show();

            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);

        }
    });
});

$("form[name=writeForm]").on("submit", function (e) {
    let text = ``;
    let count = 0;
    $("img.thumbnail").each((i, img) => {
        let fileType = $(img).hasClass("representative");
        let fullPath = $(img).attr("src");
        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileSize = sizes[i];

        text += `
            <input type="hidden" name="files[${count}].filePath" value="${filePath}">
            <input type="hidden" name="files[${count}].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[${count}].fileName" value="${fileName}">
            <input type="hidden" name="files[${count}].fileSize" value="${fileSize}">
        `;
        text += `<input type="hidden" name="files[${i}].fileType" value="REPRESENTATIVE">`
    });

    fileIdsForDelete.forEach((id, i) => {
        text += `<input class="original" type="hidden" name="fileIdsForDelete[${i}]" value="${id}">`;
    })

    $(writeForm).append(text);
    // $(writeForm).submit();
});

// 파일 삭제
$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes[i] = 0;
    $("span.file-size").eq(i).text(sizes[i]);
    showSize($("span.file-size").eq(i));
    $upload.eq(i).val("");
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
    console.log(files[0].fileType);

    if (files[0].fileType == "REPRESENTATIVE"){
        files[0].fileType = "NON";
        console.log("fileType 변경 완료:", files[0]);
    }


    if($thumbnail.eq(i).hasClass("original")){
        fileIdsForDelete.push($thumbnail.eq(i).data("id"));
    }

    $thumbnail.eq(i).removeClass("original");
    $thumbnail.eq(i).hide();
    $('.attach img').css("display","none");
    $('.attach img').removeClass('original');
    $("img.thumbnail").eq(i).addClass('original');
    console.log("들어옴");

});


function checkLength(textarea, max) {
    let value = $(textarea).val();
    let length = value.length > max ? max : value.length;
    max = max.toLocaleString('ko-KR'); //한국 숫자 표기법(끝 3자리 마다 콤마 삽입)
    $(textarea).next().text(`${length}/${max}`);
}

function blockEnter() {
    if (event.keyCode == 13) {
        event.returnValue = false;
    }
}

files.forEach((file, i) => {
    $("img.thumbnail").eq(i).show();
    $("img.thumbnail").addClass('original');

    let fileName = file.filePath + "/t_" + file.fileUuid + "_" + file.fileName;
    $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
})

// //=====================================================================================
// let fileService = (function() {
//     function remove(id, callback) {
//         $.ajax({
//             url: `/files/${id}`,
//             type: `DELETE`,
//             success: function() {
//                 if (callback) {
//                     callback();
//                 }
//             }
//         });
//     }
//     return {
//         remove: remove,
//     };
// })();
//
//
// //파일 삭제
// $(".delete").on("click", function() {
//     let fileId = $(this).data("file-id");
//     fileService.remove(fileId, function() {
//         $ul.html("");
//         page = 0;
//         fileService.getList(showList);
//     });
// });
//
//



