<%-- 
    Document   : index
    Created on : 06-mar-2014, 9:24:52
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="Tags" prefix="Scb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversion de Divisas</title>
    </head>
    <body>
        <div align="center">
            <div style="border: 2px solid; display: inline-block; background: #FFFF99; padding: 10px;">
                <table>
                    <tr>
                        <td colspan="2">
                            <font size="6" color="#9999FF">
                            Conversor de Euros
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                    <form name="form" action="index.jsp" method="post">
                    <tr>
                        <td>
                            Divisa:
                            <br/>
                            <select name="divisa">
                                <option value="0"${(param.divisa==0)?" SELECTED":""}>Dolares(&dollar;)</option>
                                <option value="1"${(param.divisa==1)?" SELECTED":""}>Pesos(&phi;)</option>
                                <option value="2"${(param.divisa==2)?" SELECTED":""}>Rupias(&realpart;)</option>
                                <option value="3"${(param.divisa==3)?" SELECTED":""}>Yenes(&yen;)</option>
                                <option value="4"${(param.divisa==4)?" SELECTED":""}>Pesetas(Pts.)</option>
                            </select>
                        </td>
                        <td>
                            <input type="radio" name="tConversion" value="aDivisa"${(param.tConversion=='aDivisa')?" CHECKED":""}/>
                            Euro-Divisa
                            <br/>
                            <input type="radio" name="tConversion" value="aEuro"${(param.tConversion=='aEuro')?" CHECKED":""}/>
                            Divisa-Euro
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Cantidad:
                            <br/>
                            <input type="text" name="cantidad" value="${(param.cantidad!=null)?param.cantidad:""}"/>
                        </td>
                        <td align="right">
                            <input type="submit" value="Convertir"/>
                        </td>
                    </tr>
                    </form>
                    <c:if test="${param.divisa!=null}">
                        <tr>
                            <td colspan="2">
                                <hr/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <div style="display: inline-block; border: 2px blueviolet dotted; padding: 5px;">
                                    <b>
                                        <c:if test="${param.tConversion=='aEuro'}">Conversión de <Scb:tipoDivisa indice="${param.divisa}"/> a Euros:</c:if>
                                        <c:if test="${param.tConversion=='aDivisa'}">Conversión de Euros a <Scb:tipoDivisa indice="${param.divisa}"/>:</c:if>
                                    </b>
                                    <br/>
                                    <c:if test="${param.tConversion=='aEuro'}">
                                        <c:set var="conversion">
                                            <Scb:conversionAeuro indice="${param.divisa}" valor="${param.cantidad}"/>
                                        </c:set>
                                    </c:if><c:if test="${param.tConversion=='aDivisa'}">
                                        <c:set var="conversion">
                                            <Scb:conversionAdivisa indice="${param.divisa}" valor="${param.cantidad}"/>
                                        </c:set>
                                    </c:if>
                                    <input type="text" value="${conversion}" disabled="true" size="10" style="text-align: right"/>
                                    <c:if test="${param.tConversion=='aEuro'}">Euros</c:if>
                                    <c:if test="${param.tConversion=='aDivisa'}"><Scb:tipoDivisa indice="${param.divisa}"/></c:if>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                </table>
            </div>
        </div>
    </body>
</html>
