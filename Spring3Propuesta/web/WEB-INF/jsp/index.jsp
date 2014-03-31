<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilotabla.css"/>
    </head>
    <body>
        <div align="center">
            <div style="border: 2px solid; display: inline-block; padding: 20px;">
                <form name="form1" action="index.htm">
                    <table>
                        <tr>
                            <td align="left">
                                Apellidos: <input type="text" name="txtApellido"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <input type="submit" value="Buscar"/>            
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table border="1" style="padding: 5px;">
                                    <tr>
                                        <th>Apellido</th>
                                        <th>Oficio</th>
                                        <th>Salario</th>
                                        <th>Comision</th>
                                    </tr>
                                    <jstl:forEach items="${lista}" var="empleado">
                                        <tr>
                                            <td>${empleado.apellido}</td>
                                            <td>${empleado.oficio}</td>
                                            <td>${empleado.salario}</td>
                                            <td>${empleado.comision}</td>
                                        </tr>
                                    </jstl:forEach>
                                </table>
                            </td>
                        </tr>
                    </table>
                </form>        
            </div>
        </div>
    </body>
</html>