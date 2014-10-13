<%-- 
    Document   : index
    Created on : 08/09/2014, 01:40:43 PM
    Author     : GooMoonRyong
--%>

<%@page import="pe.edu.bean.PartidoBean"%>
<%@page import="pe.edu.bean.CanchaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="cssbosti/bootstrap.min.css" rel="stylesheet">

        <link href="css/mine.css" rel="stylesheet">

        <%List partidos = (List) request.getAttribute("partidos");%>
        <%String usuario = (String) request.getAttribute("usuario");%>
        <%List l = new ArrayList(); %>
        <%
        for(int i=0; i<5; i++){
            CanchaBean a = new CanchaBean("nombreCancha", "Local");
            l.add(a);            
        }%>
        <% CanchaBean b = new CanchaBean();
        b = (CanchaBean) l.get(1); 
        %>

        <%---  ---%>


        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <title> Creación de partidos </title>
    </head>
    <body>
        
        <div class="intro-header">

            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                <div class="panel panel-info">
                    
                    <div class="panel-heading">
                        <h3 class="panel-title"><%= "Creación de partido nuevo" %></h3>
                    </div>
                    
                    <div class="panel-body">

                            <div class=" col-md-9 col-lg-9 "> 
                                <form method="post" action="PartidoServlet">
                                    <table class="table table-user-information">
                                        <tbody>
                                            
                                            <h4>Fecha</h4>
                                           <div class="input-group">
                                                <input type="text" class="form-control" placeholder="dd/mm/aa">
                                           </div> 

                                            
                                            <h4>Cancha</h4>
                                            
                                                <% for(int i=0; i<l.size(); i++){
                                                    CanchaBean c = new CanchaBean();
                                                    c = (CanchaBean) l.get(i); %>
                                                    
                                                    <input type="radio" name="canchas" id="canchas" value="<%= c.getId() %>" checked>
                                                        <%= c.getId() %>
                                                        <br>
                                                <% } %>

                                            <h4>Turno</h4>
                                            <div class="radio">
                                                <label>
                                                  <input type="radio" name="turnos" id="turnos" value="turno1" checked>
                                                  Mañana
                                                </label>
                                                <label>
                                                  <input type="radio" name="turnos" id="turnos" value="turno2" >
                                                  Tarde
                                                </label>
                                                <label>
                                                  <input type="radio" name="turnos" id="turnos" value="turno3" >
                                                  Noche
                                                </label>
                                            </div>
                                        </tbody>
                                    </table>
                                    
                                    <div class="btn-group">
                                        <button type="submit" class="btn btn-default" value="crear">Crear</button>
                                        <button type="reset" class="btn btn-default" value="Limpiar">Limpiar</button>
                                    </div>   
                                    
                                    
                                    <a href="index.html" class="btn btn-default">Volver</a>
                                    
                                </form>
                            </div>


                </div>
            </div>
        </div>
    </div>           

</div>
</body>
</html>
