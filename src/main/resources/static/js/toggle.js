var toggle = document.getElementById('toggle');
var body = document.querySelector('body');
var nav = document.querySelector('nav');

var sun = document.getElementById("sun");
var moon = document.getElementById("moon");

toggle.addEventListener("click", oscuro);
window.addEventListener("scroll", scroll);

if(localStorage.getItem('dark-mode') === 'true'){
    body.classList.add('active');
}else{
    body.classList.remove('active');
}

function oscuro(){
    toggle.classList.toggle('active');
    body.classList.toggle('active');

    if(body.classList.contains('active')){
        localStorage.setItem('dark-mode', 'true');
        sun.style.visibility = "hidden";
        moon.style.visibility = "visible";
    }else{
        localStorage.setItem('dark-mode', 'false');
        sun.style.visibility = "visible";
        moon.style.visibility = "hidden";
    }
}

function scroll(){
    if(window.scrollY){
        nav.classList.add('nav-active');
    }else{
        nav.classList.remove('nav-active');
    }
}

