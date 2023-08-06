const $writeButton = $("#reply-write-wrap button");
const replyTexts = ['취소', ' ', '댓글 달기'];
const $ul = $("#replies-wrap ul");
let page = 1;
/*=======================================================================*/
/*모듈*/
/*=======================================================================*/
let replyService = (function() {

    function getList(callback) {
        $.ajax({
            url: `/doranboard/doranboard/${doranboardId}/${page}`,
            success: function(replys) {
                if (callback) {
                    callback(replys);
                }
            }
        });
    }

    function remove(id, callback) {
        $.ajax({
            url: `/doranboard/${id}`,
            type: `DELETE`,
            success: function() {
                if (callback) {
                    callback();
                }
            }
        });
    }

    function write(content, callback) {
        $.ajax({
            url: `/doranboard/write`,
            type: `post`,
            data: JSON.stringify({ userId: userId, doranboardId: doranboardId, content: content}),
            contentType: "application/json;charset=utf-8",
            success: function() {
                if (callback) {
                    callback();
                }
            }
        });
    }

    function modify(reply, callback) {
        $.ajax({
            url: "/doranboard/modify",
            type: "put",
            data: JSON.stringify(reply),
            contentType: "application/json;charset=utf-8",
            success: function() {
                if (callback) {
                    callback();
                }
            }
        });
    }

    return {
        getList: getList,
        remove: remove,
        write: write,
        modify: modify
    };
})();



/*=======================================================================*/
/*이벤트, DOM, Ajax*/
/*=======================================================================*/
replyService.getList(showList);

function showList(replys) {
    let text = ``;
    replys.forEach(reply => {
        text += `<li>
                <div>
                    <section class="content-container">
                        <div class="profile">
                            <h6 class="writer">${reply.name}</h6>
                        </div>
                        <h4 class="title">${reply.content}</h4>
                        <section class="reply-update-wrap">
                            <textarea cols="30" rows="1" placeholder="내 댓글"></textarea>
                            <div class="button-wrap">
                                <button class="update-done"  data-reply-id="${reply.id}">작성완료</button>
                                <button class="cancel">취소</button>
                            </div>
                        </section>
                        <h6 class="board-info">
                            <span class="date">${reply.registerDate}</span>
                            `;

        if(userId == reply.userId) {
            text += `
              <span class="date">·</span>
              <span class="update">수정</span>
              <span class="date">·</span>
              <span class="delete" data-reply-id="${reply.id}">삭제</span>
            `;
        }

                        text += `
                        </h6>
                    </section>
                </div>
            </li>`;
    });

    $("#replies-wrap ul").append(text);
}

/* 무한 스크롤 */
$(window).scroll(function() {
    if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
        page++;
        replyService.getList(showList);
    }
});

/*=======================================================================*/
/*퍼블리싱*/
/*=======================================================================*/
let flag = 1;

$("#more-replies").on("mouseover", function() {
    $(this).css("background-color", "rgb(251 117 117 / 85%)");
    $(this).css("color", "black");
});

$("#more-replies").on("mouseout", function() {
    $(this).css("color", "rgb(251 117 117 / 85%)");
    $(this).css("background-color", "");
});

$writeButton.on("mouseover", function() {
    $(this).css("background-color", "#F3F5F7");
});

$writeButton.on("mouseout", function() {
    $(this).css("background-color", "rgb(255 255 255)");
});

/*댓글 작성 완료*/
$writeButton.on("click", function() {
    const $writeTextarea = $("#reply-write-wrap textarea");
    replyService.write($writeTextarea.val(), function() {
        $ul.html("");
        page = 0;
        // $("#reply-write-wrap textarea").text("");
        $("#reply-write-wrap textarea").val("");
        replyService.getList(showList);
    });
});

$ul.on("click", "span.update", function() {
    let i = $ul.find("span.update").index($(this));
    showUpdate(i);
});

$ul.on("click", "button.cancel", function() {
    let i = $ul.find("button.cancel").index($(this));
    hideUpdate(i);
});

/*댓글 수정 완료*/
$ul.on("click", ".update-done", function() {
    let i = $(".update-done").index(this);
    let $textarea = $(".reply-update-wrap textarea").eq(i);
    let replyId = $(this).data("reply-id");
    let reply = {
        content: $textarea.val(),
        id: replyId
    };
    replyService.modify(reply, function() {
        $ul.html("");
        page = 0;
        replyService.getList(showList);
    });
});

function showUpdate(i) {
    let $replyUpdate = $ul.find(".reply-update-wrap").eq(i);
    let content = $replyUpdate.prev().text().trim();
    let $textarea = $replyUpdate.find("textarea");
    $textarea.val(content);
    $replyUpdate.prev().hide();
    $replyUpdate.next().hide();
    $replyUpdate.show();
}

function hideUpdate(i) {
    let $replyUpdate = $ul.find(".reply-update-wrap").eq(i);
    $replyUpdate.hide();
    $replyUpdate.prev().show();
    $replyUpdate.next().show();
}

/*댓글 삭제 완료*/
$ul.on("click", ".delete", function() {
    let replyId = $(this).data("reply-id");
    replyService.remove(replyId, function() {
        $ul.html("");
        page = 0;
        replyService.getList(showList);
    });
});
