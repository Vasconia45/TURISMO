let key = 'zsTX4aqqzqXyvem';
let id = '8050';

let temperaturaValor = document.getElementById('temperatura-valor');
let temperaturaDescripcion = document.getElementById('temperatura-descripcion');

let ubicacion = document.getElementById('ubicacion');
let iconoAnimado = document.getElementById('icono-animado');

let vientoVelocidad = document.getElementById('viento-velocidad');

let getWeatherDonostia = () =>{
    let url =  'https://api.tutiempo.net/json/?lan=es&apid=zsTX4aqqzqXyvem&lid=4917';
    fetch(url).then((resp) => resp.json()).then(data =>{
        console.log(data);
        let temp = data.day1.temperature_max;
        temperaturaValor.textContent = `${temp} ºC`;

        let desc = data.day1.text;
        temperaturaDescripcion.textContent = desc.toUpperCase();

        vientoVelocidad.textContent = `${data.day1.wind} m/s`;


        //ICONOS
        switch(data.day1.text){
            case 'Cubierto':
                iconoAnimado.src = './amcharts/animated/cloudy.svg';
                break;
            case 'Cubierto con lluvias':
                iconoAnimado.src = './amcharts/animated/rainy-5.svg';
                break;
            case 'Muy nuboso con lluvias':
                iconoAnimado.src = './amcharts/animated/rainy-6.svg';
                break;
        }
    })
    .catch(error => {
        console.log(error);
    })
}

let temperaturaValor2 = document.getElementById('temperatura-valor2');
let temperaturaDescripcion2 = document.getElementById('temperatura-descripcion2');

let ubicacion2 = document.getElementById('ubicacion2');
let iconoAnimado2 = document.getElementById('icono-animado2');

let vientoVelocidad2 = document.getElementById('viento-velocidad2');

let getWeatherBilbao = () =>{
    let url =  'https://api.tutiempo.net/json/?lan=es&apid=zsTX4aqqzqXyvem&lid=8050';
    fetch(url).then((resp) => resp.json()).then(data =>{
        console.log(data);
        let temp = data.day1.temperature_max;
        temperaturaValor2.textContent = `${temp} ºC`;

        let desc = data.day1.text;
        temperaturaDescripcion2.textContent = desc.toUpperCase();

        vientoVelocidad2.textContent = `${data.day1.wind} m/s`;


        //ICONOS
        switch(data.day1.text){
            case 'Cubierto':
                iconoAnimado.src = './amcharts/animated/cloudy.svg';
                break;
            case 'Cubierto con lluvias':
                iconoAnimado.src = './amcharts/animated/rainy-5.svg';
                break;
            case 'Muy nuboso con lluvias':
                iconoAnimado.src = './amcharts/animated/rainy-6.svg';
                break;
            default:
                iconoAnimado.src = './amcharts/animated/day.svg';
                break;
        }
    })
    .catch(error => {
        console.log(error);
    })
}

let temperaturaValor3 = document.getElementById('temperatura-valor3');
let temperaturaDescripcion3 = document.getElementById('temperatura-descripcion3');

let ubicacion3 = document.getElementById('ubicacion3');
let iconoAnimado3 = document.getElementById('icono-animado3');

let vientoVelocidad3 = document.getElementById('viento-velocidad3');

let getWeatherVitoria = () =>{
    let url =  'https://api.tutiempo.net/json/?lan=es&apid=zsTX4aqqzqXyvem&lid=4836';
    fetch(url).then((resp) => resp.json()).then(data =>{
        console.log(data);
        let temp = data.day1.temperature_max;
        temperaturaValor3.textContent = `${temp} ºC`;

        let desc = data.day1.text;
        temperaturaDescripcion3.textContent = desc.toUpperCase();

        vientoVelocidad3.textContent = `${data.day1.wind} m/s`;


        //ICONOS
        switch(data.day1.text){
            case 'Cubierto':
                iconoAnimado.src = './amcharts/animated/cloudy.svg';
                break;
            case 'Cubierto con lluvias':
                iconoAnimado.src = './amcharts/animated/rainy-5.svg';
                break;
            case 'Muy nuboso con lluvias':
                iconoAnimado.src = './amcharts/animated/rainy-6.svg';
                break;
            default:
                iconoAnimado.src = './amcharts/animated/day.svg';
                break;
        }
    })
    .catch(error => {
        console.log(error);
    })
}

window.onload = getWeatherDonostia();


window.onload = getWeatherBilbao();

window.onload = getWeatherVitoria();


