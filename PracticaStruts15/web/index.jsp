<%@page contentType="text/html"%>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/Plantilla.jsp" flush="true" >
	<tiles:put name="titulo" value="Ribera del Duero"/>
        <tiles:put name="menu" value="/menu.jsp"/>
        <tiles:put name="cuerpo" value="/cuerpo.jsp"/>
</tiles:insert>
