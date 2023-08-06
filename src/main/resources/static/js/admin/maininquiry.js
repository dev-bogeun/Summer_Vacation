$(document).ready(function() {
    let count = 0;
    const $tr = $("table.maininquiry tbody");
    let text ="";
    maininquirys.forEach(maininquiry => {
        if(count == 5){
            return;
        }
        text +=
            `
                             <tr>
                                <td>${maininquiry.identification}</td>
                                <td>${maininquiry.inquireContent}</td>
                                <td>${maininquiry.inquireDate}</td>
                                <td>${maininquiry.status}</td>
                            </tr>
        `
        count++;

    });
    $tr.html(text);
})