<%-- 
    Document   : formulario
    Created on : 07-mar-2014, 11:24:38
    Author     : alumno
--%>

<%@page import="org.apache.struts.Globals"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html>
<%
    Locale locale = null;
    String strIdioma = request.getParameter("lg");
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
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="index.titulo"/></title>
    </head>
    <body>
        <div align="center">
            <form name="form" action="" method="post">
                <fieldset align="center" style="border: 2px solid; display: inline-block; background-color: #EEEEFF; padding: 20px">
                    <legend align="left" style="border: 1px solid; background-color: #CC99FF;">
                        &nbsp;
                        <b><bean:message key="form.titulo"/></b>
                        &nbsp;►&nbsp;
                        <img src="<bean:message key="form.bandera"/>"/>
                        &nbsp;
                    </legend>
                    <table>
                        <tr>
                            <td align="left">
                                <bean:message key="form.nombre"/>
                            </td>
                            <td>
                                <input type="text" name="nombre" style="background-color: #EEFFEE"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <bean:message key="form.apellido1"/>
                            </td>
                            <td>
                                <input type="text" name="apellido1" style="background-color: #EEFFEE"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <bean:message key="form.apellido2"/>
                            </td>
                            <td>
                                <input type="text" name="apellido2" style="background-color: #EEFFEE"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <bean:message key="form.telefono"/>
                            </td>
                            <td>
                                <input type="text" name="telefono" style="background-color: #EEFFEE"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <bean:message key="form.email"/>
                            </td>
                            <td>
                                <input type="text" name="email" style="background-color: #EEFFEE"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <bean:message key="form.valEmail"/>
                            </td>
                            <td>
                                <input type="text" name="valEmail" style="background-color: #EEFFEE"/>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <fieldset align="center" style="background-color: #EEFFEE;">
                        <legend align="left" style="background-color: #BBFFBB; border: 2px solid #999999;"><b><bean:message key="form.esSocio"/></b></legend>
                        <div style="margin-left: -20px">
                            <input type="radio" name="esSocio" value="true"/>
                            <bean:message key="form.si"/>
                            <input type="radio" name="esSocio" value="false"/>
                            <bean:message key="form.no"/>
                        </div>
                    </fieldset>
                    <br/>
                    <fieldset align="center" style="background-color: #EEFFEE">
                        <legend align="left" style="background-color: #BBFFBB; border: 2px solid #999999;"><b><bean:message key="form.esMenor"/></b></legend>
                        <div style="margin-left: -20px">
                            <input type="radio" name="esMenor" value="true"/>
                            <bean:message key="form.si"/>
                            <input type="radio" name="esMenor" value="false"/>
                            <bean:message key="form.no"/>
                        </div>
                    </fieldset>
                    <br/>
                    <fieldset align="center" style="background-color: #EEFFEE">
                        <legend align="left" style="background-color: #BBFFBB; border: 2px solid #999999;"><b><bean:message key="form.esExtranjero"/></b></legend>
                        <div style="margin-left: -20px">
                            <input type="radio" name="esesExtranjero" value="true"/>
                            <bean:message key="form.si"/>
                            <input type="radio" name="esesExtranjero" value="false"/>
                            <bean:message key="form.no"/>
                        </div>
                    </fieldset>
                    <br/>
                    <input type="submit" value="<bean:message key="form.aceptar"/>" style="background-color: #BBFFBB;"/>
                </fieldset>
            </form>
        </div>
    </body>
</html>
