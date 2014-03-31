<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="resultado.titulo" /></title>
    </head>
    <body>
        <div align="center">
            <div style="position: relative; border: 2px solid; height: 180px; width: 300px; background-color: #AADDFF;">

                <div style="position: absolute; left: 40px; top: 20px; font-size: 24px; font-weight: bold;">
                    <bean:message key="resultado.titulo" />
                </div>
                
                <div style="top: 80px; position: absolute; padding: 0px 50px;">
                    <bean:message key="resultado.${resultado}" />
                </div>
                
                <div style="left: 130px; bottom: 15px; position: absolute;">
                    <html:link href="index.jsp" style="color: #333333;">
                        <bean:message key="resultado.volver"/>
                    </html:link>
                </div>
                
            </div>
        </div>
    </body>
</html>