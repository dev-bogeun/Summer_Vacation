$(document).ready(function(){
    const $ul = $(".attach-list ul");
    let text = "";
    detail.files.forEach(file => {
        text += `
                    <li>
                `

        if(file.fileType == "REPRESENTATIVE"){
            text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`
        }


    })
         text += `
                   </li>
        `

    $ul.html(text);
});
