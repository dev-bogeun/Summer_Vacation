$(".select-menu-hidden-input-box").click(function(){

    $(".select-menu__menu").toggle();

    $(".select-menu__indicator").toggle();


});

$(".select-menu__option").click(function(){

    $(".k").text($(this).text());

    $(".select-menu__menu").toggle();
    $(".select-menu__indicator").toggle();
});

/*$('body').click(function(e){
    if( !$('.select-menu__menu').has(e.target).length ) $('.select-menu__menu').hide();
});*/