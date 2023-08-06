const btn = document.getElementsByName("purchasebtn");
const term = document.querySelectorAll(".term");
const termall = document.querySelector(".allterm");
    termall.addEventListener("click",()=>{
        term.forEach(tr=> {
            tr.checked = termall.checked;
        })
    })

    term.forEach(tr=>{
            tr.addEventListener("click",()=>{
                let cnt=0;
                term.forEach(tr=>{
                    if(tr.checked){
                        cnt++;
                    }
                })
                if(cnt == term.length){
                    termall.checked = true;
                }else{
                    termall.checked =false;
                }
            })
        })





