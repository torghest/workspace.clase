<%-- 
    Document   : TiendaStruts
    Created on : 07-mar-2014, 8:46:46
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>

<html>
<body>
 <form>
  <div style="left: 210px; top: 10px; font-size: 24px;
       font-weight: bold; position: absolute">
   <bean:message key="literal.bienvenida" />
  </div>
  <div style="left: 250px; top: 40px; font-size: 12px; position: absolute">
   <bean:message key="literal.mensajeEnvios" />
  </div> 
 <form>
</body>
</html>

