<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>


${message}

<table border="1">


    <c:forEach var="Filas" items="${empleados}">
        <tr>
            <td><c:out value='${Filas.apellido}'/></a></td>
            <td><c:out value='${Filas.oficio}'/></td>
            <td><c:out value='${Filas.salario}'/></td>
        </tr>
    </c:forEach>
</table>
