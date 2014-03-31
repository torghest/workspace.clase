<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="index.titulo"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
        <div align="center">
            <img src="imagenes/CarnetMadridista.bmp"/>
            <br/>
            <br/>
            <div style="border: 3px solid #33AA33; background-color: #CC99FF; display: inline-block; padding: 10px;">
                <img src="imagenes/flag-english.gif"/>
                <a href="formulario.jsp?lg=en" style="color: aliceblue;"><bean:message key="index.ingles"/></a>
                &nbsp;&nbsp;
                <img src="imagenes/flag-spanish.gif"/>
                <a href="formulario.jsp?lg=es" style="color: aliceblue;"><bean:message key="index.español"/></a>
            </div>
        </div>
    </body>
</html>