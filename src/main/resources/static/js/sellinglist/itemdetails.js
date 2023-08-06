const heartbtn = document.querySelector('.ProductFloatButton_wishButton__2uCyk');
const showmorebtn = document.querySelector('.MoreButton_button__3qNcH');
const container= document.querySelector('.ContentFoldHeight_contentWrap__1Gap2');
const arrow = document.querySelector('.withIcon_icon__3VTbq.MoreButton_icon__2UKz5');



showmorebtn.addEventListener('click',function () {
    container.classList.toggle('active');
    arrow.classList.toggle('turn');
});



heartbtn.addEventListener('click',function () {
    if(heartbtn.getAttribute('aria-pressed')==='true') {
        heartbtn.setAttribute('aria-pressed',   'false');
    }  else{
        heartbtn.setAttribute('aria-pressed', 'true');
    }
});
