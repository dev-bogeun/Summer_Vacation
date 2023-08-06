$(document).ready(function() {
    const $thumbnailimage = $(".thumbnailimage")

    $thumbnailimage.each(function(i,img){
        $("label.attach").eq(i).find("h6").hide();
        $("div.x").eq(i).show();
        $("img.thumbnail").eq(i).show();
        $(img).attr("src", `/files/display?fileName=${files[i].filePath}/${files[i].uuid}_${files[i].originName}`)
    })

});