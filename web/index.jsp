<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="Campos2.css">
        <title>Metodo Simplex</title>
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
        
        <section class="main container-fluid">
            <div class="row ">
                <article class="col-md-6 borde">
                    <ul class="list-group">
                        <li class="list-group-item disabled">Pasos para desarrollar el método Simplex</li>
                        <li class="list-group-item">1. Pasar de la forma algebraica a la forma estandar</li>
                        <li class="list-group-item">2. Pasar los datos a la tabla</li>
                        <li class="list-group-item">3. Encontrar el coeficiente menor en la fila alfa <em>(Maximización)</em></li>
                        <li class="list-group-item">3. Encontrar el coeficiente mayor en la fila alfa <em>(Minimización)</em></li>
                        <li class="list-group-item">4. Hallar el coeficiente Ri</li>
                        <li class="list-group-item">5. Identificar el pivote</li>
                        <li class="list-group-item">6. Identificar la fila que sale y la columna que entra ,y realizar el respectivo cambio</li>
                        <li class="list-group-item">7. Convertir el pivote en 1 y los demas coeficientes de su columna en 0</li>
                        <li class="list-group-item">8. Iterar hasta que no hayan mas numeros negativos en la fila alfa <em>(Maximización)</em> </li>
                        <li class="list-group-item">8. Iterar hasta que no hayan mas numeros positivos en la fila alfa <em>(Minimización)</em> </li>
                    </ul>
                </article>
                
                <article class="col-md-6 aux">
                    <h3 class="text-primary">Comenzar <small>Rellena los campos</small></h3>
                    <form class="form-horizontal " action="Pagina2.jsp" method="post" >
                        <div class="form-group ">
                            <div class="input-group">
                                <label class="sr-only">Variables</label>
                                <div class="input-group-addon"><span class="glyphicon glyphicon-pawn"></span> </div>
                                <input class="form-control" required="" min="1" max="6" type="number" name="datos" id="variabless" placeholder="¿Cuantas variables tiene el problema?">
                            </div>
                                <span class="help-block"></span>
                        </div>
                        
                        <div class="form-group">
                            <div class="input-group">
                                <label class="sr-only">Restricciones</label>
                                <div class="input-group-addon"><span class="glyphicon glyphicon-ban-circle"></span></div>
                                <input class="form-control" required="" min="1" max="5" type="number" name="datos" id="restriccioness" placeholder="¿Cuantas restricciones tiene el problema?"> 
                            </div>
                                <span class="help-block "></span>
                        </div>
                        
                        <div class="form-group">
                            <p class="help-block">El problema es de : </p>
                            <div class="input-group">
                                <label class="sr-only">Opciones</label>
                                <div class="input-group-addon"><span class="glyphicon glyphicon-sort"></span></div>
                                <select class="form-control" name="datos"> 
                                    <option>Maximizacion</option>
                                    <option>Minimizacion</option>
                                </select>   
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <input class="btn btn-success" type="submit" value="Continuar">
                        </div>
                    </form>
                </article>
            </div>
        </section>
        
        <footer>
            <div class="container">    
                <h4><em>Daniel Felipe Junca Chavez - Investigacion de operaciones</em></h4>
            </div>
        </footer>
        
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="Validacion.js"></script>
    </body>
</html>
