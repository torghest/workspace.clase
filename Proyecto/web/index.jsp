<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/includes.jspf" %>
<html>
    <head>
        <title>
            Titulo
        </title>
        <link rel="stylesheet" href="css/principal.css" type="text/css">
    </head>
    <body>
        <form name="form" action="" method="post">
        <div align="center">
            <div style="position: relative; border: 3px solid; background: <%=properties.FONDO_AUXILIAR%>; display: inline-block">
                <div style="float: left; padding-right: 10px; margin-left: -24px; margin-right: 0px; padding-right: 0px;">
                    <!--menu-->
                    <%@include file="WEB-INF/jspf/menu/menuLateral.jspf" %>
                </div>
                <div style="margin-top: 16px; margin-right: 16px; padding: 20px; border: 3px solid <%=properties.FONDO_SECUNDARIO%>; float: left; background-color: <%=properties.FONDO_PRINCIPAL%>; width: 750px; height: 455px; overflow: auto;">
                    <!--cuerpo-->
                    <%@include file="WEB-INF/jspf/menu/menuSuperior.jspf" %>
                    <%
                    String a = submenu.getJspf();
                    String[] paramBD = a.split("%");
//                    out.println("Direccion: " + paramBD[0]);
                    
                    if (paramBD[0].equals("accion")){
                    %>
                        <%@include file="WEB-INF/jspf/acciones/accion.jspf" %>
                    <%
                    } else if (paramBD[0].equals("noticias")){
                    %>
                        <%@include file="WEB-INF/jspf/fragmento.jspf" %>
                    <%
                    } else if (paramBD[0].equals("proximamente")){
                    %>
                        <%@include file="WEB-INF/jspf/proximamente.jspf" %>
                    <%
                    }
                    %>
                </div>
                <div style="float: bottom; margin: 16px; text-align: right">
                    <span style="font-style: italic; font-weight: bolder; padding: 3px 8px; background-color: <%=properties.FONDO_SECUNDARIO%>;">Designed by <a href="mailto:torghest@gmail.com" style="text-decoration: none; color: olive; font-style: normal;">Torghest</a></span>
                </div>
            </div>
        </div>
        </form>
    </body>
</html> 