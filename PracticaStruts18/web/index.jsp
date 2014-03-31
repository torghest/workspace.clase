
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos</title>
    </head>
    <body>
        <div align="center">
            <div style="border: 2px solid; background-color: #EEFF99; display: inline-table; padding: 10px;">
                <font size="6" color="#DD55AA">
                <b>Equipos de Primera Division</b>
                </font>
                <table border="1">
                    <bean:define id="i" value="-1"/>
                    <logic:iterate name="equipos" id="equipo">
                        <logic:lessEqual name="i" value="0">
                            <logic:notEqual name="i" value="-1">
                                </tr>
                            </logic:notEqual>
                            <tr>
                            <bean:define id="i" value="3"/>
                        </logic:lessEqual>
                        <td>
                            <table width="100%">
                                <tr>
                                    <td bgcolor="#FFFFFF" width="55" align="center" style="border: 1px solid;" onClick="location.href='Liga.do?method=plantilla&equipo_cod=${equipo.equipo_cod}'">
                                        <img src="Imagenes/<bean:write name="equipo" property="foto_escudo"/>"/>
                                    </td>
                                    <td>
                                        <table width="100%">
                                            <tr>
                                                <td style="border: 1px solid; background-color: #CCCCCC; padding: 0px 6px;">
                                                    <b>Nombre:</b> <bean:write name="equipo" property="nombre"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid; background-color: #CCCCCC; padding: 0px 6px;">
                                                    <b>Año de Fundación:</b> <bean:write name="equipo" property="fundacion"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid; background-color: #CCCCCC; padding: 0px 6px;">
                                                    <b>Presidente:</b> <bean:write name="equipo" property="presidente"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <bean:define id="i" value="${i-1}"/>
                    </logic:iterate>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
