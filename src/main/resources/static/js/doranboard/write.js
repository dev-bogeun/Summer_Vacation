const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail .attach");

let sizes = new Array(1).fill(0);

$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes[i] = files[0].size;

    $("span.file-size").eq(i).text((files[0].size / 1024).toFixed(2) + "KB");
    // showSize($("span.file-size").eq(i));

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
    });
    $("img.thumbnail").addClass('original');


    $.ajax({
        url: "/files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(uuids){
            $("#tool").show();


            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();


            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[i] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
            $("img.thumbnail").eq(i).addClass('original');
        }
    });
});

$("form[name=writeForm]").on("submit",function (e) {
    // e.preventDefault();
    let text = ``;
    let count = 0;
    $("img.thumbnail").each((i, img) => {
        let fullPath = $(img).attr("src");
        if(!fullPath) {return;}

        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileType = $(img).hasClass("representative");
        let fileSize = sizes[i];
        text += `
            <input type="hidden" name="files[${count}].filePath" value="${filePath}">
            <input type="hidden" name="files[${count}].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[${count}].fileName" value="${fileName}">
            <input type="hidden" name="files[${count}].fileSize" value="${fileSize}">
        `
            text += `<input type="hidden" name="files[${count}].fileType" value="REPRESENTATIVE">`;
            $("img.thumbnail").addClass('original');
    });
    $(writeForm).append(text);
    $("img.thumbnail").addClass('original');
    // $(writeForm).submit();
})
