<%-- 
    Document   : pedido
    Created on : 10-mar-2014, 9:30:20
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>
<sql:setDataSource driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="system" password="javaoracle"/>

<%-- Validar datos --%>
<c:if test="${param.procesar == 1}">
    <c:if test="${param.cliente == ''}">
        <c:set var="error" value="1"/>
    </c:if>
    <c:forEach items="${paramValues.seleccion}" var="sel">
        <c:if test="${param[sel] == '' || param[sel] > 9}">
            <c:set var="error" value="1"/>
        </c:if>
    </c:forEach>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        <div align="center">
            <div style="border: 2px solid; display: inline-block; padding: 5px;">
                <c:if test="${param.procesar == null || error == 1}">
                    <c:if test="${paramValues.seleccion != null}">
                        <c:set var="checked">
                            <c:forEach items="${paramValues.seleccion}" var="monedas" varStatus="i">
                                <c:if test="${!i.first}">
                                    ,
                                </c:if>
                                ${monedas}
                            </c:forEach>
                        </c:set>
                        <sql:query var="datosMoneda">
                            SELECT
                                id,
                                descripcion,
                                pais,
                                año,
                                precio
                            FROM
                                monedas
                            WHERE
                                id in (${checked})
                            ORDER BY
                                id
                        </sql:query>
                    </c:if>
                    <form name="formPedido" action="pedido.jsp" method="get">
                        <input type="hidden" name="procesar" value="1"/>
                        <table align="center">
                            <tr>
                                <td>
                                    <input type="submit" value="Realizar Pedido"/>
                                </td>
                                <td align="right">
                                    Codigo Cliente:
                                </td>
                                <td align="left">
                                    <input type="text" name="cliente" size="8" value="${param.cliente}"/>
                                    <c:if test="${param.cliente == ''}">
                                        <br>
                                        <font size="1" color="#FF0000">
                                        Debe introducir Codigo de Cliente
                                        </font>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <table border="1" align="right">
                                        <tr>
                                            <td bgcolor="#333333">
                                                <font color="#DDDDDD">ID</font>
                                            </td>
                                            <td bgcolor="#333333">
                                                <font color="#DDDDDD">DESCRIPCIÓN</font>
                                            </td>
                                            <td bgcolor="#333333">
                                                <font color="#DDDDDD">PAIS</font>
                                            </td>
                                            <td bgcolor="#333333">
                                                <font color="#DDDDDD">AÑO</font>
                                            </td>
                                            <td bgcolor="#333333">
                                                <font color="#DDDDDD">PRECIO</font>
                                            </td>
                                            <td bgcolor="#333333">
                                                <font color="#DDDDDD">UNIDADES</font>
                                            </td>
                                        </tr>
                                        <c:forEach items="${datosMoneda.rows}" var="moneda">
                                            <tr>
                                                <td>
                                                    <input type="checkbox" name="seleccion" value="${moneda.id}" hidden="true" checked/>
                                                    ${moneda.id}
                                                </td>
                                                <td>
                                                    ${moneda.descripcion}
                                                </td>
                                                <td>
                                                    ${moneda.pais}
                                                </td>
                                                <td>
                                                    ${moneda.año}
                                                </td>
                                                <td>
                                                    ${moneda.precio}
                                                </td>
                                                <td>
                                                    <input type="text" name="${moneda.id}" size="10"/>
                                                    <c:if test="${error == 1}">
                                                        <c:forEach items="${paramValues.seleccion}" var="sel">
                                                            <c:if test="${sel == moneda.id}">
                                                                <c:if test="${param[sel] == ''}">
                                                                    <br>
                                                                    <font size="1" color="#FF0000">
                                                                    Debe introducir el numero unidades
                                                                    </font>
                                                                </c:if>
                                                                <c:if test="${param[sel] > 9}">
                                                                    <br>
                                                                    <font size="1" color="#FF0000">
                                                                    No puede superar 9 unidades
                                                                    </font>
                                                                </c:if>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:if>
                <c:if test="${param.procesar == 1 && error == null}">
                    <c:forEach items="${paramValues.seleccion}" var="sel">
                        Pedidas ${param[sel]} Unidades de (ID=${sel})
                        <br/>
                        <sql:update>
                            INSERT INTO pedidos VALUES (${sel},${param.cliente},${param[sel]})
                        </sql:update>
                    </c:forEach>
                    <h2>Pedido Realizado</h2>
                    <br/>
                    <a href="index.jsp">Volver</a>
                </c:if>
            </div>
        </div>
    </body>
</html>
