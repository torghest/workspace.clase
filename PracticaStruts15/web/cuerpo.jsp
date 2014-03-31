
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<logic:notPresent parameter="m">
    <h1>
        Bienvenido a la Vinoteca de la Ribera del Duero
    </h1>
    <p align="justify">
        Como Consejo Regulador de la D.O. Ribera del Duero, nuestra función principal
        es avalar con nuestro sello la autenticidad de los vinos de esta Denominación
        de Origen, asegurando al consumidor que cada botella que lleva una contraetiqueta
        numerada ha superado rigurosos controles antes de llegar a sus copas.
    </p>
    <p align="justify">
        Ésta es la fase final de las tareas de control de calidad que realizamos y
        que comienza vigilando la producción máxima reglamentaria permitida en nuestra
        zona: 7.000 kgs. de uva por hectárea, continúa en la elaboración de los vinos,
        asegurando el uso correcto de las variedades de uva autorizadas y que los caldos
        superen un proceso de calificación antes de llegar al mercado con el sello de
        nuestra D.O. Además, desarrollamos una intensa actividad promocional genérica
        y colaboramos e investigamos con entidades públicas y privadas para la mejora
        cualitativa de las viñas y vinos de la D.O. Ribera del Duero.
    </p>
    <img src="imagenes/Vino.jpg" width="220px" style="border: 1px solid;"/>
    <p align="justify">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
    </p>
    <p align="justify">
        Curabitur pretium tincidunt lacus. Nulla gravida orci a odio. Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris. Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam. Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo eget, consequat quis, neque. Aliquam faucibus, elit ut dictum aliquet, felis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras mollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue lorem, dapibus quis, laoreet et, pretium ac, nisi. Aenean magna nisl, mollis quis, molestie eu, feugiat in, orci. In hac habitasse platea dictumst.
    </p>
</logic:notPresent>
<logic:present parameter="m">
    <logic:equal parameter="m" value="1">
        <h1>Protos</h1>
        <img src="imagenes/Protos.jpg" width="220px" style="border: 1px solid;"/>
    </logic:equal>
    <logic:equal parameter="m" value="2">
        <h1>Vega Sicilia</h1>
        <img src="imagenes/VegaSicilia.jpg" width="220px" style="border: 1px solid;"/>
    </logic:equal>
    <logic:equal parameter="m" value="3">
        <h1>Arzuaga</h1>
        <img src="imagenes/Arzuaga.jpg" width="220px" style="border: 1px solid;"/>
    </logic:equal>
    <logic:equal parameter="m" value="4">
        <h1>PradoRey</h1>
        <img src="imagenes/PradoRey.jpg" width="220px" style="border: 1px solid;"/>
    </logic:equal>
    <logic:equal parameter="m" value="5">
        <h1>Palacio de Grajal</h1>
        <img src="imagenes/PalacioGrajal.jpg" width="220px" style="border: 1px solid;"/>
    </logic:equal>
    <logic:equal parameter="m" value="6">
        <h1>Señorio de Nava</h1>
        <img src="imagenes/SeñorioNava.jpg" width="220px" style="border: 1px solid;"/>
    </logic:equal>
</logic:present>
        
    
