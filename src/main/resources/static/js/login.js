let signupBtn = document.getElementById('signupBtn');
let signinBtn = document.getElementById('signinBtn');
let nombreField = document.getElementById('nombreField');
let nombreFieldChild = nombreField.getElementsByTagName("*");
let title = document.getElementById('title');

let eye = document.getElementById('eye');
let input = document.getElementById('floatingPassword');

signinBtn.addEventListener('click', change);
signupBtn.addEventListener('click', change2);
eye.addEventListener("click", ojo);

function change(){
    nombreField.style.maxHeight = "0";
    title.innerHTML = "Inicio Sesion";
    signupBtn.classList.add("disable");
    signinBtn.classList.remove("disable");
    for(var i = 0; i < nombreFieldChild.length; i++){
    	nombreFieldChild[i].disabled = true;
    }
}

function change2(){
    nombreField.style.maxHeight = "60px";
    title.innerHTML = "Registro";
    signupBtn.classList.remove("disable");
    signinBtn.classList.add("disable");
    for(var i = 0; i < nombreFieldChild.length; i++){
    	nombreFieldChild[i].disabled = false;
    }
}

function ojo(){
    if(eye.classList.contains("fa-eye")){
        eye.classList.remove("fa-eye");
        eye.classList.add("fa-eye-slash");
        input.type="text";
    }
    else{
        eye.classList.remove("fa-eye-slash");
        eye.classList.add("fa-eye");
        input.type="password";
    }
}