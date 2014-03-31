<%@page import="pojos.Emp"%>
<%@page import="java.util.List"%>
<%@page import="pojos.EmpHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilotabla.css"/>
    </head>
    <body>
        <%String pagina = (request.getParameter("pag")==null)?"1":request.getParameter("pag");%>
        <h3>Tabla Empleados (Pagina <%=pagina%>)</h3>
        <%
            EmpHelper helper = new EmpHelper();
    List<Emp> listaemp = helper.getDatosEmpleados(Integer.valueOf(pagina));%>
            <table border="1">
                <tr>
                    <th>APELLIDO</th>
                    <th>SALARIO ANUAL</th>
                    <th>SALARIO</th>
                    <th>OFICIO</th>
                    <th>FECHA DE ALTA</th>
                    <th>DEPARTAMENTO</th>
                </tr>
            <%for (Emp d:listaemp)
            {
                %>
                <tr>
                    <td><%=d.getApellido()%></td>
                    <td><%=d.getSalario()%></td>
                    <td><%=d.getSalario()%></td>
                    <td><%=d.getOficio()%></td>
                    <td><%=d.getFechaAlt()%></td>
                    <td><%=d.getDeptNo()%></td>
                </tr> 
          <%}
        %>
            <tr>
                <td colspan="6" align="center">
            <%
            for (int i = 1; i <= helper.getPaginas(); i++){
                if (Integer.valueOf(pagina)==i){
            %>
                    <%=i%>
            <%
                }else{
            %>
                    <a href="index.jsp?pag=<%=i%>"><%=i%></a>
            <%
                }
            }
            %>
                </td>
            </tr>
            </table>
    </body>
</html>
