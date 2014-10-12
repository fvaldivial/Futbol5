<%-- 
    Document   : index
    Created on : 08/09/2014, 01:40:43 PM
    Author     : GooMoonRyong
--%>

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

        <%---  ---%>


        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <title> Pagina de <%= usuario%> </title>
    </head>
    <body>

        <div class="container">
            <div class="row">

                <div class="col-md-6">
                    <div class="panel with-nav-tabs panel-info">
                        <div class="panel-heading">
                            
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1info" data-toggle="tab">Editar perfil</a></li>
                                
                                <li><a href="#tab3info" data-toggle="tab">no tocar</a></li>
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown">Inscripcion<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        
                                        
                                    </ul>
                                </li>
                                <li><a href="index.html" >Salir</a></li>
                            </ul>
                            
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="intro-header">



            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"><%= usuario %></h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 " align="center">
                                <img alt="User Pic" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQPPpGPpBU-CeawafyfRtPZZ8bHvSlKfks3aqf3ZMkrrz8QXXF8FQ" class="img-circle" width="130px" height ="100px "> </div>

                            <div class=" col-md-9 col-lg-9 "> 
                                <table class="table table-user-information">
                                    <tbody>
                                        
                                    </tbody>
                                </table>

                                <a href="#" class="btn btn-primary">Modificar datos</a>
                                         <a href="index.html" class="btn btn-primary">Salir a inicio</a>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>           

</div>
</body>
</html>
