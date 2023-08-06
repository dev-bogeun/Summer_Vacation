const banner = document.querySelector("div.banner");
const img_divs = document.querySelectorAll("div.banner div");
img_divs.forEach((img_divs, i) => img_divs.style.backgroundImage = `url(../../../static/image/${i+1}.png`);
let count = 0;

setInterval(() => autoSlide(), 3000);
function autoSlide() {
    if(count == 2) {count = -1;}
    banner.style.transform = `translate(${-innerWidth * ++count}px`;
    banner.style.transition = "transform 0.7s"
}