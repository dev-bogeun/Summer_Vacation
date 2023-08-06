$("span.file-size").hide();

const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");
let sizes = new Array(2).fill(0);
const fileIdsForDelete = new Array();

function showSize(span){
    if(span.text() == 0){
        span.hide();
    }else{
        span.show();
    }
}

files.forEach((file, i) => {
    $("label.attach").eq(i).find("h6").hide();
    $("div.x").eq(i).show();
    $thumbnail.eq(i).show();

    let fileName = file.filePath + "/t_" + file.uuid + "_" + file.orginName;
    $thumbnail.eq(i).attr("src", `/files/display?fileName=${fileName}`);
    $thumbnail.eq(i).addClass("original")
    $thumbnail.eq(i).attr("data-id", file.id);
    sizes[i] = (file.fileSize / 1024).toFixed(2);
    $("span.file-size").eq(i).text((file.fileSize / 1024).toFixed(2) + "KB");
    showSize($("span.file-size").eq(i));
});

$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

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
        success: function(uuids){
            $("label.attach").eq(i).find("h6").hide();
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

$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes[i] = 0;
    $("span.file-size").eq(i).text(sizes[i]);
    showSize($("span.file-size").eq(i));
    $upload.eq(i).val("");
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();

    if($thumbnail.eq(i).hasClass("original")){
        fileIdsForDelete.push($thumbnail.eq(i).data("id"));
    }
    $thumbnail.eq(i).removeClass("original");
});


$("input.ok-button").on("click", function(){
    const imgs = $("img.thumbnail").filter((i, img) => $(img).attr("src") && !$(img).hasClass("original"));
    let text = ``;
    imgs.each((i, img) => {
        let fullPath = $(img).attr("src");
        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let uuid = datas[1];
        let originName = datas[2];
        let fileSize = sizes[i];

        text += `
            <input type="hidden" name="files[${i}].filePath" value="${filePath}">
            <input type="hidden" name="files[${i}].uuid" value="${uuid}">
            <input type="hidden" name="files[${i}].originName" value="${originName}">
            <input type="hidden" name="files[${i}].fileSize" value="${fileSize}">
        `;
        if(i == 0){
            text +=`<input type="hidden" name="files[${i}].fileType" value="REPRESENTATIVE">`
        }
    });

    fileIdsForDelete.forEach((id, i) => {
        text += `<input type="hidden" name="fileIdsForDelete[${i}]" value="${id}">`;
    })

    $(writeForm).append(text);
    $(writeForm).submit();
});

function checkLength(textarea, max){
    let value = $(textarea).val();
    let length = value.length > max ? max : value.length;
    max = max.toLocaleString('ko-KR'); //한국 숫자 표기법(끝 3자리 마다 콤마 삽입)
    $(textarea).next().text(`${length}/${max}`);
}

function blockEnter(){
    if(event.keyCode == 13) {
        event.returnValue = false;
    }
}