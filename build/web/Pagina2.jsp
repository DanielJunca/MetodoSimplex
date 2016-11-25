<%@page import="Class1.Modelo.Simplex"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="Campos.css">
        <link rel="stylesheet" href="Campos2.css">
        <title>Pagina2</title>
    </head>
    
    <body>
        
         <header>
            <section class="jumbotron ">
                <div class="container">
                      <h1>Método Simplex</h1> 
                      <p>Optimizando recursos con programación lineal</p>
                </div>
            </section>    
        </header>
        
        <%--Captura de los datos--%>
            <%String Datos[]=request.getParameterValues("datos");%>
            <%Simplex auxz=new Simplex();%>
            <%auxz.setTipo(Datos[2]);%>
            <% int CantidadVariables=Integer.parseInt(Datos[0]);%>
            <% int CantidadRestricciones=Integer.parseInt(Datos[1]);%>
            
        <%--Fin de la captura de los datos--%>
        
            <section class="main container">
                <div class="row">
                    
                    <form class="form-inline" action="Pagina3.jsp" method="post">
                            <div id="div_varibles">
                                <legend><%=Datos[2]%> (z) =</legend>
                                
                                    <%
                                        for(int i=0;i<CantidadVariables;i++){  
                                    %>
                                             <div class="input-group">
                                             <input id="x<%=i+1%>" name="funcionobjetivo" type="number" required="" class="form-control">
                                             <div class="input-group-addon">X<%=i+1%></div>
                                            </div>
                                            <%if(i<CantidadVariables-1){%>
                                            <input class="btn btn-primary" disabled="" value="+" id="signo" name="signo">
                                            <%}%>
                                        <%}%>
                            </div>
                            <br>
                            <legend></legend>
                            
                            
                            <div id="restricciones">
                                <legend>Restricciones</legend>
                                <%for(int i=0;i<CantidadRestricciones;i++){%> 
                                <label class="text-primary"><%=i+1%>.</label>
                                    <%for(int j=0;j<CantidadVariables;j++){%>
                                    <div class="input-group"> 
                                        <input id="nR<%=i+1%><%=j+1%>" name="restricciones" type="number" required="" class="form-control">
                                        <div class="input-group-addon">X<%=j+1%></div>       
                                    </div>
                                   <%if(j<CantidadVariables-1){%>
                                            <input class="btn btn-primary" disabled="" value="+" id="signo" name="signo">
                                   <%}else if(j==CantidadVariables-1){%>
                                         <input class="btn btn-danger" disabled="" value="≤" id="signo" name="signo">
                                         <input id="nR<%=i+1%><%=(j+1)+1%>" name="resultados" type="number" required="" class="form-control">
                                       <%}%>  
                                <%}%>
                                <br>
                                <br>
                                <%}%>
                            </div>
                            
                            <legend></legend>
                            <input class="btn btn-success" type="submit" value="Continuar"> 
                            <a class="btn btn-danger" href="/sawdark/Pagina2.jsp">Regresar</a>
                        </form>
                            <br>
                 </div>
            </section>
                 
                 
                 
            <footer>
                <div class="container">    
                    <h4><em>Daniel Felipe Junca Chavez - Investigacion de operaciones</em></h4>
                </div>
            </footer>     
    
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
    </body>
</html>
