let signupBtn = document.getElementById('signupBtn');
let signinBtn = document.getElementById('signinBtn');
let emailField = document.getElementById('emailField');
let emailFieldChild = emailField.getElementsByTagName("*");
let title = document.getElementById('title');

let eye = document.getElementById('eye');
let input = document.getElementById('floatingPassword');

signinBtn.addEventListener('click', change);
signinBtn.addEventListener('click', chgAction1);
signupBtn.addEventListener('click', change2);
signupBtn.addEventListener('click', chgAction2);
eye.addEventListener("click", ojo);

function change(){
    emailField.style.maxHeight = "0";
    title.innerHTML = "Inicio Sesion";
    signupBtn.classList.add("disable");
    signinBtn.classList.remove("disable");
    for(var i = 0; i < emailFieldChild.length; i++){
    	emailFieldChild[i].disabled = true;
    }
}

function change2(){
    emailField.style.maxHeight = "60px";
    title.innerHTML = "Registro";
    signupBtn.classList.remove("disable");
    signinBtn.classList.add("disable");
    for(var i = 0; i < emailFieldChild.length; i++){
    	emailFieldChild[i].disabled = false;
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

function chgAction1()
{
    let button = document.getElementById('send');
	button.formAction = "/login";
}

function chgAction2()
{
    let button = document.getElementById('send');
	button.formAction = "/register";
}