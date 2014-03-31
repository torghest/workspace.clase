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
        <html:form action="Empleados">
            <table border="1" align="center" bgcolor="#AACCFF">
                <tr>
                    <th><bean:message key="index.tituloTabla"/></th>
                    <td align="right">
                        <html:select property="oficio" onchange="form.submit();" style="background-color: #DDEEFF">
                            <html:options collection="oficios" property="key" labelProperty="value"/>
                        </html:select>
                    </td>
                </tr>
                <logic:present name="datos">
                    <tr>
                        <td colspan="2">
                            ${datos}
                        </td>
                    </tr>
                </logic:present>
            </table>
        </html:form>
    </body>
</html>