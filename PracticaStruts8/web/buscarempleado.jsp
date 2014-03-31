<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="buscarempleado.titulo"/></title>
        <link rel="stylesheet" type="text/css" href="newcss.css"/>   
    </head>
    <body>
        <html:form action="EmpleadoAction">
            <table border="1">
                <tr>
                    <th>Introduzca un ID de empleado</th>
                    <td><html:text property="empno"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <html:submit value="Buscar Empleado"/>
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html>
