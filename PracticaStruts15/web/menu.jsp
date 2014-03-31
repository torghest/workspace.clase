<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<bean:define id="colorBase" value="#DDDDFF" />
<bean:define id="colorSel" value="#DDAAAA" />
<ul align="left" style="list-style: none; cursor: default">
    <li style="background-color: ${(param.m==null)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=null)?" onclick=\"location.href='index.jsp'\"":""}>Inicio</li>
    <li style="background-color: ${(param.m==1)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=1)?" onclick=\"location.href='index.jsp?m=1'\"":""}>Protos</li>
    <li style="background-color: ${(param.m==2)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=2)?" onclick=\"location.href='index.jsp?m=2'\"":""}>Vega Sicilia</li>
    <li style="background-color: ${(param.m==3)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=3)?" onclick=\"location.href='index.jsp?m=3'\"":""}>Arzuaga</li>
    <li style="background-color: ${(param.m==4)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=4)?" onclick=\"location.href='index.jsp?m=4'\"":""}>PradoRey</li>
    <li style="background-color: ${(param.m==5)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=5)?" onclick=\"location.href='index.jsp?m=5'\"":""}>Palacio de Grajal</li>
    <li style="background-color: ${(param.m==6)?colorSel:colorBase}; padding: 0px 5px"${(param.m!=6)?" onclick=\"location.href='index.jsp?m=6'\"":""}>Señorio de Nava</li>
</ul>
