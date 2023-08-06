$("a.change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/doranboard/doranboard?page=${page}&type=${type}&keyword=${keyword}`;
});

/*$(".sub-category-list").on("click", function(e){
    e.preventDefault();
    let item = $("button[name=item]").val();
    location.href = `/doranboard/doranboard?item=${item}`;
});*/
