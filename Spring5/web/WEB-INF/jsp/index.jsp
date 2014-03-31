<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div align="center">
            <div style="border: 2px solid; display: inline-block; padding: 20px;">
                <div style="border: 1px solid; border-bottom: none; padding: 20px">
                    <form name="form1" action="carga.htm" method="post">
                        Seleccione inscripción enfermo:
                        <select name="insEnf">
                            <jstl:forEach items="${enfermos}" var="enfermo">
                                <jstl:if test="${enfermo.inscripcion!=inscripcion}">
                                    <option id="${enfermo.inscripcion}">${enfermo.inscripcion}</option>
                                </jstl:if>
                            </jstl:forEach>
                        </select>
                        <input type="submit" value="Borrar"/>
                    </form>
                </div>
                <table border="1">
                    <tr>
                        <th>Inscripcion</th>
                        <th>Apellido</th>
                        <th>Direccion</th>
                        <th>Fecha de Nacimiento</th>
                    </tr>

                    <jstl:forEach items="${enfermos}" var="enfermo">
                        <tr>
                            <td${(enfermo.inscripcion==inscripcion)?" bgcolor=\"#FF0000\"":""}>
                                <jstl:out value="${enfermo.inscripcion}"/>
                            </td>
                            <td${(enfermo.inscripcion==inscripcion)?" bgcolor=\"#FF0000\"":""}>
                                <jstl:out value="${enfermo.apellido}"/>
                            </td>
                            <td${(enfermo.inscripcion==inscripcion)?" bgcolor=\"#FF0000\"":""}>
                                <jstl:out value="${enfermo.direccion}"/>
                            </td>
                            <td${(enfermo.inscripcion==inscripcion)?" bgcolor=\"#FF0000\"":""}>
                                <jstl:out value="${enfermo.fechaNac}"/>
                            </td>
                        </tr>
                    </jstl:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
