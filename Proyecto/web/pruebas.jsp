<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/principal.css" type="text/css">
    </head>
    <body>
        <form name="form" action="" method="get">
        <div align="center">
            <div class="cuerpo">
                <%String[] paramBD = {"","jugador","alta"};%>
                <%@include file="WEB-INF/jspf/acciones/accion.jspf" %>
            </div>
            <input type="submit" value="hola" onclick="form.procesar.value=null"/>
            <img src="imagenes/Borrar.png" onclick="form.procesar.value=null;form.submit();"/>
        </div>
        </form>
    </body>
</html>
