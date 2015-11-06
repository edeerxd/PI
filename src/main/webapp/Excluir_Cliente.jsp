<%-- 
    Document   : Back_end_cliente_excluir
    Created on : Oct 26, 2015, 2:06:45 AM
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exclusão de Clientes</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletClienteExcluir" method="post">         
                <fieldset>
                    <legend>Excluir Cliente</legend>
                    <p>
                        <label for="idcliente">Digite o ID do Cliente:</label>
                        <input type="number" name="idCliente" id="idcliente" />
                    </p>
                    <input type="submit" value="Excluir"/>            
                </fieldset>
            </form>
        </div>
        <div id="suc-exc-cliente" class="alert alert-success">
            Cliente excluído com sucesso!
        </div>
        
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-exc-cliente").classList.add("aparecer");
            } else {
                document.getElementById("suc-exc-cliente").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
