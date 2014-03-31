<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="newcss.css"/>
    </head>
    <body>
        <form name="form1">
            <table border="1">
                <tr>
                    <th>Id Empleado</th>
                    <td>
                        <input type="text" name="txtemp"/>
                    </td>
                </tr>
                <tr>
                    <th>Incremento salarial</th>
                    <td>
                        <input type="text" name="txtincremento"/>
                    </td>
                </tr>                
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Incrementar salario"/>
                    </td>
                </tr>
            </table>
            <hr>
        <%
            String empleado = request.getParameter("txtemp");
            EmpleadosHelper helper = new EmpleadosHelper();
            int empno = 0;
            if (empleado != null)
            {
                empno = Integer.parseInt(empleado);
                int incremento = Integer.parseInt(request.getParameter("txtincremento"));
                helper.incrementarSalarioEmpleado(empno,incremento);
            }
            
            List<Emp> empleados =(List<Emp>) helper.getEmpleados();
            out.print("<table border='1'>");
            out.print("<tr><th>Apellido</th><th>OFICIO</th><th>SALARIO</th></tr>");
            for (int i = 0; i < empleados.size(); i++) {
                Emp e = (Emp) empleados.get(i);
                String apellido = e.getApellido();
                String oficio = e.getOficio();
                int salario = e.getSalario().intValue();
                int idemp =(int)e.getEmpNo();
                if (idemp == empno)
                {
                    out.print("<tr style='background-color:chartreuse'>");
                }else
                {
                    out.print("<tr>");
                }
                out.print("<td>" + apellido +"</td>");
                out.print("<td>" + oficio +"</td>");
                out.print("<td>" + salario +"</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        %>
        </form>
    </body>
</html>
