package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Campos2.css\">\n");
      out.write("        <title>Metodo Simplex</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <header>\n");
      out.write("            <section class=\"jumbotron \">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                      <h1>Método Simplex</h1> \n");
      out.write("                      <p>Optimizando recursos con programación lineal</p>\n");
      out.write("                </div>\n");
      out.write("            </section>    \n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("        <section class=\"main container-fluid\">\n");
      out.write("            <div class=\"row \">\n");
      out.write("                <article class=\"col-md-6 borde\">\n");
      out.write("                    <ul class=\"list-group\">\n");
      out.write("                        <li class=\"list-group-item disabled\">Pasos para desarrollar el método Simplex</li>\n");
      out.write("                        <li class=\"list-group-item\">1. Pasar de la forma algebraica a la forma estandar</li>\n");
      out.write("                        <li class=\"list-group-item\">2. Pasar los datos a la tabla</li>\n");
      out.write("                        <li class=\"list-group-item\">3. Encontrar el coeficiente menor en la fila alfa <em>(Maximización)</em></li>\n");
      out.write("                        <li class=\"list-group-item\">3. Encontrar el coeficiente mayor en la fila alfa <em>(Minimización)</em></li>\n");
      out.write("                        <li class=\"list-group-item\">4. Hallar el coeficiente Ri</li>\n");
      out.write("                        <li class=\"list-group-item\">5. Identificar el pivote</li>\n");
      out.write("                        <li class=\"list-group-item\">6. Identificar la fila que sale y la columna que entra ,y realizar el respectivo cambio</li>\n");
      out.write("                        <li class=\"list-group-item\">7. Convertir el pivote en 1 y los demas coeficientes de su columna en 0</li>\n");
      out.write("                        <li class=\"list-group-item\">8. Iterar hasta que no hayan mas numeros negativos en la fila alfa <em>(Maximización)</em> </li>\n");
      out.write("                        <li class=\"list-group-item\">8. Iterar hasta que no hayan mas numeros positivos en la fila alfa <em>(Minimización)</em> </li>\n");
      out.write("                    </ul>\n");
      out.write("                </article>\n");
      out.write("                \n");
      out.write("                <article class=\"col-md-6 aux\">\n");
      out.write("                    <h3 class=\"text-primary\">Comenzar <small>Rellena los campos</small></h3>\n");
      out.write("                    <form class=\"form-horizontal \" action=\"Pagina2.jsp\" method=\"post\" >\n");
      out.write("                        <div class=\"form-group \">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <label class=\"sr-only\">Variables</label>\n");
      out.write("                                <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-pawn\"></span> </div>\n");
      out.write("                                <input class=\"form-control\" required=\"\" min=\"1\" max=\"6\" type=\"number\" name=\"datos\" id=\"variabless\" placeholder=\"¿Cuantas variables tiene el problema?\">\n");
      out.write("                            </div>\n");
      out.write("                                <span class=\"help-block\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <label class=\"sr-only\">Restricciones</label>\n");
      out.write("                                <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-ban-circle\"></span></div>\n");
      out.write("                                <input class=\"form-control\" required=\"\" min=\"1\" max=\"5\" type=\"number\" name=\"datos\" id=\"restriccioness\" placeholder=\"¿Cuantas restricciones tiene el problema?\"> \n");
      out.write("                            </div>\n");
      out.write("                                <span class=\"help-block \"></span>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <p class=\"help-block\">El problema es de : </p>\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <label class=\"sr-only\">Opciones</label>\n");
      out.write("                                <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-sort\"></span></div>\n");
      out.write("                                <select class=\"form-control\" name=\"datos\"> \n");
      out.write("                                    <option>Maximizacion</option>\n");
      out.write("                                    <option>Minimizacion</option>\n");
      out.write("                                </select>   \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input class=\"btn btn-success\" type=\"submit\" value=\"Continuar\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </article>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <footer>\n");
      out.write("            <div class=\"container\">    \n");
      out.write("                <h4><em>Daniel Felipe Junca Chavez - Investigacion de operaciones</em></h4>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        \n");
      out.write("        <script src=\"http://code.jquery.com/jquery.js\"></script>\n");
      out.write("        <script src=\"//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"Validacion.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
