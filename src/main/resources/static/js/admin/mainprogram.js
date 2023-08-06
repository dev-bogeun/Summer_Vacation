$(document).ready(function() {
    let count = 0;
    const $tr = $("table.programtable tbody");
    let text ="";
    mainsavinglevels.forEach(savinglevel => {
        if(count == 5){
            return;
        }
        text +=
            `
                             <tr>
                                <td>${savinglevel.id}</td>
                                <td>${savinglevel.name}</td>
                                <td>${savinglevel.goalMoney}</td>
                                <td>${savinglevel.dailyMoney}</td>
                            </tr>
        `
        count++;

    });
    $tr.html(text);
})