/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", carregar);

var altera = false;

var pesquisa = false;

var idErrado;

function carregar (evt) {
    pesquisa = "false";
    document.getElementById('nomecliente').disabled = true;
    document.getElementById('cpfcliente').disabled = true;
    document.getElementById('telefonecliente').disabled = true;
    document.getElementById('emailcliente').disabled = true;
    document.getElementById('enderecocliente').disabled = true;
    document.getElementById('cidadecliente').disabled = true;
    document.getElementById('estadocliente').disabled = true;
    
    pesquisa = document.getElementById('habilitado').value;  
    if (pesquisa === "true") {
        document.getElementById('nomecliente').disabled = false;
        document.getElementById('cpfcliente').disabled = false;
        document.getElementById('telefonecliente').disabled = false;
        document.getElementById('emailcliente').disabled = false;
        document.getElementById('enderecocliente').disabled = false;
        document.getElementById('cidadecliente').disabled = false;
        document.getElementById('estadocliente').disabled = false;
    }
    
    //Mensagem caso pesquisa não retorne nada     
    if (document.getElementById('semRegistro').value === "true") {
        document.getElementById("alerta-registro").classList.add("aparecer");
    } else {
        document.getElementById("alerta-registro").classList.add("desaparecer");
    }
    
    document.getElementById('btn-alterar').addEventListener("click", alteraEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", alteraEFalso);
}

function alteraEFalso() {
    altera = false;
    
    //Validar id
    var id = document.getElementById('idcliente').value;
    
    if (id !== "") {
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
            idErrado = false;
        } else {
            //alert("teste");
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
            idErrado = true;
        }
    }
}

function alteraEVerdadeiro() {
    altera = true;   
    
    //Validar id
    var id = document.getElementById('idcliente').value;
    
    if (id !== "") {
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
            idErrado = false;
        } else {
            //alert("teste");
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
            idErrado = true;
        }
    }
}

function validarAlterarCliente() {
    if (altera === true && idErrado === false) {
        //Campos
        var estado = document.getElementById('estadocliente').value;
        var id = document.getElementById('idcliente').value;
        var nome = document.getElementById('nomecliente').value;


        //Mensagem de campos em branco e validacao
    //    var brancobool;
    //    if (estado === "0") {
    //        brancobool = false;
    //        alert("Todos os campos devem ser preenchidos!");        
    //        return false;
    //    } else {
    //        brancobool = true;
    //    }    
    
        //Validar id
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
        } else {
            //alert("teste");
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
        }

        //Validar nome
        var nomebool;    
        var letters = /^[A-Za-z]+$/;
        if(nome.match(letters)) {
            nomebool = true;
        } else {
            document.getElementById("err-campo-nome").classList.add("aparecer");
            nomebool = false;
        }

        //Checa todos os campos
        if (nomebool === true && idbool === true) {
            return true;
        }
        else {
            return false;
        }
    }
    else if (altera === false && idErrado === false) {
        return true;
    }
    else {
        return false;
    }
};

function erroNome() {
    var nome = document.getElementById('nomecliente').value;
    
    //Validar nome
    var nomebool;    
    var letters = /^[A-Za-z]+$/;
    if(nome.match(letters)) {
        
    } else {
        document.getElementById("err-campo-nome").classList.add("aparecer");
    }
}


