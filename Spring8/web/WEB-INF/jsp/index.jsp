<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo de Peliculas</title>  
    </head>
    <body>
        <div align="center">
            <div>
                <h1>
                    Catalogo de Peliculas
                </h1>
            </div>
            <div style="border: 2px solid; background-color: #AACCFF; overflow-y: scroll; width: 846px; height: 504px; padding-top: 5px;">
                <jstl:forEach items="${peliculas}" var="pelicula">
                    <div style="position: relative; display: inline-block; border: 1px solid; background-color: #DDEEFF; width: 250px; height: 140px; margin: 5px; padding: 5px">
                        <table border="0" width="100%">
                            <tr>
                                <td align="left">
                                    <img src="${pelicula.foto}" height="134"/>
                                </td>
                                <td align="left">
                                    <div style="position: absolute; top: 10px; left: 120px;">
                                        <b>Titulo:</b><br/>
                                        ${pelicula.nombre}
                                        <br/>
                                        <b>Formato:</b>&nbsp;
                                        ${pelicula.tipoPeli}
                                        <br/>
                                        <b>Precio:</b>&nbsp;
                                        ${pelicula.precio}&nbsp;€
                                    </div>
                                    <div style="position: absolute; bottom: 10px; left: 120px;">
                                        <a href="javascript:" onclick="form.option.value='verMas';form.pid.value='${pelicula.id}';form.submit();">Ver mas</a>
                                        &nbsp;&nbsp;
                                        <a href="javascript:" onclick="form.option.value='comprar';form.pid.value='${pelicula.id}';form.submit();">Comprar</a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </jstl:forEach>
            </div>
        </div>
        <form name="form" action="index.htm" method="post">
            <input type="hidden" name="option"/>
            <input type="hidden" name="pid"/>
        </form>
    </body>
</html>