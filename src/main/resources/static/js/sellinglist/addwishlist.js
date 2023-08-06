let heartsbtn=document.querySelectorAll(".WishButton_button__1ZqbG");

heartsbtn.forEach(item=>item.addEventListener('click',function () {
    if(item.getAttribute('aria-pressed')==='true'){
        item.classList.add('wishButton_active__3CKVe');
        item.style.transition="scale 1s";
        item.style.scale= "0.5";
        item.setAttribute('aria-pressed','false');
        item.style.scale= "1.0";
        setTimeout(()=>{item.classList.remove('wishButton_active__3CKVe');},300);

    }else if(item.getAttribute('aria-pressed')==='false'){
        item.classList.add('wishButton_active__3CKVe');
        item.setAttribute('aria-pressed','true');
        setTimeout(()=>{item.classList.remove('wishButton_active__3CKVe')},300);
    }
}));
