/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import com.mongodb.DBObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.UsuarioBean;
import pe.edu.clases.UsuarioDAO;
import pe.edu.clases.Usuarios5IF;

@WebServlet(name = "Servlet_login", urlPatterns = {"/Servlet_login"})
public class Servlet_login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");

        //Paso 3: logica
       // Usuarios5IF f = new UsuarioDAO();
//        DBObject usu = f.Login(pass, usuario);
//        UsuarioBean user = new UsuarioBean();

        //Paso 4: pasar datos a la pagina
//        //Paso 5: enviar a la pagina
//        if (usu.get("_id") != null) {

//            user.setDni((String) usu.get("_id"));
//            user.setEmail((String) usu.get("email"));
//            user.setNombre((String) usu.get("nombre"));
//            user.setTelefono((String) usu.get("telf"));
//            String[] a = {"1","2"};
//            user.setPartidos(a);
//           
//               System.out.println("a"+user.getDni());
               if(usuario.equals("algo") && pass.equals("algo")){
                    String[] a = {"1","2"};
            UsuarioBean user = new UsuarioBean("74027507"," Titanes@Armin.Mikasa", "Eren jeager", "945982081", a);   
               
            request.setAttribute("usuario", user);

            System.out.println(user.getDni());
            System.out.println(user.getNombre());

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        } else {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Error!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ingreso mal la contraseña o el usuario </h1>");
            out.println("<h1> Intentelo nuevamente </h1>");
            out.println("<a href= 'loguin.html'>Intentarlo de nuevo</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}
