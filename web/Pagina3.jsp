<%@page import="java.lang.Object"%>
<%@page import="Class1.Modelo.Fraccion"%>
<%@page import="Class1.Modelo.Simplex"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Class1.Modelo.Validaciones"%>
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
        <link rel="stylesheet" href="Campos3.css">

        <title>JSP Page</title>
    </head>
    
    <body>
        
        <%String FuncionObjetivo[]=request.getParameterValues("funcionobjetivo");%>
        <%String Restricciones[]=request.getParameterValues("restricciones");%> 
        <%String Resultados[]=request.getParameterValues("resultados");%> 
        <%int s=(Restricciones.length/FuncionObjetivo.length);%>
        <%int tamañoColumnas=(((FuncionObjetivo.length)+s)+3);%>
        <%Validaciones aux=new Validaciones();%>
        <%Simplex aux2=new Simplex();%>
        <%String z=aux2.getTipo();%>
        <%int [][] Tabla = aux2.CrearMatriz(s+1,2+(FuncionObjetivo.length)+s,s+1,FuncionObjetivo,Restricciones,Resultados,z);%>
        <%Fraccion[][] matrizFraccion =aux2.ConvertidorFraccion(Tabla);%>
        
        
        <%ArrayList<Fraccion[][]> BaseDatos = new ArrayList<>();%>
        <%BaseDatos=aux2.Simplex(matrizFraccion, z);%>
        <%int [] fo=aux.stringint(FuncionObjetivo);%>
        <%int [] re=aux.stringint(Restricciones);%>
        <%int [] res=aux.stringint(Resultados);%>
        <%int auxfila=0;%>
        <%int auxcolumna=0;%>
        <%ArrayList<Integer> actu = new ArrayList<>();%>
        <%int actuaxu=0;%>
        <%int fila=0;%>
         <%int columna=0;%>
        
        

       
        
        <header>
            <section class="jumbotron ">
                <div class="container">
                      <h1>Método Simplex</h1> 
                      <p>Optimizando recursos con programación lineal</p>
                </div>
            </section>    
        </header>
        
        
        <div class="container">
            
            <%for(int t2=0;t2<BaseDatos.size();t2++){%>
            <br>
            <%if(t2==0){%>
            <legend>Tabla inicial</legend>
            <%}else{%>
            <legend>Iteracion  <%=t2%></legend>
            <%}%>
            
            <table class="table table-striped table-bordered" id="tablainicial">
                
                <tr class="success">
                    <th>VB</th>
                    <th>Z</th>
                    <%for(int i=0;i<FuncionObjetivo.length;i++){%>   
                        <th>X<%=i+1%></th>
                    <%}%>
                    <%for(int i=0;i<s;i++){%>   
                        <th>S<%=i+1%></th>
                    <%}%>
                    <th>B</th>
                </tr>
                
                
                
                <%for(int j=0;j<s+1;j++){%>
                
                    <tr>
                        <%for(int i=0;i<tamañoColumnas;i++){%> 
                             <%if(j==0 && i==0){%>
                                  <td ><b>Z</b></td>
                             <%}else if(i==0 && j>0){%>
                                  
                                   <%if(j==fila){%>
                      
                                   
                                   <td><b>X<%=columna-1%></b></td>
                                   
                                   
                                   <%}else{%>
                                   <td><b>S<%=j%></b></td>
                                   <%}%>
                                  
                             <%}else{%>
                             
                             <%if(t2==BaseDatos.size()-1 && j==0 && i==tamañoColumnas-1){%>
                             <td id="<%=t2%><%=j%><%=i%>" class="fondo"><%=BaseDatos.get(t2)[auxfila][auxcolumna-1]%></td>  
                             <%}else{%>
                             <td id="<%=t2%><%=j%><%=i%>"><%=BaseDatos.get(t2)[auxfila][auxcolumna-1]%></td> 
                               <%}%>
                               
                             <%}%> 
                            <%auxcolumna++;%> 
                        <%}%>
                        <%auxcolumna=0;%>
                    </tr>
                   <%auxfila++;%> 
                <%}%>
                
                <%
                
               if(t2<BaseDatos.size()-1){
                ArrayList<Object> pivotea=new ArrayList<>(); 
                pivotea=aux2.Pivote(BaseDatos.get(t2),z);
                fila=(int)pivotea.get(1);
                columna=(int)pivotea.get(0)+1;
                //actu.add(fila);
                //actu.add(columna);
                }    
               
                %>
                
                
            </table> 
            <legend></legend>
            
            <%if(t2<BaseDatos.size()-1){%>
            <a id="<%=t2%> "class="btn btn-success" onclick="busquedad('<%=t2%><%=fila%><%=columna%>');">Seleccionar pivote</a>
            <%
                
            %>
            <%}else{%>
            <a href="#ventana1" class="btn btn-primary" data-toggle="modal" >Forma estandar</a>
            <a class="btn btn-danger" href="/sawdark/Pagina2.jsp">Regresar</a>
            <a class="btn btn-success" href="/sawdark/Pagina2.jsp">Ingresar otro problema</a>
            <%}%>
            <br>
            <%auxfila=0;%>
            
            <%}%>   
            
            
            <div class="modal fade" id="ventana1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title text-primary">Forma estandar</h4>
                        </div>
                        <div class="modal-body">
                            <legend class="text-success">Funcion objetivo</legend>
                            <label class="text-primary"><h4><%=z%> (z) = </h4></label>
                            <%for(int i=0;i<fo.length;i++){%>
                                
                                <%if(fo[i]>0 && i==0){%>
                                    <label><h4><%=fo[i]%></h4></label>
                                    <label class="text-danger"><h4>X<%=i+1%></h4></label>
                                <%}%>
                                
                                <%if(fo[i]>0 && i>0){%>
                                    <label class="text-success"><h4>+</h4></label>
                                    <label><h4><%=fo[i]%></h4></label>
                                    <label class="text-danger"><h4>X<%=+1%></h4></label>
                                <%}%>
                                
                                <%if(fo[i]<0){%>
                                    <%fo[i]=fo[i]*-1;%>
                                    <label  class="text-success"><h4>−</h4></label>
                                    <label><h4><%=fo[i]%></h4></label>
                                    <label class="text-danger"><h4>X<%=i+1%></h4></label>
                                     <%fo[i]=fo[i]*-1;%>
                                <%}%>
                                
                            <%}%>

                             
                            
                            <div> 
                                <%if(z.equalsIgnoreCase("Maximizacion")){%>
                                    <label class="text-primary"><h4>1.</h4></label>
                                    <label><h4>Z</h4></label>
                                    <%for(int i=0;i<fo.length;i++){%>
                                
                                        <%fo[i]=fo[i]*-1;%>
                                   
                                        <%if(fo[i]>0){%>
                                            <label class="text-success"><h4>+</h4></label>
                                            <label><h4><%=fo[i]%></h4></label>
                                            <label class="text-danger"><h4>X<%=+1%></h4></label>
                                        <%}%>
                                
                                        <%if(fo[i]<0){%>
                                            <%fo[i]=fo[i]*-1;%>
                                            <label  class="text-success"><h4>−</h4></label>
                                            <label><h4><%=fo[i]%></h4></label>
                                            <label class="text-danger"><h4>X<%=i+1%></h4></label>
                                        <%}%>
                                
                                        <%if(i==(fo.length)-1){%>
                                            <label  class="text-success"><h4>=</h4></label>
                                            <label><h4>0</h4></label>
                                        <%}%>  
                                    <%}%>
                                <%}else{%>
                                 <label><h4>Estoy confundido4</h4></label>
                                <%}%>
                              
                            </div>
                            
                            <legend></legend>
                            <legend class="text-success">Restricciones</legend>
                            <%int ayuda=0;%>
                            <%for(int i=0;i<s+1;i++){%>
                                <div>
                                    <label  class="text-primary"><h4><%=i+2%>.</h4></label>
                                    <%for(int j=0;j<fo.length;j++){%>     
                                         <%if(i<(s+1)-1){%>
                                         
                                            <%if(re[j+ayuda]!=0){%>
                                            <%if(re[j+ayuda]>=0 && j==0){%>
                                                <%if(re[j+ayuda]==1){%>
                                                <label class="text-danger"><h4>X<%=j+1%></h4></label>
                                                <%}else{%>
                                                <label><h4><%=re[j+ayuda]%></h4></label>
                                                <label class="text-danger"><h4>X<%=j+1%></h4></label>
                                                <%}%>  
                                            <%}%>
                                            
                                
                                            <%if(re[j+ayuda]>=0 && j>0){%>
                                            <%if(re[j+ayuda]==1){%>
                                                <label class="text-success"><h4>+</h4></label>
                                                <label class="text-danger"><h4>X<%=j+1%></h4></label>
                                                <%}else{%>
                                                 <label class="text-success"><h4>+</h4></label>
                                                 <label><h4><%=re[j+ayuda]%></h4></label>
                                                 <label class="text-danger"><h4>X<%=j+1%></h4></label>
                                                <%}%>       
                                            <%}%>
                                
                                            <%if(re[j+ayuda]<0){%>
                                                <%re[j+ayuda]=re[j+ayuda]*-1;%>
                                                 <%if(re[j+ayuda]==1){%>
                                                    <label  class="text-success"><h4>−</h4></label>
                                                    <label class="text-danger"><h4>X<%=j+1%></h4></label>
                                                 <%}else{%>
                                                    <label  class="text-success"><h4>−</h4></label>
                                                    <label><h4><%=re[j+ayuda]%></h4></label>
                                                    <label class="text-danger"><h4>X<%=j+1%></h4></label>
                                                 <%}%>
                                                
                                            <%}%>
                                            <%}%>
                                            
                                
                                            <%if(j==((fo.length)-1)){%>
                                                <label class="text-success"><h4>+</h4></label>
                                                <label class="text-danger"><h4>S<%=i+1%></h4></label>
                                                <label  class="text-success"><h4>=</h4></label>
                                                <label ><h4><%=res[i]%></h4></label>
                                            <%}%>
                                    <%}else{%>
                                        <%if(j==(fo.length)-1){%>
                                            <%for(int x=0;x<fo.length;x++){%>
                                                <label class="text-danger"><h4>X<%=x+1%></h4></label>
                                                <label  class="text-success"><h4>,</h4></label>
                                            <%}%>
                                            <%for(int t=0;t<s;t++){%>
                                                <label class="text-danger"><h4>S<%=t+1%></h4></label>
                                                <%if(t<s-1){%>
                                                    <label  class="text-success"><h4>,</h4></label>
                                                <%}else{%>
                                                    <label  class="text-success"><h4>≥</h4></label>
                                                    <label><h4>0</h4></label>
                                                <%}%>
                                            <%}%>
                                      <%}%>
                                  <%}%>
                            <%}%>
                            <%ayuda=ayuda+fo.length;%>
                            </div>
                           
                            <%}%>
                            
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
             <br>
        </div> 
        
        
       
            
        <footer>
                <div class="container">    
                    <h4><em>Daniel Felipe Junca Chavez - Investigacion de operaciones</em></h4>
                </div>
        </footer>     
    
    <script src="Validacion.js"></script>                        
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    
    </body>
</html>
