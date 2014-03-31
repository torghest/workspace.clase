<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="index.titulo" /></title>
    </head>
    <body>
        <div align="center">
            <div style="position: relative; border: 2px solid; height: 500px; width: 700px; background-color: #AADDFF;">
                
                <html:form action="Practica6">
                    
                    <div style="position: absolute; left: 200px; top: 50px; font-size: 24px; font-weight: bold;">
                        <bean:message key="literal.titulo" />
                    </div>
                    <div style="position: absolute; left: 270px; top: 80px; font-size: 10px;">
                        <bean:message key="literal.subtitulo" />
                    </div>

                    <div style="left: 50px; top: 120px; position: absolute;">
                        <bean:message key="literal.nombre" />*
                    </div>
                    <div style="left: 50px; top: 140px; position: absolute;">
                        <html:text property="nombre" size="40" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 54px; top: 165px; position: absolute;">
                        <html:errors property="nombre" />
                    </div>
                    
                    <div style="left: 350px; top: 120px; position: absolute;">
                        <bean:message key="literal.apellido" />*
                    </div>
                    <div style="left: 350px; top: 140px; position: absolute;">
                        <html:text property="apellido" size="40" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 354px; top: 165px; position: absolute;">
                        <html:errors property="apellido" />
                    </div>
                    
                    <div style="left: 50px; top: 200px; position: absolute;">
                        <bean:message key="literal.email" />*
                    </div>
                    <div style="left: 50px; top: 220px; position: absolute;">
                        <html:text property="email" size="40" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 54px; top: 245px; position: absolute;">
                        <html:errors property="email" />
                    </div>
                    
                    <div style="left: 350px; top: 200px; position: absolute;">
                        <bean:message key="literal.codigoPostal" />*
                    </div>
                    <div style="left: 350px; top: 220px; position: absolute;">
                        <html:text property="codigoPostal" size="5" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 354px; top: 245px; position: absolute;">
                        <html:errors property="codigoPostal" />
                    </div>
                    
                    <div style="left: 50px; top: 280px; position: absolute;">
                        <bean:message key="literal.login" />*
                    </div>
                    <div style="left: 50px; top: 300px; position: absolute;">
                        <html:text property="login" size="40" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 54px; top: 325px; position: absolute;">
                        <html:errors property="login" />
                    </div>
                    
                    <div style="left: 50px; top: 360px; position: absolute;">
                        <bean:message key="literal.password" />*
                    </div>
                    <div style="left: 50px; top: 380px; position: absolute;">
                        <html:password property="password1" size="40" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 54px; top: 405px; position: absolute;">
                        <html:errors property="password1" />
                    </div>
                    
                    <div style="left: 350px; top: 360px; position: absolute;">
                        <bean:message key="literal.confirmarPassword" />*
                    </div>
                    <div style="left: 350px; top: 380px; position: absolute;">
                        <html:password property="password2" size="40" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 354px; top: 405px; position: absolute;">
                        <html:errors property="password2" />
                    </div>
                    
                    <div style="right: 360px; bottom: 20px; position: absolute;">
                        <html:reset>
                            <bean:message key="literal.reset" />
                        </html:reset>
                    </div>
                    <div style="left: 360px; bottom: 20px; position: absolute;">
                        <html:submit>
                            <bean:message key="literal.submit" />
                        </html:submit>
                    </div>
                    
                </html:form>
                
            </div>
        </div>
    </body>
</html>