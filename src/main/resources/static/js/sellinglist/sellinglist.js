const select = document.querySelectorAll(".OrderSelectDesktop_sortItem__12TKi");
const category= document.querySelectorAll(".ImageTab_tab__3siCY");
const scrollToTop= document.querySelector(".FloatingTopButton_pageTop__2gqm9");
select.forEach(item => item.addEventListener('click',function () {
    select.forEach(item=>{item.classList.remove('OrderSelectDesktop_active__YTP2K');
    })
    item.classList.add('OrderSelectDesktop_active__YTP2K');
}));
category.forEach(item => item.addEventListener('click',function () {
    category.forEach(item=>{item.classList.remove('ImageTab_active__BGdXu');
    })
    item.classList.add('ImageTab_active__BGdXu');
}));

const menubar = document.querySelectorAll(".GNBDesktop_link__1AP6q");
const moremenutop = document.querySelector(".MoreMenuDesktop_container__1I6Al");
const showmenubar = document.querySelector(".Backdrop_backDrop__3v5kD");
window.addEventListener('scroll', function(){
    if(window.scrollY !==0){
        scrollToTop.style.opacity="1";
        scrollToTop.style.transition="0.4s all";
        scrollToTop.style.pointerEvents="auto";
        scrollToTop.setAttribute("disabled", "false");
        scrollToTop.addEventListener('click',function () {
            window.scrollTo({top:0,left:0,behavior:'smooth'});
        });
    }else{
        scrollToTop.style.opacity=0;
        scrollToTop.scale="0";
        scrollToTop.style.transition="0.4s all";
        scrollToTop.style.pointerEvents="none";
        scrollToTop.setAttribute("disabled", "true");
    }
});

