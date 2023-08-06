$(document).ready(function(){
    const $ul = $(".wcommunity-webzine-list ul");

    let text = "";
    boards.forEach(board => {
        text += `
                   <li>
                        <a onclick="location.href='/doranboard/dorandetail?id=${board.id}'">
                            <div class="wcommunity-story">
                                <div class="story-info">
                                    <p class="title">${board.title}</p>
                                    <p class="summary">${board.content}</p>
                                    <p class="info"><em class="editor">${board.name}</em>
                                    <em class="date">${board.registerDate}</em>
                                    <em class="symp"></em></p>
                                </div>
                            </div>
                        </a>
                    </li>
        `
    });

    $ul.html(text);
});