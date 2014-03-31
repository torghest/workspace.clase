<%@page contentType="text/html"%>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html>
    <head>
        <title>
            <tiles:getAsString name="titulo" />
        </title>
    </head>
    <body>
        <div align="center">
            <div style="position: relative; border: 2px solid; display: inline-block">
                <div style="float: left; padding-right: 10px; margin-left: -24px; margin-right: 0px; padding-right: 0px;">
                    <!--menu-->
                    <tiles:insert attribute="menu"/>
                </div>
                <div style="margin-top: 16px; margin-right: 16px; border: 3px solid #DDAAAA; float: left; background-color: #FFDDDD; width: 650px; height: 400px; overflow: auto; padding: 10px;">
                    <!--cuerpo-->
                    <tiles:insert attribute="cuerpo"/>
                </div>
                <div style="float: bottom; margin-bottom: 16px;">
                    <img src="imagenes/LogoRibera.jpg" />
                    <br/>
                    <span style="font-style: italic">Nuestros Vinos. Conoce sus caracteristicas</span>
                </div>
            </div>
        </div>
    </body>
</html>  
