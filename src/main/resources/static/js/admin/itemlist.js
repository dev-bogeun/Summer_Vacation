$(document).ready(function() {
    const $tr = $(".table-content table");
    let text ="";
    items.forEach(item => {
        text +=
            `
                        <tr class="tr">
                            <td>
                            <input type="checkbox" name="check" class="term"/>
                            </td>
                            <td>${item.id}</td>
                            <td>${item.originStock}</td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                        </tr>

        `
    });
    $tr.append(text);
})