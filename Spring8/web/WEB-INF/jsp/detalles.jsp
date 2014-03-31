<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle ${pelicula.nombre}</title>   
    </head>
    <body>
        <div align="center">
            <div>
                <h1>
                    Detalle ${pelicula.nombre}
                </h1>
            </div>
            <div style="border: 2px solid; background-color: #AACCFF; width: 846px; height: 509px; padding-top: 0px;">
                <div style="position: relative; display: inline-block; border: 1px solid; background-color: #DDEEFF; width: 766px; height: 428px; margin: 20px; padding: 20px">
                    <table border="0" width="100%">
                        <tr>
                            <td align="left">
                                <img src="${pelicula.foto}" height="420"/>
                            </td>
                            <td align="left">
                                <div style="position: absolute; top: 25px; left: 330px; font-size: 25px; line-height: 2em">
                                    <b>Titulo:</b>&nbsp;
                                    ${pelicula.nombre}
                                    <br/>
                                    <b>Formato:</b>&nbsp;
                                    ${pelicula.tipoPeli}
                                    <br/>
                                    <b>Precio:</b>&nbsp;
                                    ${pelicula.precio}&nbsp;€
                                    <br/>
                                    <b>Comentario:</b><br/>
                                    ${pelicula.observaciones}
                                </div>
                                <div style="position: absolute; bottom: 25px; right: 60px; font-size: 20px;">
                                    <form name="form" action="index.htm" method="post">
                                        <input type="hidden" name="option" value="inicio">
                                    </form>
                                    <a href="javascript:" onclick="form.submit();">Volver</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
