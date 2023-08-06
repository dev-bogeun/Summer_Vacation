$(document).ready(function() {
    let count = 0;
    const $tr = $("table.userstable tbody");
    let text ="";
    mainusers.forEach(mainuser => {
        if(count == 5){
            return;
        }
        text +=
            `
                             <tr>
                                <td>${mainuser.name}</td>
                                <td>${mainuser.identification}</td>
                                <td>${mainuser.createdDate}</td>
                            </tr>
        `
        count++;

    });
    $tr.html(text);
})