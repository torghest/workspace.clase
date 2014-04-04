<%@page import="jdbc.AccesoJDBC"%>
<%@page import="Util.properties"%>
<%@page import="Util.Navegacion"%>
<%
    AccesoJDBC jdbc = new AccesoJDBC();
    String[] optMenu = jdbc.getMenu();
    String colorBase = properties.FONDO_MENU2;
    String colorSel = properties.FONDO_MENU1;
    String aux = request.getParameter("opt");
    String sel = (aux==null)?"1":aux;
    String[] varForm = {"opt"};
    Navegacion nav = new Navegacion("menu",varForm);
%>
    <ul align="left" style="list-style: none; cursor: default">
<%
        for (String s : optMenu){
            String[] spl = s.split(AccesoJDBC.separador2);
            String[] val = {String.valueOf(spl[1])};
            nav.setVal(val);
%>
<li style="background-color: <%=(sel.equals(spl[1]))?colorSel:colorBase%>; padding: 0px 5px;"<%=(!sel.equals(spl[1]))?nav.onClick():""%>><%=spl[0]%></li>
<%
        }
%>
    </ul>
    <%=nav.form()%>