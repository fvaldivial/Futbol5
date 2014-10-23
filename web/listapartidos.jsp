<%-- 
    Document   : listapartidos
    Created on : 13/10/2014, 01:50:53 PM
    Author     : Rafael
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

        <%List p = (List) request.getAttribute("partidos");%>
        <%String usuario = (String) request.getAttribute("usuario");%>
        <%List l = p; %>
        
        
        <%
        for(int i=0; i<5; i++){
            PartidoBean p2 = new PartidoBean();
            p2.setId("asdasd");
            p2.setFechai("ayer");
            p2.setCancha("tu jato");
            l.add(p2);            
        }%>
        
        <%--
        <% PartidoBean b = new PartidoBean();
        b = (PartidoBean) l.get(1); 
        %>
        --%>
        <%---  ---%>

        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <title> Lista de partidos </title>
    </head>
    
    
    
    <body>
        
        <div class="intro-header">

            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                <div class="panel panel-info">
                    
                    <div class="panel-heading">
                        <h3 class="panel-title"><%= "Lista de partidos" %></h3>
                        <h4 class="panel-title"><%= usuario %></h4>
                    </div>
                    
                    <div class="panel-body">

                        <div class=" col-md-9 col-lg-9 "> 
                                <table class="table table-user-information">
                                    <tbody>

                                            <% for(int i=0; i<l.size(); i++){
                                                
                                                PartidoBean a = new PartidoBean();
                                                a = (PartidoBean) l.get(i); %>
                                                
                                                <label>FECHA: <%= a.getFechai().toString() %></label>
                                                
                                                <br>
                                                
                                                <label>LUGAR: <%= a.getCancha()%></label>
                                                
                                                <br>
                                                
                                                <form action="SERVLET X" method="post">
                                                    <div class="btn-group">
                                                    
                                                        <button type="submit" class="btn btn-default" value="ver">Ver información</button>
                                                    
                                                        <input type="hidden" name="partido" value="<%= a.getId() %>" />                                                        
                                                                                                                
                                                        <button type="submit" class="btn btn-default" value="salir">Salir del partido</button>
                                                    
                                                    </div>      
                                                </form>
                                                        
                                                <br>
                                                    
                                            <% } %>

                                    </tbody>
                                </table>

                                <a href="index.html" class="btn btn-default">Volver</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>           

    </body>
</html>
