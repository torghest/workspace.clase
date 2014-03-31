<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link REL="stylesheet" href="newcss.css" type="text/css"/> 
    </head>
    <body>
        <h3>¿Quien es último campeón del Mundo?</h3>
        <html:form action="/Mundial">
            <table border="1">
                <tr>
                    <th>Pais</th>
                    <td>
                        <html:select property="pais"> 
                            <html:options collection="tablapaises" property="key" labelProperty="value"/>
                        </html:select> 
                    </td>
                </tr> 
                <tr>
                    <th>Observaciones</th>
                    <td> 
                        <html:textarea property="observaciones" cols="50" rows="3" />
                    </td>
                </tr> 
                <tr>
                    <td colspan="2">
                        <html:submit value="Enviar"/>
                    </td> 
                </tr>
            </table>
        </html:form>
        </center>
    </body>
</html>
