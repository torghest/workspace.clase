<%-- 
    Document   : Ejemplo3
    Created on : 07-mar-2014, 9:45:50
    Author     : alumno
--%>

<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts.Globals, java.util.Locale"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="newcss.css"/>    
    </head>
    <body>
        
<%
    Locale locale = null;
    String strIdioma = request.getParameter("idioma");
    if (strIdioma != null) 
    {
        if (strIdioma.equals("en")) 
        {
            System.out.println("equals en");
            locale = new Locale("en");
            session.setAttribute(Globals.LOCALE_KEY, locale);
        } else if (strIdioma.equals("es")) 
        {
            System.out.println("equals es");
            locale = new Locale("es");
            session.setAttribute(Globals.LOCALE_KEY, locale);
        }
    }%>
        
        <table>
            <tr>
                <td>
                    <img src="imagenes/icono_spanish.jpg" width="30" height="30"/>    
                </td>
                <td>
                    <html:link href="Ejemplo3.jsp?idioma=es">
                        <bean:message key="literal.cambiarIdioma.español" />
                    </html:link>                
                </td>
            </tr>
            <tr>
                <td>
                    <img src="imagenes/icono_english.jpg" width="30" height="30"/>    
                </td>
                <td>
                    <html:link href="Ejemplo3.jsp?idioma=en">
                        <bean:message key="literal.cambiarIdioma.ingles" />
                    </html:link>                
                </td>
            </tr>
            <tr>
                <td>
                    <img src="imagenes/usuario.jpg" width="30" height="30"/>    
                </td>
                <td>
                    <html:link action="Ejemplo3.jsp">
                        <bean:message key="literal.registroUsuario" />
                    </html:link>            
                </td>
            </tr>        
        </table>
    </body>
</html>
