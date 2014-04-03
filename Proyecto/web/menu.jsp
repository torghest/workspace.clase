<%
    String[] optMenu = {"Inicio","opcion1","opcion2","opcion3"};
    String colorBase = "#0066AA";
    String colorSel = "#6699DD";
    String aux = request.getParameter("opt");
    int sel = (aux==null)?0:Integer.valueOf(aux);
%>
    <ul align="left" style="list-style: none; cursor: default">
        <%
        for (int i = 0; i < optMenu.length; i++){
        %>
            <li style="background-color: <%=(sel==i)?colorSel:colorBase%>; padding: 0px 5px"<%=(sel!=i)?" onclick=\"javascript:menu.opt.value="+i+";menu.submit();\"":""%>><%=optMenu[i]%></li>
        <%
        }
        %>
    </ul>
    <form name="menu" action="index.jsp" method="post">
        <input type="hidden" name="opt">
    </form>