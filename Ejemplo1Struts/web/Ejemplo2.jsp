<%-- 
    Document   : Internacionalizacion
    Created on : 07-mar-2014, 8:58:33
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
    </head>
<body>
    <center>
        <table border="0" width="100%">
            <tr>
                <td width="50%">
                    <bean:message key="app.peque"/>
                </td> 
            </tr>
            <tr>
                <td>
                    <img src="<bean:message key="app.bandera"/>" width="32" height="32">
                </td>
            </tr>
            <tr>
                <td  width="50%">
                    <img src="imagenes/peque.jpg" width="363" height="285">
                </td>
            </tr>
        </table>
    </center>                
</body>
</html>
