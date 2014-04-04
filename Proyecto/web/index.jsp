<%@page contentType="text/html"%>
<%@include file="WEB-INF/jspf/includes.jspf" %>
<html>
    <head>
        <title>
            Titulo
        </title>
    </head>
    <body>
        <div align="center">
            <div style="position: relative; border: 3px solid; background: <%=properties.FONDO_AUXILIAR%>; display: inline-block">
                <div style="float: left; padding-right: 10px; margin-left: -24px; margin-right: 0px; padding-right: 0px;">
                    <!--menu-->
                    <%@include file="WEB-INF/jspf/menu/menuLateral.jspf" %>
                </div>
                <div style="margin-top: 16px; margin-right: 16px; border: 3px solid <%=properties.FONDO_SECUNDARIO%>; float: left; background-color: <%=properties.FONDO_PRINCIPAL%>; width: 750px; height: 500px; overflow: auto; padding: 10px;">
                    <!--cuerpo-->
                    <%@include file="WEB-INF/jspf/menu/menuSuperior.jspf" %>
                    <%@include file="WEB-INF/jspf/fragmento.jspf" %>
                </div>
                <div style="float: bottom; margin: 16px; text-align: right">
                    <span style="font-style: italic; font-weight: bolder; padding: 3px 8px; background-color: <%=properties.FONDO_SECUNDARIO%>;">Designed by <a href="mailto:torghest@gmail.com" style="text-decoration: none; color: olive; font-style: normal;">Torghest</a></span>
                </div>
            </div>
        </div>
    </body>
</html> 