<%@page import="clases.Datosempleados"%>
<%@page import="clases.DatosempleadosId"%>
<%@page import="java.util.List"%>
<%@page import="clases.DatosEmpleadosHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilotabla.css"/>
    </head>
    <body>
        <h3>Vistas desde Hibernate</h3>
        <%
            DatosEmpleadosHelper helper = new DatosEmpleadosHelper();
            List<Datosempleados> listaemp = helper.getDatosEmpleados();%>
            <table border="1">
                <tr>
                    <th>APELLIDO</th>
                    <th>SALARIO ANUAL</th>
                    <th>SALARIO</th>
                    <th>OFICIO</th>
                    <th>FECHA DE ALTA</th>
                    <th>DEPARTAMENTO</th>
                </tr>
            <%for (Datosempleados d:listaemp)
            {
                DatosempleadosId datoemp = d.getId();
                %>
                <tr>
                    <td><%=datoemp.getApellido()%></td>
                    <td><%=datoemp.getSalarioanual()%></td>
                    <td><%=datoemp.getSalario()%></td>
                    <td><%=datoemp.getOficio()%></td>
                    <td><%=datoemp.getFechaalta()%></td>
                    <td><%=datoemp.getDepartamento()%></td>
                </tr> 
          <%}
        %>
            </table>
    </body>
</html>
