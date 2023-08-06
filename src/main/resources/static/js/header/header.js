$(window).resize(function(){


    if (window.innerWidth > 758) {
        console.log($(".web-header-mobile"))
        console.log($(".web-header-large"))
        $(".web-header-mobile").hide();
        $(".web-header-large").show();
    }

    else {
        $(".web-header-large").hide();
        $(".web-header-mobile").show();
        console.log($(".web-header-mobile"))
        console.log($(".web-header-large"))
    }

}).resize();