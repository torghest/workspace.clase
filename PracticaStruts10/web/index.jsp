<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="index.titulo"/></title>
        <link rel="stylesheet" type="text/css" href="newcss.css"/>   
    </head>
    <body>
        <html:form action="IncrementoSalarial">
            <table border="1" align="center" bgcolor="#AACCFF">
                <tr>
                    <th colspan="2"><bean:message key="index.tituloTabla"/></th>
                </tr>
                <tr>
                    <td align="right">
                        <bean:message key="index.label.apellido"/>
                    </td>
                    <td align="left">
                        <html:text property="apellido" style="background-color: #DDDDFF;"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <bean:message key="index.label.incremento"/>
                    </td>
                    <td align="left">
                        <html:text property="incremento" style="background-color: #DDDDFF;"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <html:submit style="background-color: #DDDDFF;">
                            <bean:message key="index.label.submit"/>
                        </html:submit>
                    </td>
                </tr>
                <logic:present name="resultado">
                    <tr>
                        <td colspan="2">
                            <bean:message key="index.resultado.${resultado}1"/>
                            <bean:write name="apellido"/>
                            <bean:message key="index.resultado.${resultado}2"/>
                            <logic:present name="dato">
                                <bean:write name="dato"/>
                                <bean:message key="index.resultado.divisa"/>
                            </logic:present>
                        </td>
                    </tr>
                </logic:present>
            </table>
        </html:form>
    </body>
</html>