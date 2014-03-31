<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%-- Librerias Struts --%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
        
        <html:form action="Tienda">
            
            <div style="left: 210px; top: 10px; font-size: 24px;
                font-weight: bold; position: absolute">
                <bean:message key="literal.bienvenida" />
            </div>
            <div style="left: 250px; top: 40px; font-size: 10px; position: absolute">
                *<bean:message key="literal.mensajeEnvios" />
            </div>
            
            <div style="left: 28px; top: 80px; position: absolute;">
                <bean:message key="literal.nombre" />*
            </div>
            <div style="left: 28px; top: 100px; position: absolute;">
                <html:text property="nombre" size="40" />
            </div> 
            <div style="left: 32px; top: 125px; position: absolute;">
                <html:errors property="nombre" />
            </div>

            <div style="left: 320px; top: 80px; position: absolute">
                <bean:message key="literal.apellido" />*
            </div>
            <div style="left: 320px; top: 100px; position: absolute">
                <html:text property="apellido" size="40" />
            </div>
            <div style="left: 324px; top: 125px; position: absolute">
                <html:errors property="apellido" />
            </div>

            <div style="left: 230px; top: 440px; position: absolute">
                <html:reset>
                    <bean:message key="literal.restaurar" />
                </html:reset>
            </div>
            <div style="left: 320px; top: 440px; position: absolute">
                <html:submit>
                    <bean:message key="literal.enviar" />
                </html:submit>
            </div>
            
        </html:form>
    </body>
</html>