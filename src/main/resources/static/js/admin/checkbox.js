const $all = $(".all");
const $checkboxes = $(".term");
$all.on("click", function () {
    $checkboxes.prop("checked", $(this).is(":checked"));
});


$checkboxes.on("click", function () {
    $all.prop("checked", $checkboxes.filter(":checked").length == 10);
});


$checkboxes.each(function (i, checkbox) {
    if (!($(checkbox).is(":checked"))) {
        $all.prop("checked", false);
    }
});