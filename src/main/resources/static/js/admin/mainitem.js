$(document).ready(function() {
    let count = 0;
    const $tr = $("table.itemtable tbody");
    let text ="";
    mainitems.forEach(mainitem => {
        if(count == 5){
            return;
        }
        text +=
            `
                             <tr>
                                <td>${mainitem.id}</td>
                                <td>${mainitem.originStock}</td>
                                <td>${mainitem.savingLevelName}</td>
                                <td>${mainitem.name}</td>
                            </tr>
        `
        count++;

    });
    $tr.html(text);
})