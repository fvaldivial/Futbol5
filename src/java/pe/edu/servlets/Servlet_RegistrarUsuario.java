/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.UsuarioBean;
import pe.edu.clases.UsuarioDAO;
import pe.edu.clases.Usuarios5IF;


@WebServlet(name = "Servlet_RegistrarUsuario", urlPatterns = {"/Servlet_RegistrarUsuario"})
public class Servlet_RegistrarUsuario extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);
        
        
        //Paso 2: recuperar datos
        String dni = request.getParameter("first_name");
        String telefono = request.getParameter("last_name");
        String ncompleto = request.getParameter("display_name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String passc = request.getParameter("password_confirmation");
        
        
        //Paso 3: logica
        Usuarios5IF f = new UsuarioDAO();
        boolean respuesta=false;
                
        if(pass.equals(passc)){
            UsuarioBean usu = new UsuarioBean(dni, email, ncompleto, telefono);
            try {
                respuesta= f.registrarUsuario(usu, pass);
            } catch (Exception ex) {
                Logger.getLogger(Servlet_RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            respuesta = false;
        }    
        
        //Paso 4: pasar datos a la pagina
        
        //Te va a pasar a una pagina de felicitacion si te pudiste logear, si no te regresa
        
        
        //Paso 5: enviar a la pagina
        
        if(respuesta == true){
            
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Felicidades!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Usuario creado correctamente </h1>");
            out.println("<a href= 'loguin.html'>Ya puedes comenzar</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }else{
             PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Error!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Error al crear usuario </h1>");
            out.println("<h1> Intentelo nuevamente </h1>");
            out.println("<a href= 'Inscripcion.html'>Intentarlo de nuevo</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
    }
}
