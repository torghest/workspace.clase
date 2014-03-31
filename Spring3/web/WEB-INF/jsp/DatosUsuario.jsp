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
                <h1>VISTA USUARIO</h1>

                <form name="form1" action="procesarUsuario.htm">
                    <table border="1">
                        <tr>
                            <th>Nombre:</th>
                            <td>
                                <input type="text" name="txtNombre"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Apellidos:</th>
                            <td>
                                <input type="text" name="txtApellidos"/>
                            </td>
                        </tr>
                       <tr>
                            <th>Edad:</th>
                            <td>
                                <input type="text" name="txtEdad"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Enviar nuevos datos"/>            
                            </td>
                        </tr>
                    </table>
                </form>        

                <h4><jstl:out value="${mensaje}"/></h4>

                <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <td>
                            <jstl:out value="${usuario.nombre}"/>
                        </td>
                    </tr>            
                    <tr>
                        <th>Apellidos</th>
                        <td>
                            <jstl:out value="${usuario.apellidos}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Edad</th>
                        <td>
                            <jstl:out value="${usuario.edad}"/>
                        </td>
                    </tr>            
                </table>
            </div>
        </div>
    </body>
</html>
