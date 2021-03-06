/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", carregar);

//variáveis de verificação
var exclui = false;

var idErrado = false;

function carregar (evt) {        
    //Mensagem caso pesquisa não retorne nada     
    if (document.getElementById('semRegistro').value === "true") {
        document.getElementById("exc-alert-reg").classList.add("aparecer");
    } else {
        document.getElementById("exc-alert-reg").classList.add("desaparecer");        
    }
    
    //Mostra informações da filial caso ela exista    
    if (document.getElementById('filialExiste').value === "true") {
        var filialInfo = document.getElementsByClassName("consulta-excluir");
        filialInfo[0].style.display = "block";
    }
    
    //Eventos de clique
    document.getElementById('btn-excluir').addEventListener("click", excluiEVerdadeiro);
    document.getElementById('btn-pesquisar').addEventListener("click", excluiEFalso);
}

function excluiEFalso() {
    exclui = false;
    
    //Validar id
    var id = document.getElementById('idfilial').value;
    
    if (id !== "") {
        var idbool;    
        var numeros = /^\d+$/;
        if(id.match(numeros)) {
            idbool = true;
            idErrado = false;
        } else {
            document.getElementById("err-campo-id").classList.add("aparecer");
            idbool = false;
            idErrado = true;
        }
    }
}

function excluiEVerdadeiro() {
    exclui = true;    
}

//Função que valida campo
function validarExcluirFilial() {
    if (exclui === true && idErrado === false) {
        //Campos
        var id = document.getElementById('idfilial').value;
    
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

        //Checa todos os campos
        if (idbool === true) {
            return true;
        }
        else {
            return false;
        }
    }
    else if (exclui === false && idErrado === false) {
        return true;
    }
    else {
        return false;
    }
};



