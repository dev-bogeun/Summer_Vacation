$(document).ready(function(){
    const $ul = $("#content-wrap ul");

    let text = "";
    posts.forEach(post => {
        text += `
            <li>
                <div>
                    <a href="javascript:void(0)">
                        <section class="content-container">
                            <div class="profile">
                                <div><img src="/images/profile.png" width="15px"></div>
                                <h6 class="writer">${post.memberName}</h6>
                            </div>
                            <h4 class="title">${post.postTitle}</h4>
                            <h6 clss="post-info">
                                <span class="read-count">조회 ${post.postReadCount}</span>
                                <span>·</span>
                                <span class="date">6일 전</span>
                            </h6>
                        </section>
        `
        post.files.forEach(file => {
            if(file.fileType == "REPRESENTATIVE"){
                text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
            }
        })

        text += `
                    </a>
                </div>
            </li>
        `
    });

    $ul.html(text);
});