$(document).ready(function() {
    const $img = $(".program-detail")
    const $thumbnailimage = $(".thumbnailimage")
    let text = "";
    /*files.forEach(file => {

        text +=`
                    <td>썸네일이미지</td>
                    <td>
                        <img
                            width="200px"
                            height="200px"
                            src="/files/display?fileName=${file.filePath}/${file.uuid}_${file.originName}"
                            sizes="(min-width: 0px) and (max-width: 480px) 480px, (min-width: 481px) and (max-width: 980px) 980px, (min-width: 981px) 1280px, 100vw"
                         >
                    </td>
                    <td>상세이미지</td>
                    <td>
                        <img
                            width="1280"
                            height="750"
                            src="/files/display?fileName=${file.filePath}/${file.uuid}_${file.originName}"
                            sizes="(min-width: 0px) and (max-width: 480px) 480px, (min-width: 481px) and (max-width: 980px) 980px, (min-width: 981px) 1280px, 100vw"
                        >
                    </td>



        `
    })*/
    $thumbnailimage.each(function(i,img){
        $(img).attr("src", `/files/display?fileName=${files[i].filePath}/${files[i].uuid}_${files[i].originName}`)
    }  )
    // $img.html(text);

});