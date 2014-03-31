<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="index.catalogo.titulo"/></title>
        <link rel="stylesheet" type="text/css" href="newcss.css"/>   
    </head>
    <body>
        <div align="center">
            <logic:present name="peliculas">
                <div>
                    <h1>
                        Catalogo de Peliculas
                    </h1>
                </div>
                <div style="border: 2px solid; background-color: #AACCFF; overflow-y: scroll; width: 846px; height: 504px; padding-top: 5px;">
                    <logic:iterate name="peliculas" id="pelicula">
                        <div style="position: relative; display: inline-block; border: 1px solid; background-color: #DDEEFF; width: 250px; height: 140px; margin: 5px; padding: 5px">
                            <table border="0" width="100%">
                                <tr>
                                    <td>
                                        <img src="<bean:write name="pelicula" property="foto"/>" height="134"/>
                                    </td>
                                    <td>
                                        <div style="position: absolute; top: 10px; left: 120px;">
                                            <b><bean:message key="pelicula.nombre"/>:</b><br/>
                                            <bean:write name="pelicula" property="nombre"/>
                                            <br/>
                                            <b><bean:message key="pelicula.tipoPeli"/>:</b>&nbsp;
                                            <bean:write name="pelicula" property="tipoPeli"/>
                                            <br/>
                                            <b><bean:message key="pelicula.precio"/>:</b>&nbsp;
                                            <bean:write name="pelicula" property="precio"/>&nbsp;
                                            <bean:message key="pelicula.divisa"/>
                                        </div>
                                        <div style="position: absolute; bottom: 10px; left: 120px;">
                                            <html:link page="/TiendaPeliculas.do?f=verMas" paramName="pelicula" paramProperty="id" paramId="pid">Ver mas</html:link>
                                            &nbsp;&nbsp;
                                            <html:link href="/TiendaPeliculas.do?f=comprar" paramName="pelicula" paramProperty="id" paramId="pid">Comprar</html:link>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </logic:iterate>
                </div>
            </logic:present>
        </div>
    </body>
</html>