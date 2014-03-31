<%-- 
    Document   : index
    Created on : 10-mar-2014, 8:25:04
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>


<sql:setDataSource driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="system" password="javaoracle"/>
<sql:query var="Monedas">
  SELECT id,foto,descripcion,precio,pais,año FROM monedas
</sql:query>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo Numismático</title>
    </head>
    <body>
        <div align="center">
            <div style="border: 2px solid; display: inline-block;">
                <form name="form" action="pedido.jsp" method="post">
                    <c:forEach items="${Monedas.rows}" var="moneda">
                        <div id="${moneda.id}">
                            <table border="2" width="100%">
                                <tr>
                                    <td align="center" style="padding: 5px">
                                        <img src="imagenes/${moneda.foto}" height="80">
                                    </td>
                                    <td>
                                        <table border="1" cellspacing="0" cellpadding="4" width="100%">
                                            <tr>
                                                <td>
                                                    Descripcion: ${moneda.descripcion}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Año: ${moneda.año}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Precio: ${moneda.precio}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Pais: ${moneda.pais}
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <div align="left" style="padding-top: 5px;">
                                <input type="checkbox" name="seleccion" value="${moneda.id}"/>Selecionar
                            </div>
                        </div>
                        <hr/>
                    </c:forEach>
                    <input type="submit" value="Añadir a Cesta"/>
                </form>
            </div>
        </div>
    </body>
</html>
