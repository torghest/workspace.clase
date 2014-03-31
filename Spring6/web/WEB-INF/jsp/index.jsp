<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo internacionalización</title>
    </head>
    <body>
   
        <spring:message code="etiq.usuario"/><input type="text" name="usuario"/>

        <spring:message code="etiq.clave"/><input type="text" name="clave"/>

    </body>
</html>
