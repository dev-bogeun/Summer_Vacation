const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");

$("img.preview").each(function(i){
    if(!$(this).attr("src")){
        $(this).hide();
    }
});

let sizes = new Array();
$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes.push(files[0].size);

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
            console.log("hi")
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
    sizes = sizes.splice(i, 1);
    $upload.eq(i).val("");
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
});

$("input.ok-button").on("click", function(){
    const imgs = $("img.thumbnail").filter((i, img) => $(img).attr("src"));
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
        `
    });
    $(writeForm).append(text);
    $(writeForm).submit();
});