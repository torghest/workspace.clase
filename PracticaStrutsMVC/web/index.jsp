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
            <div style="position: relative; border: 2px solid; height: 180px; width: 300px; background-color: #AADDFF;">
                
                <html:form action="BorradoDoctor">
                    
                    <div style="position: absolute; left: 40px; top: 20px; font-size: 24px; font-weight: bold;">
                        <bean:message key="literal.titulo" />
                    </div>
                    <div style="position: absolute; left: 55px; top: 40px; font-size: 10px;">
                        <bean:message key="literal.subtitulo" />
                    </div>

                    <div style="left: 50px; top: 80px; position: absolute;">
                        <bean:message key="literal.campo" />*
                    </div>
                    <div style="left: 170px; top: 80px; position: absolute;">
                        <html:text property="doctor_no" size="5" style="background-color: #CCEEFF;" />
                    </div> 
                    <div style="left: 170px; top: 105px; position: absolute; padding-right: 10px; text-align: left;">
                        <html:errors property="doctor_no" />
                        <logic:present name="noExisteDoctorNo">
                            <bean:message key="errors.prefix"/>
                            <bean:message key="resultado.noExist"/>
                            <bean:message key="errors.suffix"/>
                        </logic:present>
                    </div>
                    
                    <div style="right: 160px; bottom: 20px; position: absolute;">
                        <html:reset>
                            <bean:message key="literal.reset" />
                        </html:reset>
                    </div>
                    <div style="left: 160px; bottom: 20px; position: absolute;">
                        <html:submit>
                            <bean:message key="literal.submit" />
                        </html:submit>
                    </div>
                    
                </html:form>
                
            </div>
        </div>
    </body>
</html>